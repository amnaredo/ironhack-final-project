package com.ironhack.portfolioservice.dto;

//import com.ironhack.portfolioservice.model.PositionUpdate;

import java.math.BigDecimal;

public class PositionUpdateDTO {
    private Long id;
    private BigDecimal amount;
    private String description;

    public PositionUpdateDTO() {
    }

//    public PositionUpdateDTO(PositionUpdate positionUpdate) {
//        this();
//        this.setAmount(positionUpdate.getAmount());
//        this.setDescription(positionUpdate.getDescription());
//    }


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
}