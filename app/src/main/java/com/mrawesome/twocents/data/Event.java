package com.mrawesome.twocents.data;

import com.mrawesome.twocents.util.StreamReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Event extends RealmObject {
    /**
     * Created by mrawesome on 14/5/17.
     */

    public enum EventMode {
        Recurring(0), OneTime(1);

        private int code;

        EventMode(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static EventMode valueOf(int code) {
            return code == 0 ? Recurring : OneTime;
        }
    }

    public enum VenueStatus {
        Cancelled(0), Pending(1), Booked(2);

        private int code;
        private static Map<Integer, VenueStatus> index = new HashMap<>();

        VenueStatus(int code) {
            this.code = code;
        }

        static {
            for (VenueStatus v : EnumSet.allOf(VenueStatus.class)) {
                index.put(v.code, v);
            }
        }

        public int getCode() {
            return this.code;
        }

        public static VenueStatus valueOf(int code) {
            return index.get(code);
        }
    }

    @PrimaryKey
    private String eventId;
    private String eventName;
    private Interest category;
    private String host;
    private String profilePic;
    private String description;
    private EventMode isRecurring;
    private Calendar dateCreated;
    private String venueId;
    private int minCapacity;
    private int maxCapacity;
    private Set<String> userRegistered = new HashSet<>();
    private Set<String> participants = new HashSet<>();
    private List<Comment> chat = new ArrayList<>();
    private VenueStatus venueStatus;
    private Calendar startTime;
    private int duration;

    public Event(String eventId, String eventName, String category, String host, String profilePic, String description, EventMode isRecurring, long dateCreated, String venueId, int minCapacity, int maxCapacity, Set<String> userRegistered, Set<String> participants, List<Comment> chat, VenueStatus venueStatus, long startTime, int duration) {
        this.eventId = eventId;
        StreamReader.expand(eventName);
        this.eventName = eventName;
        this.category = new Interest(category);
        this.host = host;
        this.profilePic = profilePic;
        StreamReader.expand(description);
        this.description = description;
        this.isRecurring = isRecurring;
        this.dateCreated = Calendar.getInstance();
        this.dateCreated.setTimeInMillis(dateCreated);
        this.venueId = venueId;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.userRegistered.addAll(userRegistered);
        this.participants.addAll(participants);
        this.chat.addAll(chat);
        this.venueStatus = venueStatus;
        this.startTime = Calendar.getInstance();
        this.startTime.setTimeInMillis(startTime);
        this.duration = duration;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getHost() {
        return this.host;
    }

    public String getProfilePic() {
        return this.profilePic;
    }

    public String getDescription() {
        return this.description;
    }

    public EventMode getIsRecurring() {
        return this.isRecurring;
    }

    public Calendar getDateCreated() {
        return this.dateCreated;
    }

    public String getVenueId() {
        return this.venueId;
    }

    public VenueStatus getVenueStatus() {
        return this.venueStatus;
    }

    public Calendar getStartTime() {
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

    public Set<String> getUserRegistered() {
        return this.userRegistered;
    }

    public Set<String> getParticipants() {
        return this.participants;
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

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsRecurring(EventMode isRecurring) {
        this.isRecurring = isRecurring;
    }

    public void setDateCreated(Calendar dateCreated) {
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

    public void setUserRegistered(Set<String> userRegistered) {
        this.userRegistered = userRegistered;
    }

    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }

    public void setChat(List<Comment> chat) {
        this.chat = chat;
    }

    public void setVenueStatus(VenueStatus venueStatus) {
        this.venueStatus = venueStatus;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
