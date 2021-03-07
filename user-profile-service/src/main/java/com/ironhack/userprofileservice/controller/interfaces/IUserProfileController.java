package com.ironhack.userprofileservice.controller.interfaces;

import com.ironhack.userprofileservice.dto.UserProfileDTO;

public interface IUserProfileController {
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    void updateUserProfile(Long id, UserProfileDTO userProfileDTO);
    void deleteUserProfile(Long id);
}
