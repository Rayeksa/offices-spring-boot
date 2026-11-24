package com.rayek.offices;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tower;          // البرج
    private Integer floorNumber;   // الدور
    private String officeNumber;   // المكتب
    private String wing;           // الجناح
    private Integer area;          // المساحة
    private String status;         // VACANT أو RENTED
    private String tenantName;     // المستأجر
    private LocalDate startDate;   // يبدأ في
    private LocalDate endDate;     // ينتهي في

    public Office() {}

    public Long getId() { return id; }

    public String getTower() { return tower; }
    public void setTower(String tower) { this.tower = tower; }

    public Integer getFloorNumber() { return floorNumber; }
    public void setFloorNumber(Integer floorNumber) { this.floorNumber = floorNumber; }

    public String getOfficeNumber() { return officeNumber; }
    public void setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; }

    public String getWing() { return wing; }
    public void setWing(String wing) { this.wing = wing; }

    public Integer getArea() { return area; }
    public void setArea(Integer area) { this.area = area; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}