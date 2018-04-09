package com.vio.spring5.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.vio.spring5.springsecuritydemo.command.UserCommand;

/**
 * @{MatchedPassword}
 *
 */
public class MatchedPasswordValidator implements ConstraintValidator<MatchedPassword, Object> {

	
	/* 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(MatchedPassword constraintAnnotation) {
	
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		UserCommand user = (UserCommand) value;
		
    return user.getPassword().equals(user.getMatchedPassword());
	}

}
