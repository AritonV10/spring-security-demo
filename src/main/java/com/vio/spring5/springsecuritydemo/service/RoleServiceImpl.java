package com.vio.spring5.springsecuritydemo.service;

import com.vio.spring5.springsecuritydemo.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * @{RoleService} interface implementation
 */
@Service
public class RoleServiceImpl implements RoleService {
    
    /**
     * @{Role} repository to help us fetch data
     */
    @Autowired
    private RoleRepository roleRepository;
    
    /**
     * @{Logger} to help us at debugging errors
     */
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    
    /**
     * Find a @{Role} by It's name
     * @param name @{Role} name
     * @return @{Role}
     */
    public Role findRoleByName(String name) {
        Optional<Role> roleOptional = roleRepository.findRoleByName(name);
        
        if(!roleOptional.isPresent()){
          // throw an @{RoleNotFound} exception
        }
        
        return roleOptional.get();
    }
}
