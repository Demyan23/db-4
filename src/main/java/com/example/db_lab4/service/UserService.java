package com.example.db_lab4.service;

import com.example.db_lab4.domain.User;

import java.util.Optional;

public interface UserService extends GeneralService<User, Integer>{


    Optional<User> findByName(String name);

    Optional<User> findBySirname(String sirname);
}
