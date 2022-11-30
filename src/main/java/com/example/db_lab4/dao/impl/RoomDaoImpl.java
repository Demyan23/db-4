package com.example.db_lab4.dao.impl;

import com.example.db_lab4.dao.RoomDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.db_lab4.domain.Room;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service


public class RoomDaoImpl implements RoomDao {

    private static final String FIND_ALL = "SELECT * FROM room";
    private static final String CREATE = "INSERT room(idroom, usage) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE room SET idroom=?, usage=? WHERE idroom=?";
    private static final String DELETE = "DELETE FROM room WHERE idroom=?";
    private static final String FIND_BY_ID = "SELECT * FROM room WHERE idroom=?";




    private final JdbcTemplate jdbcTemplate;

    public RoomDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Room> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Room.class));
    }

    @Override
    public Optional<Room> findById(Integer idroom) {
        Optional<Room> room;
        try {
            room = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Room.class), idroom));
        } catch (EmptyResultDataAccessException e) {
            room = Optional.empty();
        }
        return room;
    }


    @Override
    public int create(Room room) {
        return jdbcTemplate.update(CREATE, room.getUsage(), room.getIdroom());
    }

    @Override
    public int update(Integer idroom, Room room) {
        return jdbcTemplate.update(UPDATE, room.getUsage(), room.getIdroom());
    }

    @Override
    public int delete(Integer idroom) {
        return jdbcTemplate.update(DELETE, idroom);
    }

    
}
