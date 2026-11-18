package com.test.qlph.serviceimpl;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.RoomDTO;
import com.test.qlph.service.RoomService;
import com.test.qlph.util.InputUtil;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class RoomServiceImpl implements RoomService {
    private static final String CODE_REGEX = "^P\\d{3}$";

    @Override
    public Optional<RoomDTO> getByCode(String roomCode) {
        for (RoomDTO dto : KaraokeConstant.listRoom) {
            if (dto.getRoomCode().equalsIgnoreCase(roomCode)) {
                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    private String inputRoomCode() {
        while (true) {
            System.out.print("Nhap ma phong (VD: P001): ");
            String code = KaraokeConstant.sc.nextLine().trim().toUpperCase();
            if (code.isEmpty()) {
                System.out.println("Ma khong duoc de trong");
            } else if (!code.matches(CODE_REGEX)) {
                System.out.println("Sai dinh dang, phai la P + 3 chu so");
            } else if (getByCode(code).isPresent()) {
                System.out.println("Ma da ton tai, nhap ma khac");
            } else {
                return code;
            }
        }
    }

    @Override
    public ArrayList<RoomDTO> getAll() {
        return KaraokeConstant.listRoom;
    }

    @Override
    public Optional<RoomDTO> getById(String roomId) {
        for (RoomDTO roomDTO : KaraokeConstant.listRoom) {
            if (roomDTO.getRoomId().toString().equalsIgnoreCase(roomId)) {
                return Optional.of(roomDTO);
            }
        }
        return Optional.empty();
    }

    @Override
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

    @Override
    public void addRoom() {
        System.out.println("\n---Them phong hat---");
        UUID roomId = UUID.randomUUID();
        String roomCode = inputRoomCode();
        String roomName = InputUtil.inputString("Nhap ten phong");
        Long roomPrice = InputUtil.inputPositiveLong("Nhap gia phong moi gio");

        RoomDTO roomDTO = new RoomDTO(roomId, roomCode, roomName, roomPrice, false);
        KaraokeConstant.listRoom.add(roomDTO);
        System.out.println("Them phong thanh cong! (Ma: " + roomCode + " | UUID: " + roomId + ")");
    }

    @Override
    public void updateRoom() {
        System.out.println("\n---Sua phong hat---");
        System.out.print("Nhap ma phong can sua: ");
        String roomCode = KaraokeConstant.sc.nextLine().trim();

        Optional<RoomDTO> roomOpt = getByCode(roomCode);
        if (roomOpt.isEmpty()) {
            System.out.println("Khong tim thay phong");
            return;
        }

        RoomDTO roomDTO = roomOpt.get();
        roomDTO.setRoomName(InputUtil.inputString("Nhap ten phong moi", roomDTO.getRoomName()));
        roomDTO.setRoomPrice(InputUtil.inputPositiveLong("Nhap gia phong moi", roomDTO.getRoomPrice()));

        System.out.println("Cap nhat phong thanh cong");
    }

    @Override
    public void deleteRoom() {
        System.out.println("\n---Xoa phong hat---");
        System.out.print("Nhap ma phong can xoa: ");
        String roomCode = KaraokeConstant.sc.nextLine().trim();

        Optional<RoomDTO> roomOpt = getByCode(roomCode);
        if (roomOpt.isEmpty()) {
            System.out.println("Khong tim thay phong");
            return;
        }

        RoomDTO roomDTO = roomOpt.get();
        if (Boolean.TRUE.equals(roomDTO.getOccupied())) {
            System.out.println("Phong dang co khach, khong the xoa");
            return;
        }

        if (!InputUtil.confirm("Ban chac chan muon xoa phong " + roomDTO.getRoomCode() + "?")) {
            System.out.println("Da huy xoa");
            return;
        }

        KaraokeConstant.listRoom.remove(roomDTO);
        System.out.println("Xoa phong thanh cong");
    }
}
