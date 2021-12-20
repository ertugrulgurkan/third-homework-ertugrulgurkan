package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(String id);

    UserDto save(UserDto userDto);

    void deleteById(String id);

    void delete(UserDto userDto);

}
