package org.example.mvc.model;

public class User {
    // Field add => userid, name
    private final String userId;
    private final String name;

    // User Constructor => userId, name
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // getUserId Constructor => userId
    public String getUserId() {
        return userId;
    }

    // getName Constructor => name
    public String getName() {
        return name;
    }
}
