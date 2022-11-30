package com.example.db_lab4.controller;

import com.example.db_lab4.domain.User;
import java.util.Optional;

public interface UserController extends GeneralController<User, Integer>{
    Optional<User> findByName(String name);

    Optional<User> findBySirname(String sirname);
}
