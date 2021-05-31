package javaProject.tastyFoodie.react.controllers;

import javaProject.tastyFoodie.react.models.User;
import javaProject.tastyFoodie.react.models.LoginUser;
import javaProject.tastyFoodie.react.repositories.UserRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepsitory;

    @GetMapping("/user")
    public User getUserId(@RequestHeader(value = "token") String userToken)throws Exception{
        if(userToken == null){
            throw new Exception("token is not pass");
        }
        User user = userRepsitory.findByUserToken(userToken);
        if(user == null){
            throw new Exception("User not found");
        }
        String encodedPassword = encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        return user;
    }
    
    @PostMapping("/register")
    public Boolean register(@RequestBody User user) throws Exception {
        if(userRepsitory.findByEmail(user.getEmail()) != null){
            throw new Exception("There is an account with that email adress:" + user.getEmail());
        }
        String encodedPassword = encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        userRepsitory.save(user);
        return true;
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUser userLogin) throws Exception{
        User user = userRepsitory.findByEmail(userLogin.getEmail());
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
        else if(!userLogin.getPassword().equals(encodePassword(user.getPassword()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }
        
        String uniqueID = UUID.randomUUID().toString();
        user.setUserToken(uniqueID);
        userRepsitory.save(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(uniqueID);
    }
    
    @PutMapping
    public User updatedUser(@RequestHeader(value = "token") String userToken, @RequestBody User user)throws Exception{
        if(userToken == null){
            throw new Exception("token is not pass");
        }
        User updatedUser = userRepsitory.findByUserToken(userToken);
        if(user == null){
            throw new Exception("User not found");
        }
       
        updatedUser.setEmail(user.getEmail());
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        String encodedPassword = encodePassword(user.getPassword());
        updatedUser.setPassword(encodedPassword);
        return userRepsitory.save(updatedUser);
    }

    public String encodePassword(String password){
        byte [] encodedPass = password.getBytes();
        byte [] res = new byte[encodedPass.length];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = encodedPass[res.length - i -1];
        }
        return new String(res);
    }
    
 }