package com.ironhack.coindex.controller.interfaces;

import com.ironhack.coindex.dto.PositionUpdateDTO;

import java.util.List;

public interface IPositionUpdateController {
    PositionUpdateDTO getPositionUpdate(Long id);
    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);

    List<PositionUpdateDTO> getPositionUpdates(Long idPosition);
}
