package org.adaSchool.users.repository.model;

import org.adaSchool.users.controller.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name= "user", schema = "public")
public class User implements Serializable {
    @Id
    private final String id = UUID.randomUUID().toString();
    private String nationalId;
    private String name;
    private String genre;
    private Boolean isActive;
    private final Date created = new Date();

    public User() {
    }

    public User(UserDTO userDTO) {
        this.nationalId = userDTO.getNationalId();
        this.name = userDTO.getName();
        this.genre = userDTO.getGenre();
        this.isActive = userDTO.getActive();
    }

    public User(String nationalId, String name, String genre, Boolean isActive) {
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

    public String getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nationalId, user.nationalId) && Objects.equals(name, user.name) && Objects.equals(genre, user.genre) && Objects.equals(isActive, user.isActive) && Objects.equals(created, user.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nationalId, name, genre, isActive, created);
    }
}
