package com.ironhack.userprofileservice.controller.impl;

import com.ironhack.userprofileservice.controller.interfaces.IUserProfileController;
import com.ironhack.userprofileservice.dto.UserProfileDTO;
import com.ironhack.userprofileservice.service.interfaces.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController implements IUserProfileController {
    @Autowired
    private IUserProfileService service;

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
    public void updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
        service.updateUserProfile(id, userProfileDTO);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserProfile(@PathVariable Long id) {
        service.deleteUserProfile(id);
    }
}
