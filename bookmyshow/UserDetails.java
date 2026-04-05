package bookmyshow;


class UserDetails {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private UserProfile profile;

    // Constructors, getters, and setters

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public String getUserId() {
        return userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

