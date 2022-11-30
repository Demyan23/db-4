package com.example.db_lab4.service.impl;

import com.example.db_lab4.domain.User;
import com.example.db_lab4.dao.UserDao;
import com.example.db_lab4.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Integer iduser) {
        return userDao.findById(iduser);
    }

    @Override
    public int create(User iduser) {
        return userDao.create(iduser);
    }

    @Override
    public int update(Integer iduser, User user) {
        return userDao.update(iduser, user);
    }

    @Override
    public int delete(Integer iduser) {
        return userDao.delete(iduser);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public Optional<User> findBySirname(String sirname) {
        return userDao.findBySirname(sirname);
    }

}
