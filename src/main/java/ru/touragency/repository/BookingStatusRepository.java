package ru.touragency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.BookingStatus;

public interface BookingStatusRepository extends JpaRepository<BookingStatus, String> {
}
