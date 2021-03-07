package com.ironhack.positionupdateservice.service.interfaces;

import com.ironhack.positionupdateservice.dto.PositionUpdateDTO;

import java.util.List;

public interface IPositionUpdateService {
    PositionUpdateDTO getPositionUpdate(Long id);
    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);

    List<PositionUpdateDTO> getPositionUpdates(Long idPosition);
}
