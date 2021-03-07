package com.ironhack.managerservice.dto;


import java.math.BigDecimal;

public class PositionDTO {
    private String coinId;
    private BigDecimal amount;

    public PositionDTO() {
    }


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
