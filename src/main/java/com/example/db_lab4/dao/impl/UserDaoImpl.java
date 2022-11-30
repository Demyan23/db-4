package com.example.db_lab4.dao.impl;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.db_lab4.dao.UserDao;
import com.example.db_lab4.domain.User;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service

public class UserDaoImpl implements UserDao {

    private static final String FIND_ALL = "SELECT * FROM user";
    private static final String CREATE = "INSERT user(iduser, lvl, name, sirname, age, email) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET lvl=?, name=?, sirname=?, age=?, email=? WHERE iduser=?";
    private static final String DELETE = "DELETE FROM user WHERE iduser=?";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE iduser=?";

    private static final String FIND_BY_USER_NAME = "SELECT * FROM user WHERE name=?";

    private static final String FIND_BY_USER_SIRNAME = "SELECT * FROM user WHERE sirname=?";


    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public Optional<User> findById(Integer iduser) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(User.class), iduser));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }


    @Override
    public int create(User user) {
        return jdbcTemplate.update(CREATE, user.getIduser(), user.getAge(), user.getName(), user.getSirname(), user.getEmail(), user.getLvl());
    }

    @Override
    public int update(Integer integer, User entity) {
        return 0;
    }


    @Override
    public int update(User user) {
        return jdbcTemplate.update(UPDATE, user.getIduser(), user.getAge(), user.getName(), user.getSirname(), user.getEmail(), user.getLvl());
    }

    @Override
    public int delete(Integer iduser) {
        return jdbcTemplate.update(DELETE, iduser);
    }

    @Override
    public Optional<User> findByName(String name) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_USER_NAME,
                    BeanPropertyRowMapper.newInstance(User.class), name));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public Optional<User> findBySirname(String sirname) {
        Optional<User> user;
        try {
            user = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_USER_SIRNAME,
                    BeanPropertyRowMapper.newInstance(User.class), sirname));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }
}
