package ru.touragency.dto;

public record ManagerReportRow(Integer managerId, String managerName, Long requestsCount, Long bookingsCount) {
}
