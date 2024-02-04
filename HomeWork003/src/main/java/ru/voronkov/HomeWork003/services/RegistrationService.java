package ru.voronkov.HomeWork003.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //Метод processRegistration
    public void processRegistration(String name, int age, String email){
        dataProcessingService.addUserToList(userService.createUser(name,age, email));
        notificationService.sendNotification("User is added");
    }
}