package com.ironhack.managerservice.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PositionUpdateDTO {
    private BigDecimal amount;
    private String description;
    private LocalDateTime timestamp;

    public PositionUpdateDTO() {
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
