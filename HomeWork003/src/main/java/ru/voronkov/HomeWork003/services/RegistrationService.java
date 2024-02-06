package ru.voronkov.HomeWork003.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork003.models.User;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    public  NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    // регистрация пользователя + вывод подтверждения в консоль
    public void processRegistration(User user){
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }
}