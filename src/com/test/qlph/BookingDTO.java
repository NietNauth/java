package com.test.qlph;

public class BookingDTO {
    private String bookingId;
    private String roomId;
    private String customerId;
    private String bookingDate;
    private String bookingTime;

    public BookingDTO(){

    }

    public BookingDTO(String bookingId, String roomId, String customerId, String bookingDate, String bookingTime) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.customerId = customerId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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
}
