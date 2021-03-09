package com.ironhack.coindex.service.interfaces;

import com.ironhack.coindex.dto.PositionUpdateDTO;

import java.util.List;

public interface IPositionUpdateService {
    PositionUpdateDTO getPositionUpdate(Long id);
    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);

    List<PositionUpdateDTO> getPositionUpdates(Long idPosition);
}
