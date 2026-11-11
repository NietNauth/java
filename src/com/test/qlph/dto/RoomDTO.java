package com.test.qlph.dto;

public class RoomDTO {
    private String roomId;
    private String roomName;
    private Long roomPrice;
    private Boolean isOccupied = false  ;

    public RoomDTO() {

    }

    public RoomDTO(String roomId, String roomName, Long roomPrice, Boolean isOccupied) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.isOccupied = isOccupied;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
}
