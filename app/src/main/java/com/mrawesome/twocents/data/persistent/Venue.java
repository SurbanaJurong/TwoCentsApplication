package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Venue extends RealmObject {

    @PrimaryKey
    private int venueId;
    private String venueName;
    private Interest category;
    private String postalCode;

    public Venue() {}

    public Venue(int venueId, String venueName, Interest category, String postalCode) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.category = category;
        this.postalCode = postalCode;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Interest getCategory() {
        return category;
    }

    public void setCategory(Interest category) {
        this.category = category;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
