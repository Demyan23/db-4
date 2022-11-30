package com.example.db_lab4.service.impl;

import com.example.db_lab4.domain.Coridor;
import com.example.db_lab4.dao.CoridorDao;
import com.example.db_lab4.service.CoridorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CoridorServiceImpl implements CoridorService{

    private final CoridorDao coridorDao;

    public CoridorServiceImpl(CoridorDao coridorDao) {
        this.coridorDao = coridorDao;
    }

    @Override
    public List<Coridor> findAll() {
        return coridorDao.findAll();
    }

    @Override
    public Optional<Coridor> findById(Integer idcoridor) {
        return coridorDao.findById(idcoridor);
    }

    @Override
    public int create(Coridor coridor) {
        return coridorDao.create(coridor);
    }

    @Override
    public int update(Integer idcoridor, Coridor coridor) {
        return coridorDao.update(idcoridor, coridor);
    }

    @Override
    public int delete(Integer idcoridor) {
        return coridorDao.delete(idcoridor);
    }

    @Override
    public Optional<Coridor> findByUsage(String usage) {
        return coridorDao.findByUsage(usage);
    }

}
