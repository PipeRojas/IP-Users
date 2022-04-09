package org.adaSchool.users.repository;

import org.adaSchool.users.repository.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class UserRepositoryMap implements IUserRepository{
    private static final HashMap<String, User> usersMap = new HashMap<>();
    @Override
    public User createUser(User user) {
        return usersMap.put(user.getId(), user);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.of(usersMap.get(id));
    }
    
    @Override
    public User updateUser(String id, User user) {
    	if( usersMap.containsKey(id)) {
    		return usersMap.put(id, user);
    	}
    	return null;
    }
    
    @Override
    public User deleteUser(String id) {
    	if( usersMap.containsKey(id)) {
    	 return  usersMap.remove( id ) ;
    	}
    	return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return usersMap.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
}
