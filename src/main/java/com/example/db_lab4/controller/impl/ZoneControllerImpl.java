package com.example.db_lab4.controller.impl;
import com.example.db_lab4.domain.Zone;
import com.example.db_lab4.controller.ZoneController;
import com.example.db_lab4.service.ZoneService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ZoneControllerImpl implements ZoneController{

    private final ZoneService zoneService;

    public ZoneControllerImpl(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @Override
    public List<Zone> findAll() {
        return zoneService.findAll();
    }

    @Override
    public Optional<Zone> findById(Integer idzone) {
        return zoneService.findById(idzone);
    }

    @Override
    public int create(Zone idzone) {
        return zoneService.create(idzone);
    }

    @Override
    public int update(Integer idzone, Zone zone) {
        return zoneService.update(idzone, zone);
    }

    @Override
    public int delete(Integer idzone) {
        return zoneService.delete(idzone);
    }

    @Override
    public Optional<Zone> findBylvl(Integer lvl) {
        return zoneService.findBylvl(lvl);
    }


}
