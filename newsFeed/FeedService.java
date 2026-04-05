package newsFeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * FeedService  —  Singleton
 *
 * Responsibilities:
 *  1. Manage users and their feeds.
 *  2. Fan-out a new post to all followers' feeds (write-time fanout model).
 *  3. Handle follow/unfollow relationships.
 *  4. Notify registered observers (Observer pattern).
 *
 * Thread-safety:
 *  - userMap and feedMap are ConcurrentHashMaps (safe concurrent reads + writes).
 *  - observers list uses CopyOnWriteArrayList (rare writes, frequent iteration).
 *  - Singleton uses double-checked locking with volatile.
 */
public class FeedService {

    // ── Singleton ────────────────────────────────────────────────────────────

    private static volatile FeedService instance;

    private FeedService() {}  // private constructor

    public static FeedService getInstance() {
        if (instance == null) {
            synchronized (FeedService.class) {
                if (instance == null) {
                    instance = new FeedService();
                }
            }
        }
        return instance;
    }

    // ── State ─────────────────────────────────────────────────────────────────

    private final Map<String, User>            userMap   = new ConcurrentHashMap<>();
    private final Map<String, Feed>            feedMap   = new ConcurrentHashMap<>();
    private final List<FeedObserver>           observers = new CopyOnWriteArrayList<>();

    // Default ranking strategy applied to every new feed
    private volatile RankingStrategy defaultStrategy = new ChronologicalStrategy();

    // ── User Management ───────────────────────────────────────────────────────

    public User registerUser(String userId, String username) {
        User user = new User(userId, username);
        userMap.putIfAbsent(userId, user);
        feedMap.putIfAbsent(userId, new Feed(userId, defaultStrategy));
        return user;
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }

    // ── Follow / Unfollow ─────────────────────────────────────────────────────

    /**
     * followerId follows targetId.
     * Existing posts of targetId are NOT back-filled (real systems use a
     * separate "catch-up" pipeline; keeping it simple here).
     */
    public void follow(String followerId, String targetId) {
        User follower = getOrThrow(followerId);
        User target   = getOrThrow(targetId);

        follower.follow(targetId);
        target.addFollower(followerId);

        System.out.printf("[FOLLOW] '%s' now follows '%s'%n",
                follower.getUsername(), target.getUsername());
    }

    public void unfollow(String followerId, String targetId) {
        User follower = getOrThrow(followerId);
        User target   = getOrThrow(targetId);

        follower.unfollow(targetId);
        target.removeFollower(followerId);

        System.out.printf("[UNFOLLOW] '%s' unfollowed '%s'%n",
                follower.getUsername(), target.getUsername());
    }

    // ── Post Publishing (write-time fan-out) ──────────────────────────────────

    /**
     * Author publishes a post.
     *
     * Fan-out model: post is pushed into every follower's feed immediately.
     * This is the Twitter "push" model — optimal for reads, heavier on writes.
     *
     * For celebrity accounts (millions of followers) you'd use a hybrid model
     * (pull for high-follower-count users), but that's out of scope here.
     */
    public Post publishPost(String authorId, String content, Post.PostType type) {
        getOrThrow(authorId);  // validate author exists

        Post post = new Post(authorId, content, type);

        // Push into the author's own feed
        feedMap.get(authorId).addPost(post);

        // Fan-out to all followers
        User author = userMap.get(authorId);
        for (String followerId : author.getFollowers()) {
            Feed followerFeed = feedMap.get(followerId);
            if (followerFeed != null) {
                followerFeed.addPost(post);
            }
        }

        // Notify all observers asynchronously (fire-and-forget log here)
        notifyObservers(post, authorId);

        System.out.printf("[POST] '%s' published: '%s' | fanout to %d followers%n",
                authorId, content.substring(0, Math.min(30, content.length())),
                author.getFollowers().size());

        return post;
    }

    // ── Feed Retrieval ────────────────────────────────────────────────────────

    /**
     * Fetch the ranked feed for a user (page 0 by default).
     */
    public List<Post> getFeed(String userId, int page) {
        Feed feed = feedMap.get(userId);
        if (feed == null) return Collections.emptyList();
        return feed.getRankedPosts(page);
    }

    public List<Post> getFeed(String userId) {
        return getFeed(userId, 0);
    }

    // ── Strategy Hot-Swap ─────────────────────────────────────────────────────

    /**
     * Change the ranking strategy for a specific user's feed at runtime.
     * Demonstrates Strategy Pattern — no code change, just inject a new algorithm.
     */
    public void setRankingStrategy(String userId, RankingStrategy strategy) {
        Feed feed = feedMap.get(userId);
        if (feed != null) {
            feed.setRankingStrategy(strategy);
            System.out.printf("[STRATEGY] '%s' feed now uses %s%n", userId, strategy);
        }
    }

    /** Change the default strategy for ALL future feeds. */
    public void setDefaultStrategy(RankingStrategy strategy) {
        this.defaultStrategy = strategy;
    }

    // ── Observer Management ───────────────────────────────────────────────────

    public void registerObserver(FeedObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(FeedObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Post post, String authorId) {
        for (FeedObserver obs : observers) {
            try {
                obs.onPostPublished(post, authorId);
            } catch (Exception e) {
                System.err.println("[OBSERVER ERROR] " + e.getMessage());
            }
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private User getOrThrow(String userId) {
        User user = userMap.get(userId);
        if (user == null) throw new IllegalArgumentException("User not found: " + userId);
        return user;
    }

    public Map<String, User> getAllUsers() {
        return Collections.unmodifiableMap(userMap);
    }

    /** For testing only — resets the singleton state. */
    static void reset() {
        instance = null;
    }
}
