

package com.vio.spring5.springsecuritydemo.command;

import java.util.Collection;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.*;

/**
* This is a command object which we will use for registration and validation
* After registration, we will create a new @{User} object and set It's fields to @{UserCommand}
* and persist the new @{User}
* We don't need a collection of @{Role}, because this class is only used for registration
* The role(s) will be set during @{User} persistance to the database
* I will be using @{lombok} throughout the demo to generate the getter and setters automatically
* For validation I will be displaying the error in English. If you want to use internationalization
* then use messages.properties
*/


@Getter @Setter
@NoArgsConstructor
/**
 * Custom annotation to verify if the password field matches the matchedPassword field
 * 
 */
@MatchedPassword(message = "The passwords don't match!")
public class UserCommand {
  
  /**
   * The @{UserCommand} ID
   */
  private Long id;
  
  /**
   * @{UserCommand} username
   * @Length username must be between 3 to 12 characters long
   */
  @NotBlank(message = "Username field can't be blank") 
  @Length(min=3, max=12, message = "The username must be between 3 to 12 characters long")
  private String username;
  /**
   * @{UserCommand} password
   * We use @NotBlank to make this field required
   * You can use a custom validation to check, for example, if the password has integers and special characters
   * @Length password must be between 3 to 15 characters long
   */
  @NotBlank(message = "Password field can't be blank") 
  @Length(min=3, max=12, message = "The password must be between 3 to 12 characters long")
  private String password;
  
  /**
  * @{UserCommand} matched password
  */
  @NotBlank("Confirm password field can't be empty")
  private String matchedPassword;
  
  /**
   * @{User} email
   * We will be using @Email validation.
   *
   */
  @Email(message="Not a valid email") @NotBlank(message = "Email field can't be empty)
  private String email;
  
}
