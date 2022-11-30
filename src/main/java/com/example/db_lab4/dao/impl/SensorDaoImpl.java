package com.example.db_lab4.dao.impl;

import com.example.db_lab4.dao.SensorDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.db_lab4.domain.Sensor;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service

public class SensorDaoImpl implements SensorDao {

    private static final String FIND_ALL = "SELECT * FROM sensor";
    private static final String CREATE = "INSERT sensor(idsensor, class, info, alertInfo, alertSettings) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE sensor SET class=?, info=?, alertInfo=?, alertSettings=? WHERE idsensor=?";
    private static final String DELETE = "DELETE FROM sensor WHERE idsensor=?";
    private static final String FIND_BY_ID = "SELECT * FROM sensor WHERE idsensor=?";

    private static final String FIND_BY_SENSOR_INFO = "SELECT * FROM sensor WHERE info=?";

    private static final String FIND_BY_SENSOR_ALERTINFO = "SELECT * FROM object WHERE alertInfo=?";

    private static final String FIND_BY_SENSOR_ALERTSETTINGS = "SELECT * FROM object WHERE alertSettings=?";




    private final JdbcTemplate jdbcTemplate;

    public SensorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sensor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Sensor.class));
    }

    @Override
    public Optional<Sensor> findById(Integer idsensor) {
        Optional<Sensor> sensor;
        try {
            sensor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Sensor.class), idsensor));
        } catch (EmptyResultDataAccessException e) {
            sensor = Optional.empty();
        }
        return sensor;
    }


    @Override
    public int create(Sensor sensor) {
        return jdbcTemplate.update(CREATE, sensor.getInfo(), sensor.getIdsensor(), sensor.getAlertinfo(),sensor.getAlertSettings());
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return 0;
    }

    @Override
    public int update(Sensor sensor) {
        return jdbcTemplate.update(UPDATE, sensor.getInfo(), sensor.getIdsensor(), sensor.getClas(), sensor.getAlertinfo(),sensor.getAlertSettings());
    }

    @Override
    public int delete(Integer idsensor) {
        return jdbcTemplate.update(DELETE, idsensor);
    }


    @Override
    public Optional<Sensor> findByInfo(String info) {
        Optional<Sensor> sensor;
        try {
            sensor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SENSOR_INFO,
                    BeanPropertyRowMapper.newInstance(Sensor.class), info));
        } catch (EmptyResultDataAccessException e) {
            sensor = Optional.empty();
        }
        return sensor;
    }

    @Override
    public Optional<Sensor> findByalertinfo(String alertinfo) {
        Optional<Sensor> sensor;
        try {
            sensor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SENSOR_ALERTINFO,
                    BeanPropertyRowMapper.newInstance(Sensor.class), alertinfo));
        } catch (EmptyResultDataAccessException e) {
            sensor = Optional.empty();
        }
        return sensor;
    }


    @Override
    public Optional<Sensor> findalertSettings(String alertSettings) {
        Optional<Sensor> sensor;
        try {
            sensor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SENSOR_ALERTSETTINGS,
                    BeanPropertyRowMapper.newInstance(Sensor.class), alertSettings));
        } catch (EmptyResultDataAccessException e) {
            sensor = Optional.empty();
        }
        return sensor;
    }

}

