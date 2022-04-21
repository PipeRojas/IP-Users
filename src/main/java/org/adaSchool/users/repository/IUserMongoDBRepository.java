package org.adaSchool.users.repository;

import org.adaSchool.users.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserMongoDBRepository extends MongoRepository<User, String> {
    Optional<User> findFirstByEmail(String email );
}
