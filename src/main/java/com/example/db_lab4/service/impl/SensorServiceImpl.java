package com.example.db_lab4.service.impl;
import com.example.db_lab4.domain.Sensor;
import com.example.db_lab4.dao.SensorDao;
import com.example.db_lab4.service.SensorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService{

    private final SensorDao sensorDao;

    public SensorServiceImpl(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    @Override
    public List<Sensor> findAll() {
        return sensorDao.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer idroom) {
        return sensorDao.findById(idroom);
    }

    @Override
    public int create(Sensor idroom) {
        return sensorDao.create(idroom);
    }

    @Override
    public int update(Integer idsensor, Sensor sensor) {
        return sensorDao.update(idsensor, sensor);
    }

    @Override
    public int delete(Integer idsensor) {
        return sensorDao.delete(idsensor);
    }

    @Override
    public Optional<Sensor> findByInfo(String info) {
        return sensorDao.findByInfo(info);
    }

    @Override
    public Optional<Sensor> findByalertinfo(String alertinfo) {
        return sensorDao.findByalertinfo(alertinfo);
    }

    @Override
    public Optional<Sensor> findalertSettings(String alertSettings) {
        return sensorDao.findalertSettings(alertSettings);
    }


}
