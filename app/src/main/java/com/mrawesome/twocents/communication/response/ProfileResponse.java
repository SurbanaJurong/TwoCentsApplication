package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.data.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileResponse implements Response {
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
    private Set<String> users = new HashSet<>();
    private Set<String> events = new HashSet<>();

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
        events.addAll(eventRegistered);
        this.userBookmarked = userBookmarked;
        users.addAll(userBookmarked);
    }

    @Override
    public ResponseType type() {
        return ResponseType.Profile;
    }

    @Override
    public Set<String> getUserIds() {
        return null;
    }

    @Override
    public Set<String> getEventIds() {
        return null;
    }
}
