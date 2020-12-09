package com.mapper;

import com.bean.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);
    void deleteUserById(User user );
    void updateUser(User user );
    List<User> findAllUsers();
   User findUser(User user);

}
