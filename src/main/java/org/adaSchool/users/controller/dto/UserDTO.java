package org.adaSchool.users.controller.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String nationalId;
    private String name;
    private String genre;
    private Boolean isActive;

    public UserDTO(String nationalId, String name, String genre, Boolean isActive) {
        this.nationalId = nationalId;
        this.name = name;
        this.genre = genre;
        this.isActive = isActive;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
