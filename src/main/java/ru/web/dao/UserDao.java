package ru.web.dao;

import ru.web.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User showUser(Long id);
    void saveUser(User user);
    void updateUser(User updatedUser);
    void deleteUser(Long id);

}
