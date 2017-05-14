package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.User;

/**
 * Created by mrawesome on 14/5/17.
 */

public class NotificationResponse implements Response {

    private NotificationType notificationType;
    private User sender;
    private Event event;

    NotificationResponse(NotificationType notificationType, User sender, Event event) {
        this.notificationType = notificationType;
        this.sender = sender;
        this.event = event;
    }

    @Override
    public ResponseType type() {
        return ResponseType.Notification;
    }
}
