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
    private int category;
    @Expose
    @SerializedName("Host")
    private int host;
    @Expose
    @SerializedName("Description")
    private String description;
    @Expose
    @SerializedName("IsRecurring")
    private boolean isRecurring;
    @SerializedName("Timestamp")
    private String timeStamp;
    @Expose
    @SerializedName("VenueId")
    private int venueId;
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
    private boolean isCancelled;
    @Expose
    @SerializedName("StartTime")
    private String startTime;
    @Expose
    @SerializedName("Duration")
    private String duration;

    public Event() {
    };

    public Event(String eventName, int category, int host, String description, boolean isRecurring, int venueId, int minCapacity, int maxCapacity, String startTime, String duration) {
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

    public int getHost() {
        return this.host;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getIsRecurring() {
        return this.isRecurring;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public int getVenueId() {
        return this.venueId;
    }

    public boolean getIsCancelled() {
        return this.isCancelled;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getMinCapacity() {
        return this.minCapacity;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public String getDuration() {
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

    public int getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setVenueId(int venueId) {
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

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDuration(String duration) {
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
