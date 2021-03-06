package com.ironhack.userprofileservice.controller.impl;

import com.ironhack.userprofileservice.controller.interfaces.IUserProfileController;
import com.ironhack.userprofileservice.dto.UserProfileDTO;
import com.ironhack.userprofileservice.service.interfaces.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProfileController implements IUserProfileController {
    @Autowired
    private IUserProfileService service;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfileDTO> getAllUserProfiles() {
        return service.getAllUserProfiles();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDTO getUserProfile(@PathVariable Long id) {
        return service.getUserProfile(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileDTO addUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return service.addUserProfile(userProfileDTO);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserProfileDTO updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
        return service.updateUserProfile(id, userProfileDTO);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserProfileDTO deleteUserProfile(@PathVariable Long id) {
        return service.deleteUserProfile(id);
    }
}
