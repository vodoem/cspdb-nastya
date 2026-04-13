package ru.touragency.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tourist_request")
public class TouristRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direction_name", nullable = false)
    private Direction direction;

    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_name", nullable = false)
    private RequestStatus status;

    @Column(name = "tourists_count", nullable = false)
    private Integer touristsCount;

    @Column(name = "planned_budget", precision = 12, scale = 2)
    private BigDecimal plannedBudget;

    @Column(name = "manager_comment", columnDefinition = "text")
    private String managerComment;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public Integer getTouristsCount() { return touristsCount; }
    public void setTouristsCount(Integer touristsCount) { this.touristsCount = touristsCount; }
    public BigDecimal getPlannedBudget() { return plannedBudget; }
    public void setPlannedBudget(BigDecimal plannedBudget) { this.plannedBudget = plannedBudget; }
    public String getManagerComment() { return managerComment; }
    public void setManagerComment(String managerComment) { this.managerComment = managerComment; }
}
