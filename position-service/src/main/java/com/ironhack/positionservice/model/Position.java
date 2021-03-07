package com.ironhack.positionservice.model;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coinId;
    private BigDecimal amount;
    private Long idPortfolio;

    public Position() {
    }

    public Position(String coinId, BigDecimal amount) {
        this.coinId = coinId;
        this.amount = amount;
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
