package com.vio.spring5.springsecuritydemo.service;
import com.vio.spring5.springsecuritydemo.repository.*;


import java.util.ArrayList;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 
 * @{UserService} interface implementation
 */
@Service
public class UserServiceImpl implements UserService{

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
    
    
	
    /**
     * Convert the @{UserCommand} to @{User} and persist it into the database
     * @param command @{UserCommand} object
     * @return @{User}
     */
    public User registerUser(UserCommand command) {
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
        
        // Add the @{Role} of ROLE_USER to the newly registered @{User}
	// and persist it
        user.setRoles(roles);
        
        return userRepository.save(user);
    }
	
    /**
     * Find a @{User} by their username and return it. If it doesn't exist, @throw an @{UserNotFound} exception
     * @param username @{User} username
     * @return @{User}
     */
    public User getUserByUsername(String username) {
	Optional<User> userOptional = userRepository.findByUsername(username);
	
	if(!userOptional.isPresent()){
	  // throw a UserNotFound exception
	}
	
	return userOptional.get();
    }
     /**
      * Get all @{User} and return them in a Set
      * @return Set<@{User}>
      */
     public Set<User> getUsers() {
	
	return StreamSupport.stream(userRepository.findAll()
			    .spliterator(), false)
			    .collectors(Collectors.toCollection(HashSet::new));
     }
}
