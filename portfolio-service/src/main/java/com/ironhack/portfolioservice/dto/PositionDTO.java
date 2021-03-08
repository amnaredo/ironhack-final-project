package com.ironhack.portfolioservice.dto;

import java.math.BigDecimal;
import java.util.List;

public class PositionDTO {
    private Long id;
    private String coinId;
    private BigDecimal amount;
    private List<PositionUpdateDTO> updates;

    public PositionDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<PositionUpdateDTO> getUpdates() {
        return updates;
    }

    public void setUpdates(List<PositionUpdateDTO> updates) {
        this.updates = updates;
    }
}
