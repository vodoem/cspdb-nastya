package ru.touragency.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, String> {
    @EntityGraph(attributePaths = {"direction", "partner"})
    List<Tour> findAll();

    @EntityGraph(attributePaths = {"direction", "partner"})
    Optional<Tour> findByTourCode(String tourCode);
}
