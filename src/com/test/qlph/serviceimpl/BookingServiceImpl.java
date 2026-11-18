package com.test.qlph.serviceimpl;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.BookingDTO;
import com.test.qlph.dto.RoomDTO;
import com.test.qlph.service.BookingService;
import com.test.qlph.service.RoomService;
import com.test.qlph.util.InputUtil;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {
    private static final String CODE_REGEX = "^HD\\d{3}$";
    private final RoomService roomService = new RoomServiceImpl();

    @Override
    public Optional<BookingDTO> getByCode(String bookingCode) {
        for (BookingDTO dto : KaraokeConstant.listBooking) {
            if (dto.getBookingCode().equalsIgnoreCase(bookingCode)) {
                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    private String inputBookingCode() {
        while (true) {
            System.out.print("Nhap ma hoa don (VD: HD001): ");
            String code = KaraokeConstant.sc.nextLine().trim().toUpperCase();
            if (code.isEmpty()) {
                System.out.println("Ma khong duoc de trong");
            } else if (!code.matches(CODE_REGEX)) {
                System.out.println("Sai dinh dang, phai la HD + 3 chu so");
            } else if (getByCode(code).isPresent()) {
                System.out.println("Ma da ton tai, nhap ma khac");
            } else {
                return code;
            }
        }
    }

    private RoomDTO inputAvailableRoom(String currentRoomCode) {
        while (true) {
            String prompt = currentRoomCode == null
                    ? "Nhap ma phong: "
                    : "Nhap ma phong moi (Enter de giu: " + currentRoomCode + "): ";
            System.out.print(prompt);
            String code = KaraokeConstant.sc.nextLine().trim().toUpperCase();

            if (code.isEmpty() && currentRoomCode != null) {
                code = currentRoomCode;
            }
            if (code.isEmpty()) {
                System.out.println("Ma phong khong duoc de trong");
                continue;
            }

            Optional<RoomDTO> roomOpt = roomService.getByCode(code);
            if (roomOpt.isEmpty()) {
                System.out.println("Khong tim thay phong " + code);
                continue;
            }

            RoomDTO room = roomOpt.get();
            boolean isCurrentRoom = room.getRoomCode().equalsIgnoreCase(currentRoomCode);
            if (Boolean.TRUE.equals(room.getOccupied()) && !isCurrentRoom) {
                System.out.println("Phong " + code + " dang co khach, chon phong khac");
                continue;
            }
            return room;
        }
    }

    private void setRoomOccupied(String roomCode, boolean occupied) {
        roomService.getByCode(roomCode).ifPresent(room -> room.setOccupied(occupied));
    }

    @Override
    public ArrayList<BookingDTO> getAll() {
        return KaraokeConstant.listBooking;
    }

    @Override
    public Optional<BookingDTO> getById(String bookingId) {
        for (BookingDTO bookingDTO : KaraokeConstant.listBooking) {
            if (bookingDTO.getBookingId().toString().equalsIgnoreCase(bookingId)) {
                return Optional.of(bookingDTO);
            }
        }
        return Optional.empty();
    }

    @Override
    public void showAll() {
        int stt = 1;
        System.out.println("\n---Danh sach dat phong---");
        if (KaraokeConstant.listBooking.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }
        for (BookingDTO bookingDTO : KaraokeConstant.listBooking) {
            System.out.println("STT: " + (stt++) + " | " + bookingDTO);
        }
    }

    @Override
    public void addBooking() {
        System.out.println("\n---Them dat phong---");
        if (KaraokeConstant.listRoom.stream().allMatch(room -> Boolean.TRUE.equals(room.getOccupied()))) {
            System.out.println("Khong con phong trong de dat");
            return;
        }

        UUID bookingId = UUID.randomUUID();
        String bookingCode = inputBookingCode();
        RoomDTO room = inputAvailableRoom(null);
        String customerId = InputUtil.inputString("Nhap ma khach hang").toUpperCase();
        String bookingDate = InputUtil.inputDate("Nhap ngay dat");
        String bookingTime = InputUtil.inputTime("Nhap gio dat");

        BookingDTO bookingDTO = new BookingDTO(bookingId, bookingCode, room.getRoomCode(), customerId, bookingDate, bookingTime);
        KaraokeConstant.listBooking.add(bookingDTO);
        room.setOccupied(true);
        System.out.println("Dat phong thanh cong! (Ma hoa don: " + bookingCode + " | UUID: " + bookingId + ")");
    }

    @Override
    public void updateBooking() {
        System.out.println("\n---Sua dat phong---");
        System.out.print("Nhap ma dat phong can sua: ");
        String bookingCode = KaraokeConstant.sc.nextLine().trim();

        Optional<BookingDTO> bookingOpt = getByCode(bookingCode);
        if (bookingOpt.isEmpty()) {
            System.out.println("Khong tim thay don dat phong");
            return;
        }

        BookingDTO bookingDTO = bookingOpt.get();
        String oldRoomCode = bookingDTO.getRoomId();
        RoomDTO newRoom = inputAvailableRoom(oldRoomCode);
        String customerId = InputUtil.inputString("Nhap ma khach hang moi", bookingDTO.getCustomerId()).toUpperCase();
        String bookingDate = InputUtil.inputDate("Nhap ngay dat moi", bookingDTO.getBookingDate());
        String bookingTime = InputUtil.inputTime("Nhap gio dat moi", bookingDTO.getBookingTime());

        setRoomOccupied(oldRoomCode, false);
        newRoom.setOccupied(true);
        bookingDTO.setRoomId(newRoom.getRoomCode());
        bookingDTO.setCustomerId(customerId);
        bookingDTO.setBookingDate(bookingDate);
        bookingDTO.setBookingTime(bookingTime);

        System.out.println("Cap nhat dat phong thanh cong");
    }

    @Override
    public void deleteBooking() {
        System.out.println("\n---Xoa dat phong---");
        System.out.print("Nhap ma dat phong can xoa: ");
        String bookingCode = KaraokeConstant.sc.nextLine().trim();

        Optional<BookingDTO> bookingOpt = getByCode(bookingCode);
        if (bookingOpt.isEmpty()) {
            System.out.println("Khong tim thay don dat phong");
            return;
        }

        BookingDTO bookingDTO = bookingOpt.get();
        if (!InputUtil.confirm("Ban chac chan muon xoa don " + bookingDTO.getBookingCode() + "?")) {
            System.out.println("Da huy xoa");
            return;
        }

        KaraokeConstant.listBooking.remove(bookingDTO);
        setRoomOccupied(bookingDTO.getRoomId(), false);
        System.out.println("Xoa don dat phong thanh cong");
    }
}
