package com.spring_boot.pp_3_1_1.service;



import com.spring_boot.pp_3_1_1.model.User;

import java.util.List;

public interface UserService {


    void saveUser(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    void updateUser(Long id, User user);

    User getUserById(Long id);
}
