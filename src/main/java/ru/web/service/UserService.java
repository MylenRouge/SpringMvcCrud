package ru.web.service;

import ru.web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User showUser(Long id);
    void saveUser(User user);
    void updateUser(User updatedUser);
    void deleteUser(Long id);
}
