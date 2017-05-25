package com.mrawesome.twocents.data.persistent;

import com.mrawesome.twocents.data.enumerate.NotificationType;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Notification extends RealmObject {

    @PrimaryKey
    private int notificationId;
    private int notificationType;
    private String sender;
    private int eventId;

    public Notification() {}

    public Notification(NotificationType notificationType, String sender, int eventId) {
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

    public int getEventId() {
        return this.eventId;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
