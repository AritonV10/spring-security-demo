
package com.vio.spring5.springsecuritydemo.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vio.spring5.springsecuritydemo.domain.Role;

/**
 * @{Role} repository
 */
 
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
  
    /**
     * Find a @{Role} by It's name and fetch it, if it exists
     * If it doesn't exist, @throw @{RoleNotFound} exception
     * @return @{Role} (if is present)
     */
    Optional<Role> findRoleByName(String name);
}
