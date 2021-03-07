package com.ironhack.portfolioservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long idUserProfile;
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


    public Portfolio() {
    }

    public Portfolio(String name, String description, Long idUserProfile) {
        this.name = name;
        this.description = description;
        this.idUserProfile = idUserProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdUserProfile() {
        return idUserProfile;
    }

    public void setUserProfile(Long idUserProfile) {
        this.idUserProfile = idUserProfile;
    }



    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

}
