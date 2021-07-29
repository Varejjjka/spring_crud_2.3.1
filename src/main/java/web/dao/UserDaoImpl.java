package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }
}
