package com.vio.spring5.springsecuritydemo.service;
import com.vio.spring5.springsecuritydemo.repository.*;


import java.util.ArrayList;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    /**
     * 
     * @{User} repository to save the @{User} entity
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * @{Role} service to help us fetch a @{Role} object by It's name
     */
    @Autowired
    private RoleService roleService;
    
    /**
     * Password encrypter to encrypt @{User} password
     */
    @Autowired
	  private  PasswordEncoder passwordEncoder;
   
   /**
    * Logger useful for debugging
    */
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    
    User registerUser(UserCommand command) {
        // Here you can check if the @{UserCommand} email and username already exists
        // If it does, then throw an exception
        
        User user = new User();
        user.setUsername(command.getUsername);
        user.setEmail(command.getEmail);
        user.setPassword(passwordEncoder.encode(command.getPassword()));
        
        // Create a collection of @{Role} and fetch a @{Role} by It's name
        // with the help of @{RoleService}, and add it into the collection
        final Collection<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_USER");
        
        user.setRoles(roles);
        
        return userRepository.save(user);
    }
}
