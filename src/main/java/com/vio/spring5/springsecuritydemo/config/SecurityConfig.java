package com.vio.spring5.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    
    /**
     * Set the @{AutheticationProvider} to our @{CustomAutheticationProvider}
     * @param auth @{AutheticationManagerBuilder}
     /*
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.autheticationProvider(this.autheticationProvider());
    }
    
    
   /**
	 * We will configure our website by 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

      // @// @formatter:off
      http.authorizeRequests()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/registered-users").hasRole("USER");
            .anyRequest().authenticated()
          .and()
            .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/registered-users").failureUrl("/login?error=true")
          .and()
          .httpBasic()
          .and()
            .logout().invalidateHttpSession(false)
            .logoutSuccessUrl("/logout.html?logSucc=true")
            .deleteCookies("JSESSIONID")
            .permitAll()
          .and()
            .headers().frameOptions().disable()
          .and()
            .csrf().disable();	

      // @formatter:on

    }

    /**
     * PasswordEncoder bean
     * @return @{BCryptPasswordEncoder}
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
  
    @Bean
    public DaoAutheticationProvider autheticationProvider(){
        final CustomAutheticationProvider customAutheticationProvider = new CustomAutheticationProvider;
        customAutheticationProvider.setUserDetailsService(this.userDetailsService);
        customAutheticationProvider.setPasswordEncoder(passwordEncoder());
        
        return customAutheticationProvider;
    }
}
