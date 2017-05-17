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

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Profile extends RealmObject {

    @PrimaryKey
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

    private static volatile Profile instance = null;

    public static Profile getInstance() {
        if (instance == null) {
            synchronized (Profile.class) {
                if (instance == null) {
                    instance = new Profile();
                }
            }
        }
        return instance;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setInterests(Set<Interest> interests) {
        this.interests = interests;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setAttendances(Map<Interest, Integer> attendances) {
        this.attendances = attendances;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public static void setInstance(Profile instance) {
        Profile.instance = instance;
    }
}
