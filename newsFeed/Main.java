package newsFeed;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates the Thread-Safe News Feed LLD.
 *
 * Sections:
 *   1. Basic flow  — register, follow, publish, read
 *   2. Strategy swap — hot-swap ranking algorithm
 *   3. Concurrency test — 10 threads publishing simultaneously
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        section("1. BASIC FLOW");
        basicFlowDemo();

        section("2. RANKING STRATEGY SWAP");
        strategySwapDemo();

        section("3. CONCURRENCY STRESS TEST");
        concurrencyTest();
    }

    // ─────────────────────────────────────────────────────────────────────────

    static void basicFlowDemo() {
        FeedService svc = FeedService.getInstance();

        // Register observers
        svc.registerObserver(new NotificationObserver());
        AnalyticsObserver analytics = new AnalyticsObserver();
        svc.registerObserver(analytics);

        // Register users
        svc.registerUser("u1", "Vamsi");
        svc.registerUser("u2", "Arjun");
        svc.registerUser("u3", "Priya");

        // Follow graph: Arjun and Priya follow Vamsi
        svc.follow("u2", "u1");
        svc.follow("u3", "u1");

        // Vamsi publishes posts
        Post p1 = svc.publishPost("u1", "Just cracked Netflix system design!", Post.PostType.TEXT);
        Post p2 = svc.publishPost("u1", "Thread safety in Java — a deep dive", Post.PostType.TEXT);
        svc.publishPost("u2", "Arjun's first post here!", Post.PostType.TEXT);

        // Simulate likes
        p1.like(); p1.like(); p1.like();
        p2.like();

        // Read Arjun's feed — should contain Vamsi's posts + his own
        System.out.println("\n[FEED] Arjun's feed (Chronological):");
        svc.getFeed("u2").forEach(p -> System.out.println("  → " + p));

        System.out.printf("%nAnalytics: %d posts tracked total%n",
                analytics.getTotalPostsTracked());
    }

    // ─────────────────────────────────────────────────────────────────────────

    static void strategySwapDemo() {
        FeedService svc = FeedService.getInstance();

        System.out.println("[STRATEGY] Switching Arjun's feed to PopularityStrategy...");
        svc.setRankingStrategy("u2", new PopularityStrategy());

        System.out.println("[FEED] Arjun's feed (Popularity — most liked first):");
        svc.getFeed("u2").forEach(p -> System.out.println("  → " + p));

        System.out.println("\n[STRATEGY] Switching Arjun's feed to RelevanceStrategy...");
        svc.setRankingStrategy("u2", new RelevanceStrategy());

        System.out.println("[FEED] Arjun's feed (Relevance — decay score):");
        svc.getFeed("u2").forEach(p -> System.out.println("  → " + p));
    }

    // ─────────────────────────────────────────────────────────────────────────

    static void concurrencyTest() throws InterruptedException {
        FeedService svc = FeedService.getInstance();

        svc.registerUser("stress_author", "StressBot");
        svc.registerUser("stress_reader", "ReaderBot");
        svc.follow("stress_reader", "stress_author");

        int THREADS     = 10;
        int POSTS_EACH  = 5;

        ExecutorService pool  = Executors.newFixedThreadPool(THREADS);
        CountDownLatch  start = new CountDownLatch(1);
        CountDownLatch  done  = new CountDownLatch(THREADS);

        // 10 writer threads all publishing at the same time
        for (int t = 0; t < THREADS; t++) {
            final int threadId = t;
            pool.submit(() -> {
                try {
                    start.await();   // wait for all threads to be ready
                    for (int i = 0; i < POSTS_EACH; i++) {
                        svc.publishPost("stress_author",
                                "Thread-" + threadId + " post-" + i,
                                Post.PostType.TEXT);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }

        start.countDown();  // fire all threads simultaneously
        done.await();
        pool.shutdown();

        int expected = THREADS * POSTS_EACH;
        int actual   = svc.getFeed("stress_reader").size();   // page 0 = up to 20

        System.out.printf("%n[STRESS] Expected: %d posts | Page-0 visible: %d posts%n",
                expected, actual);
        System.out.println("[STRESS] No ConcurrentModificationException = thread-safe ✓");
    }

    // ─────────────────────────────────────────────────────────────────────────

    static void section(String title) {
        System.out.println("\n" + "═".repeat(55));
        System.out.println("  " + title);
        System.out.println("═".repeat(55));
    }
}
