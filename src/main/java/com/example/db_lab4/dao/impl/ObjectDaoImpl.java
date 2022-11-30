package com.example.db_lab4.dao.impl;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.db_lab4.dao.ObjectDao;
import com.example.db_lab4.domain.Object;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service

public class ObjectDaoImpl implements ObjectDao {

    private static final String FIND_ALL = "SELECT * FROM object";
    private static final String CREATE = "INSERT object(name, adress) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE object SET name=?, adress=? WHERE idobject=?";
    private static final String DELETE = "DELETE FROM object WHERE idobject=?";
    private static final String FIND_BY_ID = "SELECT * FROM object WHERE idobject=?";

    private static final String FIND_BY_OBJECT_NAME = "SELECT * FROM object WHERE name=?";

    private static final String FIND_BY_OBJECT_ADRESS = "SELECT * FROM object WHERE clas=?";


    private final JdbcTemplate jdbcTemplate;

    public ObjectDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Object> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Object.class));
    }

    @Override
    public Optional<Object> findById(Integer idobject) {
        Optional<Object> object;
        try {
            object = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Object.class), idobject));
        } catch (EmptyResultDataAccessException e) {
            object = Optional.empty();
        }
        return object;
    }


    @Override
    public int create(Object object) {
        return jdbcTemplate.update(CREATE, object.getName(), object.getAdress());
    }

    @Override
    public int update(Integer idobject, Object object) {
        return jdbcTemplate.update(UPDATE, object.getName(), object.getAdress(), idobject);
    }

    @Override
    public int delete(Integer idobject) {
        return jdbcTemplate.update(DELETE, idobject);
    }

    @Override
    public Optional<Object> findByName(String name) {
        Optional<Object> object;
        try {
            object = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_OBJECT_NAME,
                    BeanPropertyRowMapper.newInstance(Object.class), name));
        } catch (EmptyResultDataAccessException e) {
            object = Optional.empty();
        }
        return object;
    }

    @Override
    public Optional<Object> findByAdress(String adress) {
        Optional<Object> object;
        try {
            object = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_OBJECT_ADRESS,
                    BeanPropertyRowMapper.newInstance(Object.class), adress));
        } catch (EmptyResultDataAccessException e) {
            object = Optional.empty();
        }
        return object;
    }
}


