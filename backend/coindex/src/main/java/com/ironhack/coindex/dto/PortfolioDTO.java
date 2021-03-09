package com.ironhack.coindex.dto;

import com.ironhack.coindex.model.Portfolio;
import com.ironhack.coindex.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PortfolioDTO {
    private String name;
    private String description;
    private List<PositionDTO> positions;

    public PortfolioDTO() {
    }

    public PortfolioDTO(Portfolio portfolio) {
        this();
        this.setName(portfolio.getName());
        this.setDescription(portfolio.getDescription());
        this.positions = new ArrayList<>();
        for(Position position: portfolio.getPositions()) {
            this.positions.add(new PositionDTO(position));
        }
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
