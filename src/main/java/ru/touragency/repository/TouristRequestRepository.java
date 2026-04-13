package ru.touragency.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.TouristRequest;

import java.util.List;
import java.util.Optional;

public interface TouristRequestRepository extends JpaRepository<TouristRequest, Integer> {
    @EntityGraph(attributePaths = {"client", "manager", "direction", "status"})
    List<TouristRequest> findAll();

    @EntityGraph(attributePaths = {"client", "manager", "direction", "status"})
    Optional<TouristRequest> findById(Integer id);

    List<TouristRequest> findByClientId(Integer clientId);
    List<TouristRequest> findByManagerId(Integer managerId);
}
