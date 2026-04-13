package ru.touragency.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direction")
public class Direction {
    @Id
    @Column(name = "direction_name", nullable = false, length = 100)
    private String directionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_name", nullable = false)
    private Country country;

    public String getDirectionName() { return directionName; }
    public void setDirectionName(String directionName) { this.directionName = directionName; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
}
