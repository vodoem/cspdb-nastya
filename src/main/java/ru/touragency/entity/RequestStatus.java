package ru.touragency.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_status")
public class RequestStatus {
    @Id
    @Column(name = "status_name", length = 40)
    private String statusName;

    public String getStatusName() { return statusName; }
    public void setStatusName(String statusName) { this.statusName = statusName; }
}
