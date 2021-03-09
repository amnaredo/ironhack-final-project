package com.ironhack.coindex.service.impl;

import com.ironhack.coindex.dto.PositionUpdateDTO;
import com.ironhack.coindex.model.PositionUpdate;
import com.ironhack.coindex.repository.PositionRepository;
import com.ironhack.coindex.repository.PositionUpdateRepository;
import com.ironhack.coindex.service.interfaces.IPositionUpdateService;
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
    @Autowired
    private PositionRepository positionRepository;

    public PositionUpdateDTO getPositionUpdate(Long id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new PositionUpdateDTO(repository.findById(id).get());
    }

    public PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO) {
        if(!positionRepository.existsById(idPosition))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        PositionUpdate positionUpdate = new PositionUpdate();
        positionUpdate.setAmount(positionUpdateDTO.getAmount());
        positionUpdate.setDescription(positionUpdateDTO.getDescription());

        return new PositionUpdateDTO(repository.save(positionUpdate));
    }

    public List<PositionUpdateDTO> getPositionUpdates(Long idPosition) {
        if(!positionRepository.existsById(idPosition))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        List<PositionUpdate> updates = repository.findByPosition(positionRepository.findById(idPosition).get());
        List<PositionUpdateDTO> positionUpdateDTOList = new ArrayList<>();
        for(PositionUpdate positionUpdate: updates) {
            positionUpdateDTOList.add(new PositionUpdateDTO(positionUpdate));
        }

        return positionUpdateDTOList;
    }
}
