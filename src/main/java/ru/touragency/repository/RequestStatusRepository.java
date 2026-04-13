package ru.touragency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.touragency.entity.RequestStatus;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, String> {
}
