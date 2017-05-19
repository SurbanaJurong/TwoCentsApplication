package com.mrawesome.twocents.data;

import com.mrawesome.twocents.communication.response.NotificationType;

import io.realm.RealmObject;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Notification extends RealmObject {

    private int seqNum;
    private int notificationType;
    private String sender;
    private String eventId;

    public Notification() {};

    public Notification(NotificationType notificationType, String sender, String eventId) {
        this.notificationType = notificationType.getCode();
        this.sender = sender;
        this.eventId = eventId;
    }

    public int getNotificationType() {
        return this.notificationType;
    }

    public String getSender() {
        return this.sender;
    }

    public String getEventId() {
        return this.eventId;
    }
}
