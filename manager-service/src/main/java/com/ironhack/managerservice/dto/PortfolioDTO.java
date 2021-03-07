package com.ironhack.managerservice.dto;


import java.util.ArrayList;
import java.util.List;

public class PortfolioDTO {
    private String name;
    private String description;
    private List<PositionDTO> positions;

    public PortfolioDTO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PositionDTO> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDTO> positions) {
        this.positions = positions;
    }
}
