package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.User;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.util.StreamReader;

import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class ResponseFactory {

    private ResponseFactory() {};

    public static Response newResponse(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int type = scanner.nextInt();
        ResponseType responseType = ResponseType.valueOf(type);
        try {
            switch (responseType) {
                case Profile:
                    return newProfileResponse(scanner);
                case Event:
                    return newEventResponse(scanner);
                case User:
                    return newUserResponse(scanner);
                default:
                    return newNotificationResponse(scanner);
            }
        } catch (InputMismatchException e) {
            return new NullResponse();
        }
    }

    private static ProfileResponse newProfileResponse(Scanner scanner) {
        String username = scanner.next();
        String profilePic = scanner.next();
        String phoneNumber = scanner.next();
        String nric = scanner.next();
        String postalCode = scanner.next();
        int year = scanner.nextInt();
        long dateCreated = scanner.nextLong();
        int iSize = scanner.nextInt();
        Interest[] interests = StreamReader.readInterest(iSize, scanner);
        int nSize = scanner.nextInt();
        Notification[] notifications = StreamReader.readNotification(nSize, scanner);
        int eSize = scanner.nextInt();
        Set<String> events = new HashSet<>();
        for (int i = 0; i < eSize; i++) {
            events.add(scanner.next());
        }
        int uSize = scanner.nextInt();
        Set<String> users = new HashSet<>();
        for (int i = 0; i < uSize; i++) {
            users.add(scanner.next());
        }
        return new ProfileResponse(username, profilePic, phoneNumber, nric, postalCode, year, dateCreated, interests, notifications, events, users);
    }

    private static EventResponse newEventResponse(Scanner scanner) {
        int size = scanner.nextInt();
        Event[] events = StreamReader.readEvent(size, scanner);
        return new EventResponse(events);

    }

    private static UserResponse newUserResponse(Scanner scanner) {
        int size = scanner.nextInt();
        User[] users = StreamReader.readUser(size, scanner);
        return new UserResponse(users);
    }

    private static NotificationResponse newNotificationResponse(Scanner scanner) {
        int size = scanner.nextInt();
        Notification[] notifications = StreamReader.readNotification(size, scanner);
        return new NotificationResponse(notifications);
    }
}
