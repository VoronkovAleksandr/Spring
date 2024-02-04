package ru.voronkov.HomeWork003.services;

import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork003.models.User;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}
