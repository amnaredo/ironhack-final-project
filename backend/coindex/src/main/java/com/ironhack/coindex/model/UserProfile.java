package com.ironhack.coindex.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(unique = true)
    private String photoUrl;
    @OneToMany(mappedBy = "userProfile")
    private Collection<Portfolio> portfolios;
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    private LocalDateTime lastAccessDateTime;


    public UserProfile() {
    }

    public UserProfile(String firstName, String lastName, String email, String photoUrl, Collection<Portfolio> portfolios) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photoUrl = photoUrl;
        this.portfolios = portfolios;
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

    public Collection<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Collection<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}
