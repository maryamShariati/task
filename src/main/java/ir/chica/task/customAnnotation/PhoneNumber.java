package ir.chica.task.customAnnotation;


import ir.chica.task.validator.PhoneNumberValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PhoneNumber {
    String massage() default "this phoneNumber is invalid";




}
