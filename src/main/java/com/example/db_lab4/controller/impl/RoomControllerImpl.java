package com.example.db_lab4.controller.impl;

import com.example.db_lab4.domain.Room;
import com.example.db_lab4.controller.RoomController;
import com.example.db_lab4.service.RoomService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomControllerImpl implements RoomController{

    private final RoomService roomService;

    public RoomControllerImpl(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @Override
    public Optional<Room> findById(Integer idroom) {
        return roomService.findById(idroom);
    }

    @Override
    public int create(Room idroom) {
        return roomService.create(idroom);
    }

    @Override
    public int update(Integer idroom, Room room) {
        return roomService.update(idroom, room);
    }

    @Override
    public int delete(Integer idroom) {
        return roomService.delete(idroom);
    }
}
