package org.adaSchool.users.repository;

import org.adaSchool.users.repository.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    User createUser(User user);

    List<User> getAll();

    Optional<User> findById(String id );

    User updateUser(String id, User user);

    User deleteUser(String id);
}
