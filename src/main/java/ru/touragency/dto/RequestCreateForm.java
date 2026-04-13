package ru.touragency.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class RequestCreateForm {
    @NotNull
    private Integer clientId;
    @NotNull
    private Integer managerId;
    @NotNull
    private String directionName;
    @Min(1)
    @NotNull
    private Integer touristsCount;
    private BigDecimal plannedBudget;
    private String managerComment;

    public Integer getClientId() { return clientId; }
    public void setClientId(Integer clientId) { this.clientId = clientId; }
    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }
    public String getDirectionName() { return directionName; }
    public void setDirectionName(String directionName) { this.directionName = directionName; }
    public Integer getTouristsCount() { return touristsCount; }
    public void setTouristsCount(Integer touristsCount) { this.touristsCount = touristsCount; }
    public BigDecimal getPlannedBudget() { return plannedBudget; }
    public void setPlannedBudget(BigDecimal plannedBudget) { this.plannedBudget = plannedBudget; }
    public String getManagerComment() { return managerComment; }
    public void setManagerComment(String managerComment) { this.managerComment = managerComment; }
}
