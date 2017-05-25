package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.Expose;
import com.mrawesome.twocents.fragment.addInterest.AddInterestFragment1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Profile extends RealmObject {

    @PrimaryKey
    private int userId;
    @Expose
    private String username;
    private String profilePic;
    @Expose
    private String phoneNumber;
    @Expose
    private String nric;
    @Expose
    private String postalCode;
    @Expose
    private int year;
    private long dateCreated;
    private RealmList<Interest> interests = new RealmList<>();
    private RealmList<Notification> notifications = new RealmList<>();
    private RealmList<Attendance> attendances = new RealmList<>();
    private RealmList<Event> events = new RealmList<>();
    private RealmList<User> users = new RealmList<>();

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

    public Profile() {
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
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - this.year;
    }

    public long getDateCreated() {
        return this.dateCreated;
    }

    public Set<Interest> getInterests() {
        Set<Interest> interests = new HashSet<>();
        interests.addAll(this.interests);
        return interests;
    }

    public Set<Notification> getNotifications() {
        Set<Notification> notifications = new HashSet<>();
        notifications.addAll(this.notifications);
        return notifications;
    }

    public Map<Interest, Integer> getAttendances() {
        Map<Interest, Integer> attendances = new HashMap<>();
        for (Attendance document : this.attendances) {
            //debug
            attendances.put(new Interest(document.key, AddInterestFragment1.basketballAva), document.value);
        }
        return attendances;
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

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
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
        RealmQuery<Attendance> query = Realm.getDefaultInstance().where(Attendance.class).contains("key", interest.getSubject());
        Attendance document = query.findFirst();
        document.value++;
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

    public static void setInstance(Profile instance) {
        Profile.instance = instance;
    }
}
