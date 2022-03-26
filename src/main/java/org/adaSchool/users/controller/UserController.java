package org.adaSchool.users.controller;

import org.adaSchool.users.controller.dto.UserDTO;
import org.adaSchool.users.repository.IUserRepository;
import org.adaSchool.users.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final IUserRepository userRepository;
    public UserController(@Autowired IUserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User create(@RequestBody UserDTO userDto ){
        return userRepository.createUser( new User( userDto ) );
    }

    @GetMapping
    public List<User> getAll(){ return userRepository.getAll();}

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable String id ){
        return userRepository.findById( id );
    }
}
