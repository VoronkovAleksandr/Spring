package ru.voronkov.HomeWork002.services;

import ru.voronkov.HomeWork002.models.User;
import ru.voronkov.HomeWork002.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}