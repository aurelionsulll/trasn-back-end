package com.example.demo.model.user;

public class CurrentUser {

    public static User user;

    public CurrentUser(User user) {
        CurrentUser.user = user;
    }

    public User getUser() {
        return user;
    }

    public CurrentUser setUser(User user) {
        CurrentUser.user = user;
        return this;
    }
}
