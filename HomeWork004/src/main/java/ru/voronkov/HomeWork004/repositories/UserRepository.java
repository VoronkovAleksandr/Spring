package ru.voronkov.HomeWork004.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.voronkov.HomeWork004.models.User;


import java.util.List;

@Repository
@AllArgsConstructor // Lombok @AllArgsConstructor генерирует конструктор с одним параметром для каждого поля класса
public class UserRepository {

    private final JdbcTemplate jdbc;

    //Возвращаем список всех пользователей из БД
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {

            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    // Сохраняем пользователя в БД
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    // Обновляем данные пользователя в БД
    public User update(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

    // Получение пользователя по Id из БД
    public User getUserById(int id) {
        User user = new User();
        List<User> users = findAll();
        return users.stream().filter(u -> u.getId() == id ).findFirst().orElse(null);
    }


    // Удаление пользователя из БД
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }
}

