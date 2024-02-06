package ru.voronkov.HomeWork003.repositories;

import org.springframework.stereotype.Repository;
import ru.voronkov.HomeWork003.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
