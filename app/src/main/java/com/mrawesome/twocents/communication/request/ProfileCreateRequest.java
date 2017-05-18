package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileCreateRequest extends Request {

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
        append(RequestFactory.p_username, username);
        append(RequestFactory.p_phoneNumber, phoneNumber);
        append(RequestFactory.p_nric, nric);
        append(RequestFactory.p_postalCode, postalCode);
        append(RequestFactory.p_year, year);
        return stringBuilder.toString();
    }
}
