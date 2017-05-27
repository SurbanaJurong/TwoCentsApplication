package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class User extends RealmObject {

    @PrimaryKey
    @SerializedName("Id")
    private int id;
    @SerializedName("UserName")
    private String username;
    @SerializedName("ProfilePic")
    private String profilePic;
    @SerializedName("Phone")
    private String phoneNumber;

    public User() {}

    public User(String username, String profilePic, String phoneNumber) {
        this.username = username;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
