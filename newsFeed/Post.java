package newsFeed;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private final String postId;
    private final String authorId;
    private final String content;
    private final Instant createdAt;
    private final AtomicInteger likes;
    private final PostType type;

    public enum PostType {
        TEXT, IMAGE, VIDEO, LINK
    }

    public Post(String authorId, String content, PostType type) {
        this.postId    = UUID.randomUUID().toString();
        this.authorId  = authorId;
        this.content   = content;
        this.createdAt = Instant.now();
        this.likes     = new AtomicInteger(0);
        this.type      = type;
    }

    public void like()           { likes.incrementAndGet(); }
    public void unlike()         { likes.decrementAndGet(); }

    public String  getPostId()   { return postId; }
    public String  getAuthorId() { return authorId; }
    public String  getContent()  { return content; }
    public Instant getCreatedAt(){ return createdAt; }
    public int     getLikes()    { return likes.get(); }
    public PostType getType()    { return type; }

    @Override
    public String toString() {
        return String.format("Post{id='%s', author='%s', likes=%d, at=%s, content='%s'}",
                postId.substring(0, 8), authorId, likes.get(), createdAt, content);
    }
}
