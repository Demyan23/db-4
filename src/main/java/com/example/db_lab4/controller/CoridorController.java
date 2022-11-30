package com.example.db_lab4.controller;


import com.example.db_lab4.domain.Coridor;
import java.util.Optional;

public interface CoridorController extends GeneralController<Coridor, Integer> {

    Optional<Coridor> findByUsage(String usage);


}