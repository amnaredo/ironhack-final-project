package com.ironhack.userprofileservice.service.interfaces;

import com.ironhack.userprofileservice.dto.UserProfileDTO;

public interface IUserProfileService {
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    UserProfileDTO deleteUserProfile(Long id);
    UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO);
}
