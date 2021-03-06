package com.ironhack.coindex.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coinId;
    private BigDecimal amount;
    @OneToMany(mappedBy = "position")
    private Collection<PositionUpdate> updates;
    @ManyToOne
    private Portfolio portfolio;

    public Position() {
    }

    public Position(String coinId, BigDecimal amount, Collection<PositionUpdate> updates) {
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

    public Collection<PositionUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(Collection<PositionUpdate> updates) {
        this.updates = updates;
    }
}
