package com.mrawesome.twocents.data.volatil;

import com.mrawesome.twocents.data.persistent.Comment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mrawesome on 20/5/17.
 */

public class RetroEvent {

    private String eventId;
    private String eventName;
    private String category;
    private String host;
    private String profilePic;
    private String description;
    private int isRecurring;
    private long dateCreated;
    private String venueId;
    private int minCapacity;
    private int maxCapacity;
    private Set<String> userRegistered = new HashSet<>();
    private Set<String> participants = new HashSet<>();
    private List<Comment> chat = new ArrayList<>();
    private int venueStatus;
    private long startTime;
    private int duration;

    public RetroEvent(String eventId, String eventName, String category, String host, String profilePic, String description, int isRecurring, long dateCreated, String venueId, int minCapacity, int maxCapacity, Set<String> userRegistered, Set<String> participants, List<Comment> chat, int venueStatus, long startTime, int duration) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.category = category;
        this.host = host;
        this.profilePic = profilePic;
        this.description = description;
        this.isRecurring = isRecurring;
        this.dateCreated = dateCreated;
        this.venueId = venueId;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.userRegistered.addAll(userRegistered);
        this.participants.addAll(participants);
        this.chat.addAll(chat);
        this.venueStatus = venueStatus;
        this.startTime = startTime;
        this.duration = duration;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCategory() {
        return category;
    }

    public String getHost() {
        return host;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getDescription() {
        return description;
    }

    public int getIsRecurring() {
        return isRecurring;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public String getVenueId() {
        return venueId;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Set<String> getUserRegistered() {
        return userRegistered;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public List<Comment> getChat() {
        return chat;
    }

    public int getVenueStatus() {
        return venueStatus;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }
}
