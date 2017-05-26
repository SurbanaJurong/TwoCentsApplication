package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.Table;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Comment extends RealmObject {

    @PrimaryKey
    @SerializedName("Id")
    private int id;
    @SerializedName("UserId")
    private int userId;
    @SerializedName("Timestamp")
    private String timeStamp;
    @SerializedName("Content")
    private String content;
    @SerializedName("EventId")
    private int eventId;

    @Override
    public String toString() {
        return id + "|" + userId + "|" + timeStamp + "|" + content;
    }

    public Comment() {}

    public Comment(int sender, String comment) {
        this.userId = sender;
        this.content = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isOwnComment() {
        Realm realm = Realm.getDefaultInstance();
        Profile profile = realm.where(Profile.class).findFirst();
        return userId == profile.getUserId();
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
