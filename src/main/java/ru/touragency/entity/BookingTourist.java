package ru.touragency.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_tourist")
public class BookingTourist {
    @EmbeddedId
    private BookingTouristId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("touristId")
    @JoinColumn(name = "tourist_id", nullable = false)
    private Tourist tourist;

    public BookingTouristId getId() { return id; }
    public void setId(BookingTouristId id) { this.id = id; }
    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
    public Tourist getTourist() { return tourist; }
    public void setTourist(Tourist tourist) { this.tourist = tourist; }
}
