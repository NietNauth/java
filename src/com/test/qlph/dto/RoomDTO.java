package com.test.qlph.dto;

import java.util.Objects;
import java.util.UUID;

public class RoomDTO {
    private UUID roomId;
    private String roomCode;
    private String roomName;
    private Long roomPrice;
    private Boolean isOccupied = false;

    public RoomDTO() {

    }

    public RoomDTO(UUID roomId, String roomCode, String roomName, Long roomPrice, Boolean isOccupied) {
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.isOccupied = isOccupied;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Long roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO roomDTO = (RoomDTO) o;
        return Objects.equals(roomId, roomDTO.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }

    @Override
    public String toString() {
        return "UUID: " + roomId + " | Code: " + roomCode + " | Ten phong: " + roomName 
                + " | Gia/gio: " + roomPrice + " VND | Trang thai: " + (isOccupied ? "Co khach" : "Phong trong");
    }
}
