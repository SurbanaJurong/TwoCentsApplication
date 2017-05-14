package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileEditRequest implements Request {

    private String username;
    private String profilePic = null;
    private String phoneNumber = null;
    private String postalCode = null;

    ProfileEditRequest() {
        this.username = Profile.getInstance().getUsername();
    }

    void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public RequestType type() {
        return RequestType.ProfileEdit;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
