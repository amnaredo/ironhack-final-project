package com.ironhack.userprofileservice.service.impl;

import com.ironhack.userprofileservice.dto.UserProfileDTO;
import com.ironhack.userprofileservice.model.UserProfile;
import com.ironhack.userprofileservice.repository.UserProfileRepository;
import com.ironhack.userprofileservice.service.interfaces.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService implements IUserProfileService {
    @Autowired
    private UserProfileRepository repository;

    public List<UserProfileDTO> getAllUserProfiles() {
        List<UserProfile> userProfiles = repository.findAll();
        List<UserProfileDTO> userProfileDTOList = new ArrayList<>();
        for(UserProfile userProfile: userProfiles) {
            userProfileDTOList.add(new UserProfileDTO(userProfile));
        }
        return userProfileDTOList;
    }

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

    public UserProfileDTO deleteUserProfile(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        UserProfile userProfile = repository.findById(id).get();
        repository.deleteById(id);

        UserProfileDTO userProfileDTO = new UserProfileDTO(userProfile);
        return userProfileDTO;
    }

    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        // email check
        UserProfile userProfile = repository.findById(id).get();
        Optional<UserProfile> userProfileByEmail = repository.findByEmail(userProfileDTO.getEmail());

        if (userProfileByEmail.isPresent() && !userProfileByEmail.get().getId().equals(userProfile.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        userProfile.setEmail(userProfileDTO.getEmail());
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setPhotoUrl(userProfileDTO.getPhotoUrl());

        repository.save(userProfile);
        return new UserProfileDTO(userProfile);
    }
}
