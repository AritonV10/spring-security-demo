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
 * @{User} registration controller
 */
@Controller
@RequestMapping(value = "/register")
public class UserRegisterController {
    
   /**
    * @{User} service interface
    */
   @Autowired
   private UserService userService;
   
   /**
    * @{Logger} to help us debug errors
    */
   private Logger log = LoggerFactory.getLogger(this.getClass());
   
   /**
    * When the User types in "/register" this method will get called 
    * Sends a @{UserCommand} object to front for registration
    */
   @RequestMapping(method = RequestMethod.GET)
   public String sendUserObject(Model model){
   
      model.addAttribute("user", new UserCommand());
      
      return "register";
   }
   
   /**
    * When the user is done and presses on the registration button
    * this method gets called and expects a @{UserCommand} object
    * If It's valid, then it registeres the users else it redirects back to registration page
    * @param bindingResult @{BindingResult} for validation
    * @param user @{UserCommand} object
    */
   @RequestMapping(method = RequestMethod.POST)
   public String registerUser(@ModelAttribute(name = "user") @Valid UserCommand user, BindingResult bindingResult){
   
      // Checking if the @{UserCommand} has errors
      if(bindingResult.hasError){
         bindingResult.getErrors
                      .forEach(error -> {
                       log.debug(error.toString()); )
      
        return "/register";
      }
      
      // If it has no errors, it converts the @{UserCommand} to @{User} and persists it
      // with the help of our @{UserService}
      userService.registerUser(user);
      
      // Redirecting to login page to login
      return "redirect:/login";
   }
}
