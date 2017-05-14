package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventEditRequest implements Request {

    private String eventId;
    private String profilePic = null;
    private String description = null;
    private Integer minCapacity = null;
    private Integer maxCapacity = null;

    EventEditRequest(String eventId) {
        this.eventId = eventId;
    }

    void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public RequestType type() {
        return RequestType.EventEdit;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
