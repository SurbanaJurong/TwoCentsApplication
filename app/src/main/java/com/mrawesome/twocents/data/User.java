package com.mrawesome.twocents.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class User extends RealmObject {

    @PrimaryKey
    private String username;
    private String profilePic;
    private String phoneNumber;

    public User() {};

    public User(String username, String profilePic, String phoneNumber) {
        this.username = username;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
    }
}
