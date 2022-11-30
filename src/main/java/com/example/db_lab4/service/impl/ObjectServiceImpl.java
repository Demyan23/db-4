package com.example.db_lab4.service.impl;

import com.example.db_lab4.domain.Object;
import com.example.db_lab4.dao.ObjectDao;
import com.example.db_lab4.service.ObjectService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ObjectServiceImpl implements ObjectService {

    private final ObjectDao objectDao;

    public ObjectServiceImpl(ObjectDao objectDao) {
        this.objectDao = objectDao;
    }

    @Override
    public List<Object> findAll() {
        return objectDao.findAll();
    }

    @Override
    public Optional<Object> findById(Integer idcoridor) {
        return objectDao.findById(idcoridor);
    }

    @Override
    public int create(Object coridor) {
        return objectDao.create(coridor);
    }

    @Override
    public int update(Integer idobject, Object object) {
        return objectDao.update(idobject, object);
    }

    @Override
    public int delete(Integer idobject) {
        return objectDao.delete(idobject);
    }


    @Override
    public Optional<Object> findByName(String name) {
        return objectDao.findByName(name);
    }

    @Override
    public Optional<Object> findByAdress(String adress) {
        return objectDao.findByName(adress);
    }
}
