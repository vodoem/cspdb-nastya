package ru.touragency.dto;

import java.math.BigDecimal;

public record TourReportRow(String tourCode, String tourName, String directionName, BigDecimal price, Long bookingsCount) {
}
