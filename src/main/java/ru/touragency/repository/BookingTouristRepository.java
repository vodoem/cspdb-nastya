package ru.touragency.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.BookingTourist;
import ru.touragency.entity.BookingTouristId;

import java.util.List;

public interface BookingTouristRepository extends JpaRepository<BookingTourist, BookingTouristId> {
    @EntityGraph(attributePaths = {"tourist", "booking"})
    List<BookingTourist> findByBookingId(Integer bookingId);

    @EntityGraph(attributePaths = {"tourist", "booking"})
    List<BookingTourist> findByTouristId(Integer touristId);
}
