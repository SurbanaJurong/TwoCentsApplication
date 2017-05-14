package com.mrawesome.twocents.util;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.User;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;

import java.util.Scanner;

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
        return arr;
    }

    public static Interest[] readInterest(int size, Scanner scanner) {
        Interest[] arr = new Interest[size];
        return arr;
    }

    public static Notification[] readNotification(int size, Scanner scanner) {
        Notification[] arr = new Notification[size];
        return arr;
    }

}
