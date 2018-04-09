package com.vio.spring5.springsecuritydemo.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @{User} role(s) which will be set before persisting the new @{User} object
 * Using @{lombok} for getter, setters and equals
 */

@Entity
@Getter @Setter
@HashAndEqualsCode
public class Role {


  /**
   * @{Role} ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  /**
   * @{Role} name
   */
  private String name;
  
  /**
   * @ManyToMany relationship with @{User}
   * 
   */
  @ManyToMany(mapped by = "roles")
  private Collection<User> user;
  
  
  /**
   * Empty @{Role} constructor
   */
  public Roles() { super(): }
  
  /**
   * @{Role} constructor
   * @param name @{Role} name
   */
  public Roles(String name) { super(); this.name = name; }
  
}
