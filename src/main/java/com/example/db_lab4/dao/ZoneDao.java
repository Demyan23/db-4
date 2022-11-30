package com.example.db_lab4.dao;

import com.example.db_lab4.domain.Zone;
import java.util.Optional;

public interface ZoneDao extends GeneralDao<Zone, Integer>{



    Optional<Zone> findBylvl(Integer lvl);
}
