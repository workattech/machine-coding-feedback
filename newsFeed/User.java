package newsFeed;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private final String userId;
    private final String username;
    // Thread-safe sets backed by ConcurrentHashMap
    private final Set<String> following;  // userIds this user follows
    private final Set<String> followers;  // userIds that follow this user

    public User(String userId, String username) {
        this.userId    = userId;
        this.username  = username;
        this.following = Collections.newSetFromMap(new ConcurrentHashMap<>());
        this.followers = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public void follow(String targetUserId) {
        following.add(targetUserId);
    }

    public void unfollow(String targetUserId) {
        following.remove(targetUserId);
    }

    public void addFollower(String followerUserId)    { followers.add(followerUserId); }
    public void removeFollower(String followerUserId) { followers.remove(followerUserId); }

    public String      getUserId()   { return userId; }
    public String      getUsername() { return username; }
    public Set<String> getFollowing(){ return Collections.unmodifiableSet(following); }
    public Set<String> getFollowers(){ return Collections.unmodifiableSet(followers); }

    @Override
    public String toString() {
        return String.format("User{id='%s', name='%s', following=%d, followers=%d}",
                userId, username, following.size(), followers.size());
    }
}
