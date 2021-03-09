package com.ironhack.positionservice.dto;

import com.ironhack.positionservice.model.Position;

import java.math.BigDecimal;

public class PositionDTO {
    private Long id;
    private String coinId;
    private BigDecimal amount;
    private Long idPortfolio;

    public PositionDTO() {
    }

    public PositionDTO(Position position) {
        this();
        this.setId(position.getId());
        this.setCoinId(position.getCoinId());
        this.setAmount(position.getAmount());
        this.setIdPortfolio(position.getIdPortfolio());
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

    public Long getIdPortfolio() {
        return idPortfolio;
    }

    public void setIdPortfolio(Long idPortfolio) {
        this.idPortfolio = idPortfolio;
    }
}
