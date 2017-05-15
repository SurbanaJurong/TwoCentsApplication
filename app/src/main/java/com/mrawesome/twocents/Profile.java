package com.mrawesome.twocents;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.data.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Profile {

    private String username;
    private String profilePic;
    private String phoneNumber;
    private String nric;
    private String postalCode;
    private int year;
    private Date dateCreated;
    private Set<Interest> interests;
    private List<Notification> notifications;
    private Map<Interest, Integer> attendances;
    private Set<Event> events;
    private Set<User> users;

    private static Profile instances = null;

    public static Profile getInstance() {
        if (instances == null) {
            instances = new Profile();
        }
        return instances;
    }

    private Profile() {
        importProfileData();
    }

    private static void importProfileData() {

    }

    public String getUsername() {
        return this.username;
    }

    public String getProfilePic() {
        return this.profilePic;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getNric() {
        return this.nric;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - this.year;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public Set<Interest> getInterests() {
        return this.interests;
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public Map<Interest, Integer> getAttendances() {
        return this.attendances;
    }

    public Set<Event> getEvents() {
        return this.events;
    }

    public Set<User> getUsers() {
        return this.users;
    }
}
