
package com.vio.spring5.springsecuritydemo.service;

import com.vio.spring5.springsecuritydemo.domain.User;

/*
 * @{User} service layer
 */
public interface UserService {
  
  /**
   * We will be expecting an @{UserCommand} object, set It's details to a new @{User} domain object
   * and persist the newly created @{User} then return it
   * Here you can @throw an @{EmailAlreadyExists} exception and @{UsernameAlreadyExists} exception
   * I will not do that in this demo. I'd highly suggest you to do it.
   * @param command @{UserCommand} object
   * @return @{User} domain object
   */
  User registerUser(UserCommand command);
  
  /**
   * Find a @{User} by their username and return it
   * You can @throw an @{AccountDoesntExist} exception
   * @param username @{User} username
   * @return @{User} domain object
   */
  User getUserByUsername(String username);
  
  /**
   * @return Set<@{User}>
   */
  Set<User> getUsers();
}
