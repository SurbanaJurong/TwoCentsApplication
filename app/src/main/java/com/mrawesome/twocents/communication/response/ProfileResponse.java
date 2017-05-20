package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;

import java.util.Date;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileResponse extends Response {
    private String username;
    private String profilePic;
    private String phoneNumber;
    private String nric;
    private String postalCode;
    private int year;
    private Date dateCreated;
    private Interest[] interests;
    private Notification[] notifications;
    private Set<String> eventRegistered;
    private Set<String> userBookmarked;

    ProfileResponse(String username, String profilePic, String phoneNumber, String nric, String postalCode, int year, long dateCreated, Interest[] interests, Notification[] notifications, Set<String> eventRegistered, Set<String> userBookmarked) {
        this.username = username;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
        this.nric = nric;
        this.postalCode = postalCode;
        this.year = year;
        this.dateCreated = new Date(dateCreated);
        this.interests = interests;
        this.notifications = notifications;
        this.eventRegistered = eventRegistered;
        this.userBookmarked = userBookmarked;
    }

    @Override
    public ResponseType type() {
        return ResponseType.Profile;
    }

    @Override
    public Set<String> getUserIds() {
        return this.userBookmarked;
    }

    @Override
    public Set<String> getEventIds() {
        return this.eventRegistered;
    }
}
