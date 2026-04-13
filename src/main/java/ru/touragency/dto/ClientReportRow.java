package ru.touragency.dto;

import java.math.BigDecimal;

public record ClientReportRow(Integer clientId, String clientName, Long purchasesCount, BigDecimal totalAmount) {
}
