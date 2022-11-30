package com.example.db_lab4.controller.impl;

import com.example.db_lab4.controller.ObjectController;
import com.example.db_lab4.domain.Object;
import com.example.db_lab4.service.ObjectService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ObjectControllerImpl implements ObjectController {

    private final ObjectService objectService;

    public ObjectControllerImpl(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public List<Object> findAll() {
        return objectService.findAll();
    }

    @Override
    public Optional<Object> findById(Integer idcoridor) {
        return objectService.findById(idcoridor);
    }

    @Override
    public int create(Object coridor) {
        return objectService.create(coridor);
    }

    @Override
    public int update(Integer idobject, Object object) {
        return objectService.update(idobject, object);
    }

    @Override
    public int delete(Integer idobject) {
        return objectService.delete(idobject);
    }


    @Override
    public Optional<Object> findByName(String name) {
        return objectService.findByName(name);
    }

    @Override
    public Optional<Object> findByAdress(String adress) {
        return objectService.findByName(adress);
    }

}
