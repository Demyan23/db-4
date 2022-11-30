package com.example.db_lab4.controller.impl;

import com.example.db_lab4.domain.Sensor;
import com.example.db_lab4.controller.SensorController;
import com.example.db_lab4.service.SensorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SensorControllerImpl implements SensorController{

    private final SensorService sensorService;

    public SensorControllerImpl(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public List<Sensor> findAll() {
        return sensorService.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer idroom) {
        return sensorService.findById(idroom);
    }

    @Override
    public int create(Sensor idroom) {
        return sensorService.create(idroom);
    }

    @Override
    public int update(Integer idsensor, Sensor sensor) {
        return sensorService.update(idsensor, sensor);
    }

    @Override
    public int delete(Integer idsensor) {
        return sensorService.delete(idsensor);
    }

    @Override
    public Optional<Sensor> findByInfo(String info) {
        return sensorService.findByInfo(info);
    }

    @Override
    public Optional<Sensor> findByalertinfo(String alertinfo) {
        return sensorService.findByalertinfo(alertinfo);
    }

    @Override
    public Optional<Sensor> findalertSettings(String alertSettings) {
        return sensorService.findalertSettings(alertSettings);
    }
}
