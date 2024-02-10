package ru.voronkov.HomeWork004.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork004.models.User;
import ru.voronkov.HomeWork004.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor // Lombok @AllArgsConstructor генерирует конструктор с одним параметром для каждого поля класса
public class UserService {
    private UserRepository userRepository;

    // Получаем список пользователей из БД
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // Добавляем пользователя в БД
    public User saveUser(User user){
        return userRepository.save(user);
    }

    // Обновляем данные пользователя в БД
    public User updateUser(User user){
        return userRepository.update(user);
    }

    // Получаем пользователя из БД по Id
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    // Удаляем пользователя из БД
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    // Получаем количество записей в БД
    public int getUsersCount() {
        return findAll().size();
    }
}
