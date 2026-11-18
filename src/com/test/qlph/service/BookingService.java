package com.test.qlph.service;

import com.test.qlph.dto.BookingDTO;

import java.util.ArrayList;
import java.util.Optional;

public interface BookingService {
    ArrayList<BookingDTO> getAll();
    Optional<BookingDTO> getById(String bookingId);
    Optional<BookingDTO> getByCode(String bookingCode);
    void showAll();
    void addBooking();
    void updateBooking();
    void deleteBooking();
}
