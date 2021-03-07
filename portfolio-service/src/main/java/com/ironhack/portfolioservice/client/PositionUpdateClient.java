package com.ironhack.portfolioservice.client;

import com.ironhack.portfolioservice.dto.PositionUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("position-update-service")
public interface PositionUpdateClient {

    @GetMapping("/updates/{id}")
    PositionUpdateDTO getPositionUpdate(Long id);

    @PostMapping("/positions/{id}/updates")
    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);

    @GetMapping("/positions/{id}/updates")
    List<PositionUpdateDTO> getPositionUpdates(Long idPosition);
}
