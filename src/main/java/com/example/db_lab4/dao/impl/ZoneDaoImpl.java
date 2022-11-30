package com.example.db_lab4.dao.impl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.db_lab4.dao.ZoneDao;
import com.example.db_lab4.domain.Zone;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service

public class ZoneDaoImpl implements ZoneDao {

    private static final String FIND_ALL = "SELECT * FROM zone";
    private static final String CREATE = "INSERT zone(idzone, lvl) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE zone SET lvl=? WHERE idzone=?";
    private static final String DELETE = "DELETE FROM zone WHERE idzone=?";
    private static final String FIND_BY_ID = "SELECT * FROM zone WHERE idzone=?";

    private static final String FIND_BY_ZONE_LVL = "SELECT * FROM zone WHERE name=?";



    private final JdbcTemplate jdbcTemplate;

    public ZoneDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Zone> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Zone.class));
    }

    @Override
    public Optional<Zone> findById(Integer idzone) {
        Optional<Zone> zone;
        try {
            zone = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Zone.class), idzone));
        } catch (EmptyResultDataAccessException e) {
            zone = Optional.empty();
        }
        return zone;
    }


    @Override
    public int create(Zone zone) {
        return jdbcTemplate.update(CREATE, zone.getIdzone(), zone.getLvl());
    }

    @Override
    public int update(Integer idzone, Zone zone) {
        return jdbcTemplate.update(UPDATE, zone.getIdzone(), zone.getLvl());
    }

    @Override
    public int delete(Integer idzone) {
        return jdbcTemplate.update(DELETE, idzone);
    }

    @Override
    public Optional<Zone> findBylvl(Integer lvl) {
        Optional<Zone> zone;
        try {
            zone = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ZONE_LVL,
                    BeanPropertyRowMapper.newInstance(Zone.class), lvl));
        } catch (EmptyResultDataAccessException e) {
            zone = Optional.empty();
        }
        return zone;
    }

}
