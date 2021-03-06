package org.adaSchool.users.repository;

import org.adaSchool.users.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryPostgreSQL implements IUserRepository {
    @Autowired
    IUserJpaRepository postgresRepository;
    @Override
    public User createUser(User user) {
        return postgresRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return postgresRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.of(postgresRepository.getById(id));
    }
}
