package com.ironhack.positionupdateservice.controller.impl;

import com.ironhack.positionupdateservice.controller.interfaces.IPositionUpdateController;
import com.ironhack.positionupdateservice.dto.PositionUpdateDTO;
import com.ironhack.positionupdateservice.service.interfaces.IPositionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionUpdateController implements IPositionUpdateController {
    @Autowired
    private IPositionUpdateService service;

    @GetMapping("/updates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionUpdateDTO getPositionUpdate(@PathVariable Long id) {
        return service.getPositionUpdate(id);
    }

    @PostMapping("/positions/{idPosition}/updates")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionUpdateDTO addPositionUpdate(@PathVariable Long idPosition, @RequestBody PositionUpdateDTO positionUpdateDTO) {
        return service.addPositionUpdate(idPosition, positionUpdateDTO);
    }

    @DeleteMapping("/updates/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PositionUpdateDTO deletePositionUpdate(@PathVariable Long id) {
        return service.deletePositionUpdate(id);
    }

    @GetMapping("/positions/{idPosition}/updates")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionUpdateDTO> getPositionUpdates(@PathVariable Long idPosition) {
        return service.getPositionUpdates(idPosition);
    }
}
