package ru.web.service;

import ru.web.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User showUsers(int id);
    void saveUsers(User user);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);
}
