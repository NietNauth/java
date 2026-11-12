package com.test.qlph.dto;

import java.util.Objects;
import java.util.UUID;

public class BookingDTO {
    private UUID bookingId;
    private String bookingCode;
    private String roomId;
    private String customerId;
    private String bookingDate;
    private String bookingTime;

    public BookingDTO() {

    }

    public BookingDTO(UUID bookingId, String bookingCode, String roomId, String customerId, String bookingDate, String bookingTime) {
        this.bookingId = bookingId;
        this.bookingCode = bookingCode;
        this.roomId = roomId;
        this.customerId = customerId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDTO that = (BookingDTO) o;
        return Objects.equals(bookingId, that.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }

    @Override
    public String toString() {
        return "UUID: " + bookingId + " | Code: " + bookingCode + " | Ma phong: " + roomId 
                + " | Ma khach: " + customerId + " | Ngay: " + bookingDate + " | Gio: " + bookingTime;
    }
}
