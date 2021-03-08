package com.ironhack.positionupdateservice.service.impl;

import com.ironhack.positionupdateservice.dto.PositionUpdateDTO;
import com.ironhack.positionupdateservice.model.PositionUpdate;
import com.ironhack.positionupdateservice.repository.PositionUpdateRepository;
import com.ironhack.positionupdateservice.service.interfaces.IPositionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionUpdateService implements IPositionUpdateService {
    @Autowired
    private PositionUpdateRepository repository;

    public PositionUpdateDTO getPositionUpdate(Long id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new PositionUpdateDTO(repository.findById(id).get());
    }

    public PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO) {
        PositionUpdate positionUpdate = new PositionUpdate();
        positionUpdate.setIdPosition(idPosition);
        positionUpdate.setAmount(positionUpdateDTO.getAmount());
        positionUpdate.setDescription(positionUpdateDTO.getDescription());

        return new PositionUpdateDTO(repository.save(positionUpdate));
    }

    public PositionUpdateDTO deletePositionUpdate(Long id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        PositionUpdate positionUpdate = repository.findById(id).get();

        repository.delete(positionUpdate);
        return new PositionUpdateDTO(positionUpdate);
    }

    public List<PositionUpdateDTO> getPositionUpdates(Long idPosition) {

        List<PositionUpdate> updates = repository.findByIdPosition(idPosition);
        List<PositionUpdateDTO> positionUpdateDTOList = new ArrayList<>();
        for(PositionUpdate positionUpdate: updates) {
            positionUpdateDTOList.add(new PositionUpdateDTO(positionUpdate));
        }

        return positionUpdateDTOList;
    }
}
