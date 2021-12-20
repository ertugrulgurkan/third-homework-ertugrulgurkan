package com.ertugrul.springbootmongo.service.entityservice;


import com.ertugrul.springbootmongo.entity.User;
import com.ertugrul.springbootmongo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserEntityService {

    private final UserRepository userRepository;

    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {

        Optional<User> optional = userRepository.findById(id);

        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        }

        return user;
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}