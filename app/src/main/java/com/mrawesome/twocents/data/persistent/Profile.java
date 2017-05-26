package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 27/5/17.
 */

public class Profile extends RealmObject {
    private static final Profile ourInstance = new Profile();

    public static Profile getInstance() {
        return ourInstance;
    }

    @PrimaryKey
    @SerializedName("Id")
    private int userId;
    @Expose
    @SerializedName("UserName")
    private String username;
    @SerializedName("ProfilePic")
    private String profilePic;
    @Expose
    @SerializedName("Phone")
    private String phoneNumber;
    @Expose
    @SerializedName("NRIC")
    private String nric;
    @Expose
    @SerializedName("Location")
    private String location;
    @Expose
    @SerializedName("Year")
    private int year;
    @SerializedName("Timestamp")
    private String timeStamp;
    @SerializedName("Interests")
    private RealmList<Interest> interests = new RealmList<>();
    @SerializedName("Notifications")
    private RealmList<Notification> notifications = new RealmList<>();
    @SerializedName("Attendances")
    private RealmList<Attendance> attendances = new RealmList<>();
    @SerializedName("EventRegistered")
    private RealmList<Event> events = new RealmList<>();
    @SerializedName("UserBookmarked")
    private RealmList<User> users = new RealmList<>();

    @Override
    public String toString() {
        return userId + "|" + username + "|" + phoneNumber + "|" + year + "|" + location + "|" + nric;
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

    public String getLocation() {
        return this.location;
    }

    public int getAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - this.year;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }


    public Set<Event> getEvents() {
        Set<Event> events = new HashSet<>();
        events.addAll(this.events);
        return events;
    }

    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        users.addAll(this.users);
        return users;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void addToInterests(Set<Interest> interests) {
        this.interests.addAll(interests);
    }

    public void removeFromInterests(Set<Interest> interests) {
        for (Interest interest : interests) {
            if (this.interests.indexOf(interest) != -1) {
                this.interests.remove(interest);
            }
        }
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications.addAll(notifications);
    }

    public void incrementAttendances(Interest interest) {
        RealmQuery<Attendance> query = Realm.getDefaultInstance().where(Attendance.class).equalTo("id", interest.getId());
        Attendance document = query.findFirst();
        document.setCount(document.getCount() + 1);
    }

    public void setEvents(Set<Event> events) {
        for (Event event : events) {
            if (this.events.indexOf(event) != -1) {
                this.events.add(event);
            }
        }
    }

    public void setUsers(Set<User> users) {
        for (User user : users) {
            if (this.users.indexOf(user) != -1) {
                this.users.add(user);
            }
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getYear() {
        return year;
    }

    public void setInterests(RealmList<Interest> interests) {
        this.interests = interests;
    }

    public void setNotifications(RealmList<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setAttendances(RealmList<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void setEvents(RealmList<Event> events) {
        this.events = events;
    }

    public void setUsers(RealmList<User> users) {
        this.users = users;
    }

    public RealmList<Interest> getInterests() {
        return interests;
    }

    public RealmList<Notification> getNotifications() {
        return notifications;
    }

    public RealmList<Attendance> getAttendances() {
        return attendances;
    }
}
