package com.mrawesome.twocents.data;

import com.mrawesome.twocents.communication.response.NotificationType;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Notification {

    private NotificationType notificationType;
    private String sender;
    private String eventId;

    public Notification(NotificationType notificationType, String sender, String eventId) {
        this.notificationType = notificationType;
        this.sender = sender;
        this.eventId = eventId;
    }

    public NotificationType getNotificationType() {
        return this.notificationType;
    }

    public String getSender() {
        return this.sender;
    }

    public String getEventId() {
        return this.eventId;
    }
}
