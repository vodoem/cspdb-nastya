package ru.touragency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.Direction;

public interface DirectionRepository extends JpaRepository<Direction, String> {
}
