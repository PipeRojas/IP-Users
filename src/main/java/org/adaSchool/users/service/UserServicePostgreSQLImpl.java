package org.adaSchool.users.service;

import org.adaSchool.users.repository.IUserJpaRepository;
import org.adaSchool.users.repository.model.User;
import org.adaSchool.users.service.IUserService;

import java.util.List;
import java.util.Optional;

//@Service
/**
public class UserServicePostgreSQLImpl implements IUserService {
    //@Autowired
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
    
    @Override
    public User updateUser(String id, User user) {
    	return postgresRepository.save(user);
    }
  
    @Override
    public User deleteUser(String id) {
        Optional<User> ans = findById(id);
        if(ans.isPresent()){
            postgresRepository.deleteById(id);
        }
        return ans.get();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return postgresRepository.findFirstByEmail(email);
    }
}
 */