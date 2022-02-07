package ir.chica.task.customAnnotation;


import ir.chica.task.validator.SexValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SexValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface SexAnnotation {

    String massage() default "the entered parameter is incorrect";

}
