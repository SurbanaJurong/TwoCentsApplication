package com.mrawesome.twocents.data;

/**
 * Created by mrawesome on 14/5/17.
 */

public class User {
    private String username;
    private String profilePic;
    private String phoneNumber;

    public User(String username, String profilePic, String phoneNumber) {
        this.username = username;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
    }
}
