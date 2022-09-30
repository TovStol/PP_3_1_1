package com.spring_boot.pp_3_1_1.dao;


import com.spring_boot.pp_3_1_1.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManager entityManager;

//    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);

    }

    @Override
    public void removeUserById(Long id) {

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();

    }


    @Override
    public void updateUser(User user) {

        entityManager.merge(user);

    }

    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }
}
