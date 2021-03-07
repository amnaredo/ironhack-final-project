package com.ironhack.portfolioservice.dto;

//import com.ironhack.portfolioservice.model.Position;

import java.math.BigDecimal;

public class PositionDTO {
    private String coinId;
    private BigDecimal amount;

    public PositionDTO() {
    }

//    public PositionDTO(Position position) {
//        this();
//        this.setCoinId(position.getCoinId());
//        this.setAmount(position.getAmount());
//    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
