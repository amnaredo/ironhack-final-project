package com.ironhack.coindex.controller.impl;

import com.ironhack.coindex.controller.interfaces.IPositionUpdateController;
import com.ironhack.coindex.dto.PositionUpdateDTO;
import com.ironhack.coindex.service.interfaces.IPositionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionUpdateController implements IPositionUpdateController {
    @Autowired
    private IPositionUpdateService service;

    @GetMapping("/updates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionUpdateDTO getPositionUpdate(Long id) {
        return service.getPositionUpdate(id);
    }

    @PostMapping("/positions/{id}/updates")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO) {
        return service.addPositionUpdate(idPosition, positionUpdateDTO);
    }

    @GetMapping("/positions/{id}/updates")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionUpdateDTO> getPositionUpdates(Long idPosition) {
        return service.getPositionUpdates(idPosition);
    }
}
