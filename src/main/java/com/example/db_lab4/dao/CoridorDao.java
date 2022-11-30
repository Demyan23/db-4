package com.example.db_lab4.dao;

import com.example.db_lab4.domain.Coridor;
import java.util.Optional;
public interface CoridorDao extends GeneralDao<Coridor, Integer> {

    Optional<Coridor> findByUsage(String usage);


}
