package ru.touragency.dto;

import jakarta.validation.constraints.NotNull;

public class BookingCreateForm {
    @NotNull
    private Integer requestId;
    @NotNull
    private Integer managerId;
    @NotNull
    private String tourCode;
    @NotNull
    private String statusName;
    private String managerComment;

    public Integer getRequestId() { return requestId; }
    public void setRequestId(Integer requestId) { this.requestId = requestId; }
    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }
    public String getTourCode() { return tourCode; }
    public void setTourCode(String tourCode) { this.tourCode = tourCode; }
    public String getStatusName() { return statusName; }
    public void setStatusName(String statusName) { this.statusName = statusName; }
    public String getManagerComment() { return managerComment; }
    public void setManagerComment(String managerComment) { this.managerComment = managerComment; }
}
