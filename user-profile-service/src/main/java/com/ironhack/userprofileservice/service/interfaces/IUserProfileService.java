package com.ironhack.userprofileservice.service.interfaces;

import com.ironhack.userprofileservice.dto.UserProfileDTO;

public interface IUserProfileService {
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    void deleteUserProfile(Long id);
    void updateUserProfile(Long id, UserProfileDTO userProfileDTO);
}
