package com.mrawesome.twocents.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Venue extends RealmObject {

    @PrimaryKey
    private String venueId;
    private String venueName;
    private Interest category;
    private String postalCode;

    public Venue() {}

    public Venue(String venueId, String venueName, Interest category, String postalCode) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.category = category;
        this.postalCode = postalCode;
    }
}
