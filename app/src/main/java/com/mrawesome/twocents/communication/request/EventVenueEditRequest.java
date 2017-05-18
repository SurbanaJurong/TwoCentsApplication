package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventVenueEditRequest extends Request {

    private String eventId;
    private String venueId;

    EventVenueEditRequest(String eventId, String venueId) {
        this.eventId = eventId;
        this.venueId = venueId;
    }

    @Override
    public RequestType type() {
        return RequestType.EventVenueEdit;
    }

    @Override
    public String getRequestParams() {
        append(RequestFactory.e_eventId, eventId);
        append(RequestFactory.e_venueId, venueId);
        return stringBuilder.toString();
    }
}
