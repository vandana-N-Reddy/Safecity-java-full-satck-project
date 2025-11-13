package com.safecity.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reporter_name")
    private String reporterName;

    private String location;

    private Double latitude;

    private Double longitude;

    @Column(name = "crime_type")
    private String crimeType;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    private String status = "REPORTED";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Report() {}

    // ✅ Getters & Setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getReporterName(){ return reporterName; }
    public void setReporterName(String reporterName){ this.reporterName = reporterName; }

    public String getLocation(){ return location; }
    public void setLocation(String location){ this.location = location; }

    public Double getLatitude(){ return latitude; }
    public void setLatitude(Double latitude){ this.latitude = latitude; }

    public Double getLongitude(){ return longitude; }
    public void setLongitude(Double longitude){ this.longitude = longitude; }

    public String getCrimeType(){ return crimeType; }
    public void setCrimeType(String crimeType){ this.crimeType = crimeType; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }

    public LocalDateTime getCreatedAt(){ return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt){ this.createdAt = createdAt; }
}
