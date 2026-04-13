package ru.touragency.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "partner")
public class Partner {
    @Id
    @Column(name = "partner_inn", nullable = false, length = 12)
    private String partnerInn;

    @Column(name = "partner_name", nullable = false, length = 150)
    private String partnerName;

    @Column(name = "phone", length = 25)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    public String getPartnerInn() { return partnerInn; }
    public void setPartnerInn(String partnerInn) { this.partnerInn = partnerInn; }
    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
