package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.Expose;
import com.mrawesome.twocents.fragment.addInterest.AddInterestFragment1;
import com.mrawesome.twocents.ui.AddInterestActivity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Event extends RealmObject {
    /**
     * Created by mrawesome on 14/5/17.
     */

    @PrimaryKey
    @Required
    private String eventId;
    @Expose
    private String eventName;
    @Expose
    private Interest category;
    @Expose
    private String host;
    @Expose
    private String description;
    @Expose
    private int isRecurring;
    private long dateCreated;
    @Expose
    private String venueId;
    @Expose
    private int minCapacity;
    @Expose
    private int maxCapacity;
    private RealmList<User> userRegistered = new RealmList<>();
    private RealmList<User> participants = new RealmList<>();
    private RealmList<Comment> chat = new RealmList<>();
    private int venueStatus;
    @Expose
    private long startTime;
    @Expose
    private int duration;

    public Event() {
    };

    public Event(String eventName, String category, String host, String description, int isRecurring, String venueId, int minCapacity, int maxCapacity, long startTime, int duration) {
        this.eventName = eventName;
        //debug
        this.category = new Interest(category, AddInterestFragment1.basketballAva);
        this.host = host;
        this.description = description;
        this.isRecurring = isRecurring;
        this.venueId = venueId;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.startTime = startTime;
        this.duration = duration;
    }

    public String getEventId() {
        return this.eventId;
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

    public long getDateCreated() {
        return this.dateCreated;
    }

    public String getVenueId() {
        return this.venueId;
    }

    public int getVenueStatus() {
        return this.venueStatus;
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

    public String getEventName() {
        return eventName;
    }

    public Interest getCategory() {
        return category;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
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

    public void setVenueStatus(int venueStatus) {
        this.venueStatus = venueStatus;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
