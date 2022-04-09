package org.adaSchool.users.repository;

import org.adaSchool.users.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserJpaRepository extends JpaRepository<User,String> {
    Optional<User> findFirstByEmail(String email );
}
