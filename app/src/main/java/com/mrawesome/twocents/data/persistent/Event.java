package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mrawesome.twocents.ui.fragment.addInterest.AddInterestFragment1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Event extends RealmObject {
    /**
     * Created by mrawesome on 14/5/17.
     */

    @PrimaryKey
    @SerializedName("Id")
    private int id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("Category")
    private Interest category;
    @Expose
    @SerializedName("Host")
    private String host;
    @Expose
    @SerializedName("Description")
    private String description;
    @Expose
    @SerializedName("IsRecurring")
    private int isRecurring;
    @SerializedName("Timestamp")
    private String timeStamp;
    @Expose
    @SerializedName("VenueId")
    private String venueId;
    @Expose
    @SerializedName("MinCapacity")
    private int minCapacity;
    @Expose
    @SerializedName("MaxCapacity")
    private int maxCapacity;
    @SerializedName("UserRegistered")
    private RealmList<User> userRegistered = new RealmList<>();
    @SerializedName("Participants")
    private RealmList<User> participants = new RealmList<>();
    @SerializedName("Comments")
    private RealmList<Comment> chat = new RealmList<>();
    @SerializedName("IsCancelled")
    private int isCancelled;
    @Expose
    @SerializedName("StartTime")
    private long startTime;
    @Expose
    @SerializedName("Duration")
    private int duration;

    public Event() {
    };

    public Event(String eventName, Interest category, String host, String description, int isRecurring, String venueId, int minCapacity, int maxCapacity, long startTime, int duration) {
        this.name = eventName;
        //debug
        this.category = category;
        this.host = host;
        this.description = description;
        this.isRecurring = isRecurring;
        this.venueId = venueId;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.startTime = startTime;
        this.duration = duration;
    }

    public int getId() {
        return this.id;
    }

    public String getHost() {
        return this.host;
    }

    public String getDescription() {
        return this.description;
    }

    public int getIsRecurring() {
        return this.isRecurring;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public String getVenueId() {
        return this.venueId;
    }

    public int getIsCancelled() {
        return this.isCancelled;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getMinCapacity() {
        return this.minCapacity;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getDuration() {
        return this.duration;
    }

    public Set<User> getUserRegistered() {
        Set<User> userRegistered = new HashSet<>();
        userRegistered.addAll(this.userRegistered);
        return userRegistered;
    }

    public Set<User> getParticipants() {
        Set<User> participants = new HashSet<>();
        participants.addAll(this.participants);
        return participants;
    }

    public List<Comment> getChat() {
        return this.chat;
    }

    public String getName() {
        return name;
    }

    public Interest getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Interest category) {
        this.category = category;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsRecurring(int isRecurring) {
        this.isRecurring = isRecurring;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addToUserRegistered(Set<User> users) {
        this.userRegistered.addAll(users);
    }

    public void removeFromUserRegistered(Set<User> users) {
        for (User user : users) {
            if (this.userRegistered.indexOf(user) != -1) {
                this.userRegistered.remove(user);
            }
        }
    }

    public void addToParticipants(User user) {
        this.participants.add(user);
    }

    public void removeFromParticipants(User user) {
        if (this.userRegistered.indexOf(user) != -1) {
            this.userRegistered.remove(user);
        }
    }

    public void addToChat(List<Comment> chat) {
        this.chat.addAll(chat);
    }

    public void setIsCancelled(int isCancelled) {
        this.isCancelled = isCancelled;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setUserRegistered(RealmList<User> userRegistered) {
        this.userRegistered = userRegistered;
    }

    public void setParticipants(RealmList<User> participants) {
        this.participants = participants;
    }

    public void setChat(RealmList<Comment> chat) {
        this.chat = chat;
    }
}
