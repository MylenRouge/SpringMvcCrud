package ru.web.dao;

import ru.web.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User showUsers(Integer id);
    void saveUsers(User user);
    void updateUser(Integer id, User updateUserdUser);
    void deleteUser(Integer id);

}
