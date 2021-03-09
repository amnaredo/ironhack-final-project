package com.ironhack.positionupdateservice.controller.interfaces;

import com.ironhack.positionupdateservice.dto.PositionUpdateDTO;

import java.util.List;

public interface IPositionUpdateController {
    PositionUpdateDTO getPositionUpdate(Long id);
    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);
    PositionUpdateDTO deletePositionUpdate(Long id);

    List<PositionUpdateDTO> getPositionUpdates(Long idPosition);
}
