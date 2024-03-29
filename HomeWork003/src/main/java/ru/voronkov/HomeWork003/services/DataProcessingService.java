package ru.voronkov.HomeWork003.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork003.models.User;
import ru.voronkov.HomeWork003.repositories.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    // получение ссылки на репозиторий
    public UserRepository getRepository() {
        return repository;
    }


    // сортировка списка пользователей по возрасту
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    // фильтр пользователей по возрасту
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    // вычисление среднего возраста списка прользователей
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    // добавление пользователя в репозиторий
    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }

    // получение всех пользователей из репозитория
    public List<User> getUsers() {
        return repository.getUsers();
    }
}