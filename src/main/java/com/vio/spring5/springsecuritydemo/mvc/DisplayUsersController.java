package com.vio.spring5.springsecuritydemo.mvc;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vio.spring5.springsecuritydemo.service.UserService;

/**
 * Display all registered @{User}
 */
@Controller
@RequestMapping(value = "/registered-users")
public class DisplayUsersController {
  
  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.GET){
  public displayRegisteredUsers(Model model){
    
    model.addAttribute("users", userService.getUsers());
    
    return "registered_users";
  }
}
