package com.example.db_lab4.dao;

import java.util.Optional;
import com.example.db_lab4.domain.Object;
public interface ObjectDao extends GeneralDao<Object, Integer>{


    Optional<Object> findByName(String name);
    Optional<Object> findByAdress(String adress);


    }

