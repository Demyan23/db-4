package com.example.db_lab4.service;


import com.example.db_lab4.domain.Object;
import java.util.Optional;

public interface ObjectService extends GeneralService<Object, Integer>{
    Optional<Object> findByName(String name);

    Optional<Object> findByAdress(String adress);
}
