package com.vio.spring5.springsecuritydemo.security;

import com.vio.spring5.springsecuritydemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class CustomAutheticationProvider extends DaoAuthenticationProvider {


    @Autowired
    private UserService userService;
    
    /**
     * @param authetication used to find @{User} by their name
     * @return @{Authetication}
     */
    @Override
    public Authentication authetication(Authentication authetication) throws AuthenticationException {
          
          // Find the @{User} by their name
          User user = userService.getUserByUsername(authetication.getName());
          
          if((user == null)){
              throw new BadCredentialException("Invalid username or password");
          }
          
          final Authetication auth = super.autheticate(authetication);
          
          return UsernamePasswordAutheticationToken(user, auth.getCredentials(), auth.getAuthorities());
    
    }
    
    @Override
	  public boolean supports(Class<?> authentication) {
		  return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
