package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.converter.UserConverter;
import com.ertugrul.springbootmongo.dto.UserDto;
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
    public List<UserDto> findAll() {
        List<User> userList = userEntityService.findAll();
        return UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);
    }
    @Override
    public UserDto findById(String id) {
        User user = userEntityService.findById(id);
        return UserConverter.INSTANCE.convertUserToUserDto(user);
    }
    @Override
    public UserDto save(UserDto userDto) {
        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        User savedUser = userEntityService.save(user);
        return UserConverter.INSTANCE.convertUserToUserDto(savedUser);
    }
    @Override
    public void deleteById(String id) {
        userEntityService.deleteById(id);
    }

    @Override
    public void delete(UserDto userDto) {
        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        userEntityService.delete(user);
    }
}
