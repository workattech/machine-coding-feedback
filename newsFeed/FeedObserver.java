package newsFeed;

/**
 * Observer interface (Observer Pattern).
 *
 * FeedService notifies all registered observers whenever a post is published.
 * This decouples notification logic (push notifications, analytics, etc.)
 * from the core feed service.
 */
public interface FeedObserver {
    void onPostPublished(Post post, String authorId);
}


// ─── Concrete Observer: Notification Logger ──────────────────────────────────

class NotificationObserver implements FeedObserver {
    @Override
    public void onPostPublished(Post post, String authorId) {
        System.out.printf("[NOTIFY] New post by '%s' → '%s'%n",
                authorId, post.getContent().substring(0, Math.min(40, post.getContent().length())));
    }
}


// ─── Concrete Observer: Analytics Tracker ────────────────────────────────────

class AnalyticsObserver implements FeedObserver {
    private volatile long totalPostsTracked = 0;

    @Override
    public synchronized void onPostPublished(Post post, String authorId) {
        totalPostsTracked++;
        System.out.printf("[ANALYTICS] Total posts tracked: %d | type=%s%n",
                totalPostsTracked, post.getType());
    }

    public long getTotalPostsTracked() { return totalPostsTracked; }
}
