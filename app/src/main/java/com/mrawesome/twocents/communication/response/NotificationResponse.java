package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.data.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class NotificationResponse implements Response {

    private Notification[] notifications;
    private Set<String> users = new HashSet<>();
    private Set<String> events = new HashSet<>();

    NotificationResponse(Notification[] notifications) {
        this.notifications = notifications;
        for (Notification notification : this.notifications) {
            users.add(notification.getSender());
            events.add(notification.getEventId());
        }
    }

    @Override
    public ResponseType type() {
        return ResponseType.Notification;
    }

    @Override
    public Set<String> getUserIds() {
        return users;
    }

    @Override
    public Set<String> getEventIds() {
        return events;
    }
}
