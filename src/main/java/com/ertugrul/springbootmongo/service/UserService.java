package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User save(User user);

    void deleteById(String id);

    void delete(User user);

}
