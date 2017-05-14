package com.mrawesome.twocents.data;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Venue {

    private String venueId;
    private String venueName;
    private Interest category;
    private String postalCode;

    Venue(String venueId, String venueName, Interest category, String postalCode) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.category = category;
        this.postalCode = postalCode;
    }
}
