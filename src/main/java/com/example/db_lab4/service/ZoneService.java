package com.example.db_lab4.service;

import com.example.db_lab4.domain.Zone;

import java.util.Optional;

public interface ZoneService extends GeneralService<Zone, Integer>{
    Optional<Zone> findBylvl(Integer lvl);
}
