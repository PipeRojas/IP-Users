package org.adaSchool.users.controller.auth;

import org.adaSchool.users.controller.security.JWTGenerate;
import org.adaSchool.users.exception.InvalidCredentialsException;
import org.adaSchool.users.service.IUserService;
import org.adaSchool.users.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/auth")
public class AuthController {

    @Autowired
    private JWTGenerate jwtGenerate;

    @Autowired
    IUserService userService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        User user = userService.findByEmail(request.getEmail()).get();
        String jwt = "";
        if(BCrypt.checkpw(request.getPassword(),user.getPasswordHash())){
            jwt = jwtGenerate.generateTokenv2(user);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }else {
            throw new InvalidCredentialsException();
        }
    }
}