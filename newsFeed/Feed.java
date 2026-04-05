package newsFeed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thread-safe Feed.
 *
 * Uses a ReadWriteLock so that:
 *  - Multiple threads can READ (getRankedPosts) concurrently.
 *  - WRITE (addPost / removePost) is exclusive.
 */
public class Feed {
    private final String ownerId;
    private final List<Post> posts;
    private final ReadWriteLock lock;
    private volatile RankingStrategy rankingStrategy;  // volatile for visibility

    private static final int DEFAULT_PAGE_SIZE = 20;

    public Feed(String ownerId, RankingStrategy rankingStrategy) {
        this.ownerId          = ownerId;
        this.posts            = new ArrayList<>();
        this.lock             = new ReentrantReadWriteLock();
        this.rankingStrategy  = rankingStrategy;
    }

    /** Add a post to this feed. */
    public void addPost(Post post) {
        lock.writeLock().lock();
        try {
            posts.add(post);
        } finally {
            lock.writeLock().unlock();
        }
    }

    /** Remove a post from this feed (e.g. when a user unfollows). */
    public boolean removePost(String postId) {
        lock.writeLock().lock();
        try {
            return posts.removeIf(p -> p.getPostId().equals(postId));
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * Returns a paginated, ranked snapshot of the feed.
     *
     * @param page  0-indexed page number
     * @param size  page size (defaults to DEFAULT_PAGE_SIZE)
     */
    public List<Post> getRankedPosts(int page, int size) {
        lock.readLock().lock();
        try {
            // Snapshot under read lock, then rank outside the lock
            List<Post> snapshot = new ArrayList<>(posts);
            List<Post> ranked   = rankingStrategy.rank(snapshot);

            int from = page * size;
            if (from >= ranked.size()) return new ArrayList<>();
            int to = Math.min(from + size, ranked.size());
            return ranked.subList(from, to);
        } finally {
            lock.readLock().unlock();
        }
    }

    /** Convenience overload using default page size. */
    public List<Post> getRankedPosts(int page) {
        return getRankedPosts(page, DEFAULT_PAGE_SIZE);
    }

    /** Hot-swap the ranking algorithm without restarting (open for extension). */
    public void setRankingStrategy(RankingStrategy strategy) {
        this.rankingStrategy = strategy;   // volatile write — safe without locking
    }

    public RankingStrategy getRankingStrategy() { return rankingStrategy; }
    public String          getOwnerId()         { return ownerId; }

    public int size() {
        lock.readLock().lock();
        try   { return posts.size(); }
        finally { lock.readLock().unlock(); }
    }

    @Override
    public String toString() {
        return String.format("Feed{owner='%s', posts=%d, strategy=%s}",
                ownerId, size(), rankingStrategy);
    }
}
