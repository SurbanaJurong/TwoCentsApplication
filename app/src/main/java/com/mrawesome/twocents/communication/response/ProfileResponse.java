package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.data.User;

import java.util.Date;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileResponse implements Response {
    private String profilePic;
    private String phoneNumber;
    private String nric;
    private String postalCode;
    private int year;
    private Date dateCreated;
    private Interest[] interests;
    private Notification[] notifications;
    private Event[] eventRegistered;
    private User[] userBookmarked;

    ProfileResponse(String profilePic, String phoneNumber, String nric, String postalCode, int year, long dateCreated, Interest[] interests, Notification[] notifications, Event[] events, User[] users) {
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
        this.nric = nric;
        this.postalCode = postalCode;
        this.year = year;
        this.dateCreated = new Date(dateCreated);
        this.interests = interests;
        this.notifications = notifications;
        this.eventRegistered = events;
        this.userBookmarked = users;
    }

    @Override
    public ResponseType type() {
        return ResponseType.Profile;
    }
}
