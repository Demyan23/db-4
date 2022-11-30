package com.example.db_lab4.controller.impl;

import com.example.db_lab4.domain.User;
import com.example.db_lab4.controller.UserController;
import com.example.db_lab4.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class UserControllerImpl implements UserController{

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findById(Integer iduser) {
        return userService.findById(iduser);
    }

    @Override
    public int create(User iduser) {
        return userService.create(iduser);
    }

    @Override
    public int update(Integer iduser, User user) {
        return userService.update(iduser, user);
    }

    @Override
    public int delete(Integer iduser) {
        return userService.delete(iduser);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userService.findByName(name);
    }

    @Override
    public Optional<User> findBySirname(String sirname) {
        return userService.findBySirname(sirname);
    }

}
