package com.mrawesome.twocents.util;

import com.mrawesome.twocents.communication.response.NotificationType;
import com.mrawesome.twocents.data.Comment;
import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.User;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Reader {

    private Reader() {};

    public static User readSingleUser(Scanner scanner) {
        User[] arr = readUser(1, scanner);
        return arr[0];
    }

    public static Event readSingleEvent(Scanner scanner) {
        Event[] arr = readEvent(1, scanner);
        return arr[0];
    }

    public static Interest readSingleInterest(Scanner scanner) {
        Interest[] arr = readInterest(1, scanner);
        return arr[0];
    }

    public static Notification readSingleNotification(Scanner scanner) {
        Notification[] arr = readNotification(1, scanner);
        return arr[0];
    }

    public static User[] readUser(int size, Scanner scanner) {
        User[] arr = new User[size];
        for (int i = 0; i < size; i++) {
            String username = scanner.next();
            String profilePic = scanner.next();
            String phoneNumber = scanner.next();
            arr[i] = new User(username, profilePic, phoneNumber);
        }
        return arr;
    }

    public static Event[] readEvent(int size, Scanner scanner) {
        Event[] arr = new Event[size];
        for (int i = 0; i < size; i++) {
            String eventId = scanner.next();
            String host = scanner.next();
            String profilePic = scanner.next();
            String description = scanner.next();
            int isRecurring = scanner.nextInt();
            long dateCreated = scanner.nextLong();
            String venueId = scanner.next();
            int minCapacity = scanner.nextInt();
            int maxCapacity = scanner.nextInt();
            int uSize = scanner.nextInt();
            Set<String> userRegistered = new HashSet<>();
            for (int j = 0; j < uSize; j++) {
                String username = scanner.next();
                userRegistered.add(username);
            }
            int pSize = scanner.nextInt();
            Set<String> participants = new HashSet<>();
            for (int j = 0; j < pSize; j++) {
                String username = scanner.next();
                userRegistered.add(username);
            }
            int cSize = scanner.nextInt();
            List<Comment> chat = new ArrayList<>();
            for (int j = 0; j < cSize; j++) {
                String sender = scanner.next();
                String message = scanner.next();
                Comment comment = new Comment(sender, message);
                chat.add(comment);
            }
            int venueStatus = scanner.nextInt();
            long startTime = scanner.nextLong();
            int duration = scanner.nextInt();
            arr[i] = new Event(eventId, host, profilePic, description, Event.EventMode.valueOf(isRecurring), dateCreated, venueId, minCapacity, maxCapacity, userRegistered, participants, chat, Event.VenueStatus.valueOf(venueStatus), startTime, duration);
        }
        return arr;
    }

    public static Interest[] readInterest(int size, Scanner scanner) {
        Interest[] arr = new Interest[size];
        for (int i = 0; i < size; i++) {
            String subject = scanner.next();
            arr[i] = new Interest(subject);
        }
        return arr;
    }

    public static Notification[] readNotification(int size, Scanner scanner) {
        Notification[] arr = new Notification[size];
        for (int i = 0; i < size; i++) {
            int notificationType = scanner.nextInt();
            String sender = scanner.next();
            String eventId = scanner.next();
            arr[i] = new Notification(NotificationType.valueOf(notificationType), sender, eventId);
        }
        return arr;
    }

    public static void collapse(String str) {
        str.replace(" ", "|");
    }

    public static void expand(String str) {
        str.replace("|", " ");
    }

}
