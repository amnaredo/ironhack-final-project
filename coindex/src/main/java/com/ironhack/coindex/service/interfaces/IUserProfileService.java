package com.ironhack.coindex.service.interfaces;

import com.ironhack.coindex.dto.UserProfileDTO;
import com.ironhack.coindex.model.UserProfile;

public interface IUserProfileService {
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    void deleteUserProfile(Long id);
    void updateUserProfile(Long id, UserProfileDTO userProfileDTO);
}
