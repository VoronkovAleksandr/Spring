package ru.voronkov.HomeWork003.services;

import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork003.models.User;

@Service
public class NotificationService {

    // вывод в консоль информации о создании пользователя
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    // вывод в консоль информации переданной в аргументе
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
