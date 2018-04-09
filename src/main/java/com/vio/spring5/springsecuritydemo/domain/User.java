import package com.vio.spring5.springsecuritydemo.domain;

import java.util.Collection;

import javax.persistence.JoinColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.*;

/**
* This is just a simple domain object. You can extend and build on top of it.
* The domain object we will use to persist a new user and logging in.
* I will be using @{lombok} throughout the demo to generate the getter and setters automatically
*/

@Entity
@Getter @Setter
@EqualsAndHashCode
public class User {
  
  /**
   * The @{User} ID generated AUTO by the database
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  /**
   * @{User} username
   */
  private String username;
  /**
   * @{User} password
   */
  private String password;
  
  /**
   * @{User} email
   */
  private String email;
  
  /**
  * @{User} roles (authorities)
  * @ManyToMany relationship with @{Roles}
  * Since It's a @ManyToMany relationship, 
  * we use the @JoinColumn to join the @{User} id and @{Role} id to one table
  */
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_role",
              joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<Role> roles;
  
  /**
  * Since this is just a simple demo, it will be set to true after registration
  * You can initialize as false after the registration if you want the
  * @{User} to confirm their Email first. Then set it to true and persist it to the database
  */
  private isEnabled;

}
