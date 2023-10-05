package ru.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web.dao.UserDao;
import ru.web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> index() {
        return userDao.index();
    }
    @Transactional
    @Override
    public User showUsers(Integer id) {
        return userDao.showUsers(id);
    }

    @Transactional
    @Override
    public void saveUsers(User user) {
        userDao.saveUsers(user);
    }

    @Transactional
    @Override
    public void updateUser(Integer id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
