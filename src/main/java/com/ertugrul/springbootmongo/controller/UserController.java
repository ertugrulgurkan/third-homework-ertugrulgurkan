package com.ertugrul.springbootmongo.controller;


import com.ertugrul.springbootmongo.dto.UserDto;
import com.ertugrul.springbootmongo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Api üzerinden kullanıcılara erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET http://localhost:8080/api/users
    @GetMapping(value = {"", "/"})
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> save(@RequestBody UserDto userDto) {
        userDto = userService.save(userDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(userDto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // Id parametresi ile kullanici silebilecek servis
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }

    // Kullanici silebilecek servis
    @DeleteMapping(value = {"", "/"})
    public void delete(@RequestBody UserDto userDto) {
        userService.delete(userDto);
    }
}
