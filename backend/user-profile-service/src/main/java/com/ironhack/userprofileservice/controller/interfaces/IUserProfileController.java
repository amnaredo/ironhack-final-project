package com.ironhack.userprofileservice.controller.interfaces;

import com.ironhack.userprofileservice.dto.UserProfileDTO;

import java.util.List;

public interface IUserProfileController {
    List<UserProfileDTO> getAllUserProfiles();
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO);
    UserProfileDTO deleteUserProfile(Long id);
}
