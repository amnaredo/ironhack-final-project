package com.ironhack.positionservice.service.impl;

import com.ironhack.positionservice.dto.PositionDTO;
import com.ironhack.positionservice.model.Position;
import com.ironhack.positionservice.repository.PositionRepository;
import com.ironhack.positionservice.service.interfaces.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private PositionRepository repository;

    public PositionDTO getPosition(Long id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new PositionDTO(repository.findById(id).get());
    }

    public PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO) {

        Position position = new Position();
        position.setIdPortfolio(idPortfolio);
        position.setAmount(positionDTO.getAmount());
        position.setCoinId(positionDTO.getCoinId());

        return new PositionDTO(repository.save(position));
    }

    public PositionDTO deletePosition(Long id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Position position = repository.findById(id).get();
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(id);
        positionDTO.setIdPortfolio(position.getIdPortfolio());
        positionDTO.setAmount(position.getAmount());
        positionDTO.setCoinId(position.getCoinId());

        repository.deleteById(id);

        return positionDTO;
    }

    public List<PositionDTO> getPortfolioPositions(Long idPortfolio) {

        List<Position> positions = repository.findByIdPortfolio(idPortfolio);
        List<PositionDTO> positionDTOList = new ArrayList<>();
        for(Position position: positions) {
            positionDTOList.add(new PositionDTO(position));
        }

        return positionDTOList;
    }
}
