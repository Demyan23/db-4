package com.example.db_lab4.service.impl;

import com.example.db_lab4.domain.Zone;
import com.example.db_lab4.dao.ZoneDao;
import com.example.db_lab4.service.ZoneService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneDao zoneDao;

    public ZoneServiceImpl(ZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }

    @Override
    public List<Zone> findAll() {
        return zoneDao.findAll();
    }

    @Override
    public Optional<Zone> findById(Integer idzone) {
        return zoneDao.findById(idzone);
    }

    @Override
    public int create(Zone idzone) {
        return zoneDao.create(idzone);
    }

    @Override
    public int update(Integer idzone, Zone zone) {
        return zoneDao.update(idzone, zone);
    }

    @Override
    public int delete(Integer idzone) {
        return zoneDao.delete(idzone);
    }

    @Override
    public Optional<Zone> findBylvl(Integer lvl) {
        return zoneDao.findBylvl(lvl);
    }


}
