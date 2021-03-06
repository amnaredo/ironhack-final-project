package com.ironhack.coindex.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "portfolio")
    private Collection<Position> positions;
    @ManyToOne
    private UserProfile userProfile;


    public Portfolio() {
    }

    public Portfolio(String name, String description, Collection<Position> positions, UserProfile userProfile) {
        this.name = name;
        this.description = description;
        this.positions = positions;
        this.userProfile = userProfile;
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

    public Collection<Position> getPositions() {
        return positions;
    }

    public void setPositions(Collection<Position> positions) {
        this.positions = positions;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
