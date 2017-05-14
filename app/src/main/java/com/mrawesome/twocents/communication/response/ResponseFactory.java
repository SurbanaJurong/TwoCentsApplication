package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.User;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Notification;
import com.mrawesome.twocents.util.Reader;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                case Calendar:
                    return newCalendarResponse(scanner);
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
        String profilePic = scanner.next();
        String phoneNumber = scanner.next();
        String nric = scanner.next();
        String postalCode = scanner.next();
        int year = scanner.nextInt();
        long dateCreated = scanner.nextLong();
        int iSize = scanner.nextInt();
        Interest[] interests = Reader.readInterest(iSize, scanner);
        int nSize = scanner.nextInt();
        Notification[] notifications = Reader.readNotification(nSize, scanner);
        int eSize = scanner.nextInt();
        Event[] events = Reader.readEvent(eSize, scanner);
        int uSize = scanner.nextInt();
        User[] users = Reader.readUser(uSize, scanner);
        return new ProfileResponse(profilePic, phoneNumber, nric, postalCode, year, dateCreated, interests, notifications, events, users);
    }

    private static CalendarResponse newCalendarResponse(Scanner scanner) {
        return null;
    }

    private static EventResponse newEventResponse(Scanner scanner) {
        int size = scanner.nextInt();
        Event[] events = Reader.readEvent(size, scanner);
        return new EventResponse(events);

    }

    private static UserResponse newUserResponse(Scanner scanner) {
        int size = scanner.nextInt();
        User[] users = Reader.readUser(size, scanner);
        return new UserResponse(users);
    }

    private static NotificationResponse newNotificationResponse(Scanner scanner) {
        int type = scanner.nextInt();
        NotificationType notificationType = NotificationType.valueOf(type);
        User guestUser = Reader.readSingleUser(scanner);
        Event event = Reader.readSingleEvent(scanner);
        return new NotificationResponse(notificationType, guestUser, event);
    }
}
