package newsFeed;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// ─── Strategy Interface ───────────────────────────────────────────────────────

public interface RankingStrategy {
    /**
     * Ranks a list of posts according to the strategy's algorithm.
     *
     * @param posts raw unordered list of posts
     * @return a new ranked list (original list is NOT mutated)
     */
    List<Post> rank(List<Post> posts);
}


// ─── Concrete Strategy 1: Chronological (newest first) ───────────────────────

class ChronologicalStrategy implements RankingStrategy {
    @Override
    public List<Post> rank(List<Post> posts) {
        return posts.stream()
                .sorted(Comparator.comparing(Post::getCreatedAt).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() { return "ChronologicalStrategy"; }
}


// ─── Concrete Strategy 2: Popularity (most liked first) ──────────────────────

class PopularityStrategy implements RankingStrategy {
    @Override
    public List<Post> rank(List<Post> posts) {
        return posts.stream()
                .sorted(Comparator.comparingInt(Post::getLikes).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() { return "PopularityStrategy"; }
}


// ─── Concrete Strategy 3: Relevance (likes + recency blended score) ──────────

class RelevanceStrategy implements RankingStrategy {
    private static final long HALF_LIFE_SECONDS = 3600; // 1 hour

    @Override
    public List<Post> rank(List<Post> posts) {
        long now = System.currentTimeMillis() / 1000;

        return posts.stream()
                .sorted(Comparator.comparingDouble(
                        (Post p) -> score(p, now)).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Simple decay-based score:
     *   score = likes / (ageInSeconds / HALF_LIFE + 1)
     *
     * A brand-new post with 0 likes scores 0.
     * A 0-age post with N likes scores N.
     * Older posts gradually lose relevance.
     */
    private double score(Post post, long nowSeconds) {
        long ageSeconds = nowSeconds - post.getCreatedAt().getEpochSecond();
        double decayFactor = (double) ageSeconds / HALF_LIFE_SECONDS + 1.0;
        return post.getLikes() / decayFactor;
    }

    @Override
    public String toString() { return "RelevanceStrategy"; }
}
