package com.example.db_lab4.controller;

import com.example.db_lab4.domain.Sensor;

import java.util.Optional;

public interface SensorController extends GeneralController<Sensor, Integer>{
    Optional<Sensor> findByInfo(String info);

    Optional<Sensor> findByalertinfo(String alertinfo);

    Optional<Sensor> findalertSettings(String alertSettings);
}