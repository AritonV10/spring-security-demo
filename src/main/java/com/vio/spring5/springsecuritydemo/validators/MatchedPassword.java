package com.vio.spring5.springsecuritydemo.validators;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {MatchedPasswordValidator.class})
@Retention(RUNTIME)
@Target(TYPE)
public @interface MatchedPassword {
	
  // the message if the passwords are not the same
	String message();
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
