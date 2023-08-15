package ru.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.web.model.User;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }
    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        User user = entityManager.merge(updatedUser);
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setAge(updatedUser.getAge());
        entityManager.flush();
    }
    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
