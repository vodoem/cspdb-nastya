package ru.touragency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookingTouristId implements Serializable {
    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "tourist_id")
    private Integer touristId;

    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }
    public Integer getTouristId() { return touristId; }
    public void setTouristId(Integer touristId) { this.touristId = touristId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingTouristId that = (BookingTouristId) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(touristId, that.touristId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, touristId);
    }
}
