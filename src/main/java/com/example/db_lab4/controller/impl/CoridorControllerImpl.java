package com.example.db_lab4.controller.impl;
import com.example.db_lab4.controller.CoridorController;
import com.example.db_lab4.domain.Coridor;
import com.example.db_lab4.service.CoridorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoridorControllerImpl implements CoridorController{

    private final CoridorService coridorService;

    public CoridorControllerImpl(CoridorService coridorService) {
        this.coridorService = coridorService;
    }

    @Override
    public List<Coridor> findAll() {
        return coridorService.findAll();
    }

    @Override
    public Optional<Coridor> findById(Integer idcoridor) {
        return coridorService.findById(idcoridor);
    }

    @Override
    public int create(Coridor coridor) {
        return coridorService.create(coridor);
    }

    @Override
    public int update(Integer idcoridor, Coridor coridor) {
        return coridorService.update(idcoridor, coridor);
    }

    @Override
    public int delete(Integer idcoridor) {
        return coridorService.delete(idcoridor);
    }

    @Override
    public Optional<Coridor> findByUsage(String usage) {
        return coridorService.findByUsage(usage);
    }
}
