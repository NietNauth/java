package com.test.qlph.service;

import com.test.qlph.dto.RoomDTO;

import java.util.ArrayList;
import java.util.Optional;

public interface RoomService {
    ArrayList<RoomDTO> getAll();
    Optional<RoomDTO> getById(String roomId);
    Optional<RoomDTO> getByCode(String roomCode);
    void showAll();
    void addRoom();
    void updateRoom();
    void deleteRoom();
}
