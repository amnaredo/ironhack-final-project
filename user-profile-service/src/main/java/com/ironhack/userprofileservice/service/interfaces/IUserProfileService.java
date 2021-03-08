package com.ironhack.userprofileservice.service.interfaces;

import com.ironhack.userprofileservice.dto.UserProfileDTO;

import java.util.List;

public interface IUserProfileService {
    List<UserProfileDTO> getAllUserProfiles();
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    UserProfileDTO deleteUserProfile(Long id);
    UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO);
}
