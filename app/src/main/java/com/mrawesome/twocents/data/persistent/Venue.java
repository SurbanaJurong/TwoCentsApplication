package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Venue extends RealmObject {

    @PrimaryKey
    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("InterestId")
    private Interest interestId;
    @SerializedName("Location")
    private String location;

    public Venue() {}

    public Venue(int venueId, String venueName, Interest category, String postalCode) {
        this.id = venueId;
        this.name = venueName;
        this.interestId = category;
        this.location = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Interest getInterestId() {
        return interestId;
    }

    public void setInterestId(Interest interestId) {
        this.interestId = interestId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
