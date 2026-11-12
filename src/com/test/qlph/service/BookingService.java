package com.test.qlph.service;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.BookingDTO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class BookingService {
    private Scanner sc = KaraokeConstant.sc;
    private int bookingCounter = 0;

    private String generateBookingCode() {
        bookingCounter++;
        return String.format("HD%03d", bookingCounter);
    }

    public ArrayList<BookingDTO> getAll() {
        return KaraokeConstant.listBooking;
    }

    public Optional<BookingDTO> getById(String bookingId) {
        for (BookingDTO bookingDTO : KaraokeConstant.listBooking) {
            if (bookingDTO.getBookingId().toString().equalsIgnoreCase(bookingId)) {
                return Optional.of(bookingDTO);
            }
        }
        return Optional.empty();
    }

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

    public void addBooking() {
        System.out.println("\n---Them dat phong---");
        UUID bookingId;
        BookingDTO temp = new BookingDTO();
        do {
            bookingId = UUID.randomUUID();
            temp.setBookingId(bookingId);
        } while (KaraokeConstant.listBooking.contains(temp));

        String bookingCode = generateBookingCode();

        System.out.print("Nhap ma phong: ");
        String roomId = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        String customerId = sc.nextLine();
        System.out.print("Nhap ngay dat (VD: 12/11/2026): ");
        String bookingDate = sc.nextLine();
        System.out.print("Nhap gio dat (VD: 19:30): ");
        String bookingTime = sc.nextLine();

        BookingDTO bookingDTO = new BookingDTO(bookingId, bookingCode, roomId, customerId, bookingDate, bookingTime);
        KaraokeConstant.listBooking.add(bookingDTO);
        System.out.println("Dat phong thanh cong! (Ma hoa don: " + bookingCode + " | UUID: " + bookingId + ")");
    }

    public void updateBooking() {
        System.out.println("\n---Sua dat phong---");
        System.out.print("Nhap UUID dat phong can sua: ");
        String bookingId = sc.nextLine().trim();

        Optional<BookingDTO> bookingOpt = getById(bookingId);
        if (bookingOpt.isEmpty()) {
            System.out.println("Khong tim thay don dat phong");
            return;
        }

        BookingDTO bookingDTO = bookingOpt.get();
        System.out.print("Nhap ma phong moi: ");
        bookingDTO.setRoomId(sc.nextLine());
        System.out.print("Nhap ma khach hang moi: ");
        bookingDTO.setCustomerId(sc.nextLine());
        System.out.print("Nhap ngay dat moi: ");
        bookingDTO.setBookingDate(sc.nextLine());
        System.out.print("Nhap gio dat moi: ");
        bookingDTO.setBookingTime(sc.nextLine());

        System.out.println("Cap nhat dat phong thanh cong");
    }

    public void deleteBooking() {
        System.out.println("\n---Xoa dat phong---");
        System.out.print("Nhap UUID dat phong can xoa: ");
        String bookingId = sc.nextLine().trim();

        Optional<BookingDTO> bookingOpt = getById(bookingId);
        if (bookingOpt.isEmpty()) {
            System.out.println("Khong tim thay don dat phong");
            return;
        }

        KaraokeConstant.listBooking.remove(bookingOpt.get());
        System.out.println("Xoa don dat phong thanh cong");
    }
}
