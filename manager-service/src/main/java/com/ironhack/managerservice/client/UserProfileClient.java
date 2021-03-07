package com.ironhack.managerservice.client;

import com.ironhack.managerservice.dto.UserProfileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-profile-service")
public interface UserProfileClient {

    @GetMapping("/users/{id}")
    UserProfileDTO getUserProfile(@PathVariable Long id);

    @PostMapping("/users")
    UserProfileDTO addUserProfile(@RequestBody UserProfileDTO userProfileDTO);

    @PutMapping("/users/{id}")
    void updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO);

    @DeleteMapping("/users/{id}")
    void deleteUserProfile(@PathVariable Long id);
}
