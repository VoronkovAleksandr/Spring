package ru.voronkov.HomeWork003.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork003.models.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;


    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
    public List<User> getAllUsers(){

    }
}