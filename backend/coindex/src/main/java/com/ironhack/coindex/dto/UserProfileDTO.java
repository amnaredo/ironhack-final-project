package com.ironhack.coindex.dto;

import com.ironhack.coindex.model.Portfolio;
import com.ironhack.coindex.model.UserProfile;

import java.time.LocalDateTime;
import java.util.Collection;

public class UserProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;


    public UserProfileDTO() {
    }

    public UserProfileDTO(UserProfile userProfile) {
        this();
        this.setId(userProfile.getId());
        this.setFirstName(userProfile.getFirstName());
        this.setLastName(userProfile.getLastName());
        this.setEmail(userProfile.getEmail());
        this.setPhotoUrl(userProfile.getPhotoUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
