package ru.touragency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Integer> {
}
