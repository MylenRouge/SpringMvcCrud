package ru.web.service;

import ru.web.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User showUsers(Integer id);
    void saveUsers(User user);
    void updateUser(Integer id, User updatedUser);
    void deleteUser(Integer id);
}
