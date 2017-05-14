package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileCreateRequest implements Request {

    private String username;
    private String phoneNumber;
    private String nric;
    private String postalCode;
    private int year;

    ProfileCreateRequest(String username, String phoneNumber, String nric, String postalCode, int year) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.nric = nric;
        this.postalCode = postalCode;
        this.year = year;
    }

    @Override
    public RequestType type() {
        return RequestType.ProfileCreate;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
