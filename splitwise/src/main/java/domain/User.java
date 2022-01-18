package domain;

public class User {
    private String userId;
    private String name;
    private String email;
    private Integer mobileNo;

    public User(String userId, String name, String email, Integer mobileNo) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getMobileNo() {
        return mobileNo;
    }
}
