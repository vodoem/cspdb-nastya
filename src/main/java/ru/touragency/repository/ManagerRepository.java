package ru.touragency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
