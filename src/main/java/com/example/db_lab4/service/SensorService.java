package com.example.db_lab4.service;

import com.example.db_lab4.domain.Sensor;

import java.util.Optional;

public interface SensorService extends GeneralService<Sensor, Integer>{


    Optional<Sensor> findByInfo(String brand);

    Optional<Sensor> findByalertinfo(String clas);

    Optional<Sensor> findalertSettings(String clas);
}
