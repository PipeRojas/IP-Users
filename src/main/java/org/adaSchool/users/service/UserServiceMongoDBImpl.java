package org.adaSchool.users.service;

import org.adaSchool.users.repository.IUserMongoDBRepository;
import org.adaSchool.users.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDBImpl implements IUserService {
    @Autowired
    IUserMongoDBRepository mongoRepository;
    @Override
    public User createUser(User user) {
        return mongoRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return mongoRepository.findById(id);
    }

    @Override
    public User updateUser(String id, User user) {
        return mongoRepository.save(user);
    }

    @Override
    public User deleteUser(String id) {
        Optional<User> ans = findById(id);
        if(ans.isPresent()){
            mongoRepository.deleteById(id);
        }
        return ans.get();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return mongoRepository.findFirstByEmail(email);
    }
}
