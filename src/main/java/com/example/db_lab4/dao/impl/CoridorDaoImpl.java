package com.example.db_lab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.db_lab4.dao.CoridorDao;
import com.example.db_lab4.domain.Coridor;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service


public class CoridorDaoImpl implements CoridorDao {

    private static final String FIND_ALL = "SELECT * FROM coridor";
    private static final String CREATE = "INSERT coridor(idcoridor, usage) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE coridor SET usage=? WHERE idcoridor=?";
    private static final String DELETE = "DELETE FROM coridor WHERE idcoridor=?";
    private static final String FIND_BY_ID = "SELECT * FROM coridor WHERE idcoridor=?";
    private static final String FIND_BY_CORIDOR_USAGE = "SELECT * FROM coridor WHERE usage=?";

    private final JdbcTemplate jdbcTemplate;

    public CoridorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Coridor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Coridor.class));
    }

    @Override
    public Optional<Coridor> findById(Integer idcoridor) {
        Optional<Coridor> coridor;
        try {
            coridor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Coridor.class), idcoridor));
        } catch (EmptyResultDataAccessException e) {
            coridor = Optional.empty();
        }
        return coridor;
    }

    @Override
    public int create(Coridor coridor) {
        return jdbcTemplate.update(CREATE, coridor.getUsage(), coridor.getIdcoridor());
    }

    @Override
    public int update(Integer idcoridor, Coridor coridor) {
        return jdbcTemplate.update(UPDATE, idcoridor, coridor.getUsage());
    }

    @Override
    public int delete(Integer idcoridor) {
        return jdbcTemplate.update(DELETE, idcoridor);
    }

    @Override
    public Optional<Coridor> findByUsage(String usage) {
        Optional<Coridor> coridor;
        try {
            coridor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_CORIDOR_USAGE,
                    BeanPropertyRowMapper.newInstance(Coridor.class), usage));
        } catch (EmptyResultDataAccessException e) {
            coridor = Optional.empty();
        }
        return coridor;
    }


}
