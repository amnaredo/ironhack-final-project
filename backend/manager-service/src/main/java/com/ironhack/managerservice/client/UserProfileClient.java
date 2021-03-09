package com.ironhack.managerservice.client;

import com.ironhack.managerservice.dto.UserProfileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("userProfile-service")
public interface UserProfileClient {

    @GetMapping("/users")
    List<UserProfileDTO> getAllUserProfiles();

    @GetMapping("/users/{id}")
    UserProfileDTO getUserProfile(@PathVariable Long id);

    @PostMapping("/users")
    UserProfileDTO addUserProfile(@RequestBody UserProfileDTO userProfileDTO);

    @PutMapping("/users/{id}")
    UserProfileDTO updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO);

    @DeleteMapping("/users/{id}")
    UserProfileDTO deleteUserProfile(@PathVariable Long id);
}
