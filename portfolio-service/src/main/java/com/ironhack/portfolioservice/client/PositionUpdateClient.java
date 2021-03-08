package com.ironhack.portfolioservice.client;

import com.ironhack.portfolioservice.dto.PositionUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("positionUpdate-service")
public interface PositionUpdateClient {

    @GetMapping("/updates/{id}")
    PositionUpdateDTO getPositionUpdate(@PathVariable Long id);

    @PostMapping("/positions/{idPosition}/updates")
    PositionUpdateDTO addPositionUpdate(@PathVariable Long idPosition, @RequestBody PositionUpdateDTO positionUpdateDTO);

    @DeleteMapping("/updates/{id}")
    PositionUpdateDTO deletePositionUpdate(@PathVariable Long id);

    @GetMapping("/positions/{idPosition}/updates")
    List<PositionUpdateDTO> getPositionUpdates(@PathVariable Long idPosition);


}
