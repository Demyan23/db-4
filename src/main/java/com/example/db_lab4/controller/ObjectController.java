package com.example.db_lab4.controller;


import com.example.db_lab4.domain.Object;
import java.util.Optional;

public interface ObjectController extends GeneralController<Object, Integer>{
    Optional<Object> findByName(String name);

    Optional<Object> findByAdress(String adress);
}
