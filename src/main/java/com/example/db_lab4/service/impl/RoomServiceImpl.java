package com.example.db_lab4.service.impl;

import com.example.db_lab4.domain.Room;
import com.example.db_lab4.dao.RoomDao;
import com.example.db_lab4.service.RoomService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;

    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Optional<Room> findById(Integer idroom) {
        return roomDao.findById(idroom);
    }

    @Override
    public int create(Room idroom) {
        return roomDao.create(idroom);
    }

    @Override
    public int update(Integer idroom, Room room) {
        return roomDao.update(idroom, room);
    }

    @Override
    public int delete(Integer idroom) {
        return roomDao.delete(idroom);
    }



}


