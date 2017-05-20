package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.VolatileEvent;
import com.mrawesome.twocents.data.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventResponse extends Response {

    private VolatileEvent[] events;
    private Set<String> users = new HashSet<>();

    EventResponse(VolatileEvent[] events) {
        this.events = events;
        for (VolatileEvent event : events) {
            users.add(event.getHost());
            for (String username : event.getUserRegistered()) {
                users.add(username);
            }
            for (String username : event.getParticipants()) {
                users.add(username);
            }
        }
    }

    @Override
    public ResponseType type() {
        return ResponseType.Event;
    }

    @Override
    public Set<String> getUserIds() {
        return users;
    }

    @Override
    public Set<String> getEventIds() {
        return EMPTY;
    }
}
