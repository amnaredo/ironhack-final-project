package com.ironhack.coindex.service.interfaces;

import com.ironhack.coindex.dto.PositionDTO;

public interface IPositionService {

    PositionDTO addPosition(Long id, PositionDTO positionDTO);
    void updatePosition(Long id, PositionDTO positionDTO);
    void deletePosition(Long id);
}
