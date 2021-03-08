package com.ironhack.positionupdateservice.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PositionUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime timestamp;
    @Column(precision = 20, scale = 8, columnDefinition="DECIMAL(20,8)")
    private BigDecimal amount;
    private String description;
    private Long idPosition;

    public PositionUpdate() {
    }

    public PositionUpdate(LocalDateTime timestamp, BigDecimal amount, String description, Long idPosition) {
        this.timestamp = timestamp;
        this.amount = amount;
        this.description = description;
        this.idPosition = idPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }
}
