package com.ironhack.portfolioservice.client;

import com.ironhack.portfolioservice.dto.PositionUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("position-update-service")
public interface PositionUpdateClient {

    @GetMapping("/updates/{id}")
    PositionUpdateDTO getPositionUpdate(@PathVariable Long id);

    @PostMapping("/positions/{id}/updates")
    PositionUpdateDTO addPositionUpdate(@PathVariable Long idPosition, @RequestBody PositionUpdateDTO positionUpdateDTO);

    @GetMapping("/positions/{id}/updates")
    List<PositionUpdateDTO> getPositionUpdates(@PathVariable Long idPosition);
}
