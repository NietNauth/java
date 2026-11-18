package com.test.qlph.serviceimpl;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.BookingDTO;
import com.test.qlph.service.BookingService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {
    private static final String CODE_REGEX = "^HD\\d{3}$";

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
        UUID bookingId = UUID.randomUUID();
        String bookingCode = inputBookingCode();

        System.out.print("Nhap ma phong: ");
        String roomId = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        String customerId = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap ngay dat (VD: 12/11/2026): ");
        String bookingDate = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap gio dat (VD: 19:30): ");
        String bookingTime = KaraokeConstant.sc.nextLine();

        BookingDTO bookingDTO = new BookingDTO(bookingId, bookingCode, roomId, customerId, bookingDate, bookingTime);
        KaraokeConstant.listBooking.add(bookingDTO);
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
        System.out.print("Nhap ma phong moi: ");
        bookingDTO.setRoomId(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap ma khach hang moi: ");
        bookingDTO.setCustomerId(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap ngay dat moi: ");
        bookingDTO.setBookingDate(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap gio dat moi: ");
        bookingDTO.setBookingTime(KaraokeConstant.sc.nextLine());

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

        KaraokeConstant.listBooking.remove(bookingOpt.get());
        System.out.println("Xoa don dat phong thanh cong");
    }
}
