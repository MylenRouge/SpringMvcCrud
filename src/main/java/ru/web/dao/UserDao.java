package ru.web.dao;

import ru.web.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User showUsers(int id);
    void saveUsers(User user);
    void updateUser(int id, User updateUserdUser);
    void deleteUser(int id);

}
