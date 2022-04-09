package org.adaSchool.users.repository.model;

import org.adaSchool.users.controller.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCrypt;

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
    private String passwordHash;
    private String email;

    public User() {
    }

    public User(UserDTO userDTO) {
        this.nationalId = userDTO.getNationalId();
        this.name = userDTO.getName();
        this.genre = userDTO.getGenre();
        this.isActive = userDTO.getActive();
        this.email = userDTO.getEmail();
        this.passwordHash = BCrypt.hashpw( userDTO.getPassword(), BCrypt.gensalt() );
    }

    public User(String nationalId, String name, String genre, Boolean isActive, String email, String password) {
        this.nationalId = nationalId;
        this.name = name;
        this.genre = genre;
        this.isActive = isActive;
        this.email = email;
        this.passwordHash = BCrypt.hashpw( password, BCrypt.gensalt() );
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
