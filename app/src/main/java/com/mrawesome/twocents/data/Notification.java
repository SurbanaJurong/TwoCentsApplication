package com.mrawesome.twocents.data;

import com.mrawesome.twocents.communication.response.NotificationType;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Notification {

    private NotificationType notificationType;
    private User sender;
    private Event event;

    public Notification(NotificationType notificationType, User sender, Event event) {
        this.notificationType = notificationType;
        this.sender = sender;
        this.event = event;
    }
}
