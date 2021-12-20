package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.entity.User;
import com.ertugrul.springbootmongo.service.entityservice.UserEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserEntityService userEntityService;

    public UserServiceImpl(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @Override
    public List<User> findAll() {
        return userEntityService.findAll();
    }

    @Override
    public User findById(String id) {
        return userEntityService.findById(id);
    }

    @Override
    public User save(User user) {
        return userEntityService.save(user);
    }

    @Override
    public void delete(User user) {
        userEntityService.delete(user);
    }

    @Override
    public void deleteById(String id) {
        userEntityService.deleteById(id);
    }
}
