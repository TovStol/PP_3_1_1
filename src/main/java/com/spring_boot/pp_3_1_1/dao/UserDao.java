package com.spring_boot.pp_3_1_1.dao;



import com.spring_boot.pp_3_1_1.model.User;


import java.util.List;


public interface UserDao {
    void saveUser(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);

    User getUserById(Long id);
}
