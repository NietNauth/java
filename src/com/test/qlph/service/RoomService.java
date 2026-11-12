package com.test.qlph.service;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.RoomDTO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class RoomService {
    private Scanner sc = KaraokeConstant.sc;
    private int roomCounter = 0;

    private String generateRoomCode() {
        roomCounter++;
        return String.format("P%03d", roomCounter);
    }

    public ArrayList<RoomDTO> getAll() {
        return KaraokeConstant.listRoom;
    }

    public Optional<RoomDTO> getById(String roomId) {
        for (RoomDTO roomDTO : KaraokeConstant.listRoom) {
            if (roomDTO.getRoomId().toString().equalsIgnoreCase(roomId)) {
                return Optional.of(roomDTO);
            }
        }
        return Optional.empty();
    }

    public void showAll() {
        int stt = 1;
        System.out.println("\n---Danh sach phong hat---");
        if (KaraokeConstant.listRoom.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }
        for (RoomDTO roomDTO : KaraokeConstant.listRoom) {
            System.out.println("STT: " + (stt++) + " | " + roomDTO);
        }
    }

    public void addRoom() {
        System.out.println("\n---Them phong hat---");
        UUID roomId;
        RoomDTO temp = new RoomDTO();
        do {
            roomId = UUID.randomUUID();
            temp.setRoomId(roomId);
        } while (KaraokeConstant.listRoom.contains(temp));

        String roomCode = generateRoomCode();

        System.out.print("Nhap ten phong: ");
        String roomName = sc.nextLine();
        System.out.print("Nhap gia phong moi gio: ");
        Long roomPrice = Long.parseLong(sc.nextLine());

        RoomDTO roomDTO = new RoomDTO(roomId, roomCode, roomName, roomPrice, false);
        KaraokeConstant.listRoom.add(roomDTO);
        System.out.println("Them phong thanh cong! (Ma: " + roomCode + " | UUID: " + roomId + ")");
    }

    public void updateRoom() {
        System.out.println("\n---Sua phong hat---");
        System.out.print("Nhap UUID phong can sua: ");
        String roomId = sc.nextLine().trim();

        Optional<RoomDTO> roomOpt = getById(roomId);
        if (roomOpt.isEmpty()) {
            System.out.println("Khong tim thay phong");
            return;
        }

        RoomDTO roomDTO = roomOpt.get();
        System.out.print("Nhap ten phong moi: ");
        roomDTO.setRoomName(sc.nextLine());
        System.out.print("Nhap gia phong moi: ");
        roomDTO.setRoomPrice(Long.parseLong(sc.nextLine()));

        System.out.println("Cap nhat phong thanh cong");
    }

    public void deleteRoom() {
        System.out.println("\n---Xoa phong hat---");
        System.out.print("Nhap UUID phong can xoa: ");
        String roomId = sc.nextLine().trim();

        Optional<RoomDTO> roomOpt = getById(roomId);
        if (roomOpt.isEmpty()) {
            System.out.println("Khong tim thay phong");
            return;
        }

        KaraokeConstant.listRoom.remove(roomOpt.get());
        System.out.println("Xoa phong thanh cong");
    }
}
