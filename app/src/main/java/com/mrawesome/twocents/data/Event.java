package com.mrawesome.twocents.data;

import com.mrawesome.twocents.util.Reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Event {
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

    private String eventId;
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

    public Event(String eventId, String host, String profilePic, String description, EventMode isRecurring, long dateCreated, String venueId, int minCapacity, int maxCapacity, Set<String> userRegistered, Set<String> participants, List<Comment> chat, VenueStatus venueStatus, long startTime, int duration) {
        this.eventId = eventId;
        this.host = host;
        this.profilePic = profilePic;
        Reader.expand(description);
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
}
