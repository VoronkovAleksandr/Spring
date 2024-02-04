package ru.voronkov.HomeWork003.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.voronkov.HomeWork003.services.RegistrationService;
import ru.voronkov.HomeWork003.services.UserService;

@Controller
public class UserControler {

    RegistrationService registrationService;
    public String userAddFromParam(){

        return "";
    }
}
