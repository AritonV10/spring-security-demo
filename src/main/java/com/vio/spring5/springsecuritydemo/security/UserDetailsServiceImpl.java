/**
 * 
 */
package com.vio.spring5.springsecuritydemo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vio.spring5.springsecuritydemo.domain.User;
import com.vio.spring5.springsecuritydemo.domain.Role;
import com.vio.spring5.springsecuritydemo.repository.UserRepository;

/**
 * 
 * @{UserDetailsService} interface implementation
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private  UserRepository userRepository;
	
    /**
     * @{UserDetailsService} helps us verify if the User's credentials matches their @{User} account
     * @username @{User} username
     * @return @{UserDetails} object
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/**
		 * Tries to find the username by userame
		 * if not found @throws @{UsernameNotFoundException)
		 */
		try {
			Optional<User> user = userRepository.findByUsername(username);
			
			if(!user.isPresent()) {
				throw new UsernameNotFoundException("No user found with the username: " + username);
			}
			
                        // Return an @{UserDetails} @{User} which has the details of the User's @{User} account that wants
                        // to login
			return new org.springframework.security.core.userdetails.User(
					user.get().getUsername(), user.get().getPassword(), user.get().isEnabled(), 
				  true, true, true, getAuthorities(user.get().getRoles()));
		
		} catch (final Exception e) {
			
			throw new RuntimeException(e);
		}
			
	}
	
	
	/**
	 * Return a list of Users granted authorities
	 * @param roles Collection<@{Role}>
	 * @return Collection<@{GrantedAuthority}>
	 */
	private static Collection<? extends GrantedAuthority> getAuthorities(final Collection<Roles> roles){
		
                // Create an Collection<GrantedAuthority>
		final  Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
                // Add the @{User} roles to the grantedAuthority Collection and return the Collection
		for(Roles role : roles) {
			grantedAuthority.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		return grantedAuthority;
		
	}

	
	


}
