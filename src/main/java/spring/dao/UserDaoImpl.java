package spring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.User;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> index() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
//        List<User> users = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM User";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                User user = new User();
//
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setSurname(resultSet.getString("surname"));
//                user.setAge(resultSet.getInt("age"));
//
//                people.add(user);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return people;
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
//        user.setId(++PEOPLE_COUNT);
//        user.add(user);
//        try (entityManager = Util.getEntityManager()){
//            Statement statement = connection.createStatement();
//            String SQL = "INSERT INTO User VALUES(" + 1 + ",'" + user.getName() +
//                    "'," + user.getSurname() + ",'" + user.getAge() + "')";
//
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
//        User userForUpdate = show(id);
//        User user = entityManager.find(User.class, id);
//        userForUpdate.setName(updatedPerson.getName());
//        userForUpdate.setSurname(updatedPerson.getSurname());
//        userForUpdate.setAge(updatedPerson.getAge());
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
//        user.removeIf(user -> user.getId() == id);
//    }
}
