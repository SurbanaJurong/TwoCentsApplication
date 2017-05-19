package com.mrawesome.twocents;

import com.mrawesome.twocents.data.Document;
import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.data.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
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
    private long dateCreated;
    private RealmList<Interest> interests;
    private RealmList<Notification> notifications;
    private RealmList<Document> attendances;
    private RealmList<Event> events;
    private RealmList<User> users;

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
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
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
        for (Document document : this.attendances) {
            attendances.put(new Interest(document.key), document.value);
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
        RealmQuery<Document> query = Realm.getDefaultInstance().where(Document.class).contains("key", interest.getSubject());
        Document document = query.findFirst();
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

    public static void setInstance(Profile instance) {
        Profile.instance = instance;
    }
}
