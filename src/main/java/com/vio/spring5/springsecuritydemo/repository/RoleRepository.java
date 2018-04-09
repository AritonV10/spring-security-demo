
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

}
