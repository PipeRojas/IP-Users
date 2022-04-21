package org.adaSchool.users.service;

import org.adaSchool.users.repository.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User createUser(User user);

    List<User> getAll();

    Optional<User> findById(String id );

    User updateUser(String id, User user);

    User deleteUser(String id);

    Optional<User> findByEmail(String email);
}