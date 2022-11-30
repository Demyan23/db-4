package com.example.db_lab4.controller;
import com.example.db_lab4.domain.Zone;
import java.util.Optional;
public interface ZoneController extends GeneralController<Zone, Integer>{


    Optional<Zone> findBylvl(Integer lvl);
}
