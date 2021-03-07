package com.ironhack.positionupdateservice.dto;

import com.ironhack.positionupdateservice.model.PositionUpdate;

import java.math.BigDecimal;

public class PositionUpdateDTO {
    private BigDecimal amount;
    private String description;

    public PositionUpdateDTO() {
    }

    public PositionUpdateDTO(PositionUpdate positionUpdate) {
        this();
        this.setAmount(positionUpdate.getAmount());
        this.setDescription(positionUpdate.getDescription());
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
}
