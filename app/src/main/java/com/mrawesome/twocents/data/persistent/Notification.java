package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.SerializedName;
import com.mrawesome.twocents.data.enumerate.NotificationType;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.Table;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Notification extends RealmObject {

    @PrimaryKey
    @SerializedName("Id")
    private int id;
    @SerializedName("Type")
    private int type;
    @SerializedName("SenderId")
    private int senderId;
    @SerializedName("EventId")
    private int eventId;

    public Notification() {}

    public Notification(NotificationType notificationType, int sender, int eventId) {
        this.type = notificationType.getCode();
        this.senderId = sender;
        this.eventId = eventId;
    }

    public int getType() {
        return this.type;
    }

    public int getSenderId() {
        return this.senderId;
    }

    public int getEventId() {
        return this.eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
