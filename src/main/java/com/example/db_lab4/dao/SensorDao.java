package com.example.db_lab4.dao;

import java.util.Optional;
import com.example.db_lab4.domain.Sensor;

public interface SensorDao extends GeneralDao<Sensor, Integer>{


    int update(Sensor sensor);

    Optional<Sensor> findByInfo(String info);

    Optional<Sensor> findByalertinfo(String alertinfo);

    Optional<Sensor> findalertSettings(String alertSettings);
}
