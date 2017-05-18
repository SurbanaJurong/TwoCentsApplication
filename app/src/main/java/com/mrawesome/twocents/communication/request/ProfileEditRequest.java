package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ProfileEditRequest extends Request {

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
        append(RequestFactory.p_username, username);
        append(RequestFactory.p_profilePic, profilePic);
        append(RequestFactory.p_phoneNumber, phoneNumber);
        append(RequestFactory.p_postalCode, postalCode);
        return stringBuilder.toString();
    }
}
