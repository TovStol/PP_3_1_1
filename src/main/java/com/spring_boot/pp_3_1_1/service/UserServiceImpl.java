package com.spring_boot.pp_3_1_1.service;


import com.spring_boot.pp_3_1_1.dao.UserDao;
import com.spring_boot.pp_3_1_1.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

//    @Autowired
    public UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void removeUserById(Long id) {
        userDao.removeUserById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

}
