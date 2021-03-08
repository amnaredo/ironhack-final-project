package com.ironhack.managerservice.dto;


import java.math.BigDecimal;
import java.util.List;

public class PositionDTO {
//    private Long id;
    private String coinId;
    private BigDecimal amount;
    private List<PositionUpdateDTO> updates;

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

    public List<PositionUpdateDTO> getUpdates() {
        return updates;
    }

    public void setUpdates(List<PositionUpdateDTO> updates) {
        this.updates = updates;
    }
}
