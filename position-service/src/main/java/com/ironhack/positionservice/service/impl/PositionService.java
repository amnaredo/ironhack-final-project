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
//        if(!portfolioRepository.existsById(idPortfolio))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//        if (repository.findByCoinId(positionDTO.getCoinId()).isPresent())
//            throw new ResponseStatusException(HttpStatus.CONFLICT);
//
//        Portfolio portfolio = portfolioRepository.findById(idPortfolio).get();
        Position position = new Position();
        position.setAmount(positionDTO.getAmount());
        position.setCoinId(positionDTO.getCoinId());
        position.setIdPortfolio(positionDTO.getIdPortfolio());

//        PositionUpdate positionUpdate = new PositionUpdate();
//        positionUpdate.setAmount(positionDTO.getAmount());
//        positionUpdate.setDescription("Position creation");
//        position.addPositionUpdate(positionUpdate);
//
//        portfolio.addPosition(position);

        return new PositionDTO(repository.save(position));
    }

//    public void updatePosition(Long id, PositionDTO positionDTO) {
//        if(!repository.findById(id))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//        Position position =
//    }

    public void deletePosition(Long id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        repository.deleteById(id);
    }

    public List<PositionDTO> getPortfolioPositions(Long idPortfolio) {
//        if(!portfolioRepository.existsById(idPortfolio))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        List<Position> positions = repository.findByIdPortfolio(idPortfolio);
        List<PositionDTO> positionDTOList = new ArrayList<>();
        for(Position position: positions) {
            positionDTOList.add(new PositionDTO(position));
        }

        return positionDTOList;
    }
}
