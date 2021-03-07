package com.ironhack.userprofileservice.service.impl;

import com.ironhack.userprofileservice.dto.UserProfileDTO;
import com.ironhack.userprofileservice.model.UserProfile;
import com.ironhack.userprofileservice.repository.UserProfileRepository;
import com.ironhack.userprofileservice.service.interfaces.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserProfileService implements IUserProfileService {
    @Autowired
    private UserProfileRepository repository;

    public UserProfileDTO getUserProfile(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        UserProfile userProfile = repository.findById(id).get();
        return new UserProfileDTO(userProfile);
    }

    public UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO) {
        if (repository.findByEmail(userProfileDTO.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(userProfileDTO.getEmail());
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setPhotoUrl(userProfileDTO.getPhotoUrl());
        return new UserProfileDTO(repository.save(userProfile));
    }

    public void deleteUserProfile(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        repository.deleteById(id);
    }

    public void updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if (repository.findByEmail(userProfileDTO.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        UserProfile userProfile = repository.findById(id).get();
        userProfile.setEmail(userProfileDTO.getEmail());
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setPhotoUrl(userProfileDTO.getPhotoUrl());

        repository.save(userProfile);
    }
}
