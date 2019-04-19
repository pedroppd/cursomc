package com.pedrodantas.cursomc.services.validation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload; 

public @interface ClienteInsert {
	
	@Constraint(validatedBy = ClienteInsertValidator.class) @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface Nome { 
	 
	String message() default "Erro de validação"; 
	 
	Class<?>[] groups() default {};     Class<? extends Payload>[] payload() default {}; } 
	 
}
