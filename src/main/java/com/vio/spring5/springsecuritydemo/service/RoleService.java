package com.vio.spring5.springsecuritydemo.service;

/**
 * @{Role} service layer
 */
public Interface RoleService {

    /**
     * Find a @{Role} by It's name and return it
     * @param name @{Role} name
     * @return @{Role}
     */
    Role findRoleByName(String name);
}
