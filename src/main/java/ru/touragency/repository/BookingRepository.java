package ru.touragency.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @EntityGraph(attributePaths = {"tour", "request", "request.client", "bookingManager", "status"})
    List<Booking> findAll();

    @EntityGraph(attributePaths = {"tour", "request", "request.client", "bookingManager", "status"})
    Optional<Booking> findById(Integer id);

    List<Booking> findByRequestClientId(Integer clientId);
    List<Booking> findByBookingManagerId(Integer managerId);
    boolean existsByRequestId(Integer requestId);
}
