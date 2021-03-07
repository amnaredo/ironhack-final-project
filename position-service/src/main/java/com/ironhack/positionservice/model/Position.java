package com.ironhack.positionservice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coinId;
    private BigDecimal amount;
    @ElementCollection(targetClass=Long.class)
    private List<Long> updates;
    private Long idPortfolio;

    public Position() {
    }

    public Position(String coinId, BigDecimal amount, List<Long> updates) {
        this.coinId = coinId;
        this.amount = amount;
        this.updates = updates;
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

    public Collection<Long> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Long> updates) {
        this.updates = updates;
    }

    public boolean addPositionUpdate(Long positionUpdate) {
        return this.updates.add(positionUpdate);
    }

    public Long getIdPortfolio() {
        return idPortfolio;
    }

    public void setIdPortfolio(Long idPortfolio) {
        this.idPortfolio = idPortfolio;
    }
}
