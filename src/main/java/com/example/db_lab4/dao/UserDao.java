package com.example.db_lab4.dao;

import com.example.db_lab4.domain.User;
import java.util.Optional;

public interface UserDao extends GeneralDao<User, Integer>{


    int update(User user);

    Optional<User> findByName(String name);

    Optional<User> findBySirname(String adress);
}
