package com.vio.spring5.springsecuritydemo.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vio.spring5.springsecuritydemo.domain.User;

/**
 * Repository to persist the @{User} domain object
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  
}
