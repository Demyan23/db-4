package com.example.db_lab4.service;

import com.example.db_lab4.domain.Coridor;

import java.util.Optional;

public interface CoridorService extends GeneralService<Coridor, Integer> {
    Optional<Coridor> findByUsage(String usage);
}
