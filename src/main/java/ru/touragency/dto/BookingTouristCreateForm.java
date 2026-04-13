package ru.touragency.dto;

import jakarta.validation.constraints.NotNull;

public class BookingTouristCreateForm {
    @NotNull
    private Integer bookingId;
    @NotNull
    private Integer touristId;

    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }
    public Integer getTouristId() { return touristId; }
    public void setTouristId(Integer touristId) { this.touristId = touristId; }
}
