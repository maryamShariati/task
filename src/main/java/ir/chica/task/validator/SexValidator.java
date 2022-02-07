package ir.chica.task.validator;


import ir.chica.task.customAnnotation.SexAnnotation;
import ir.chica.task.enumTest.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements ConstraintValidator<SexAnnotation,String> {
    public Gender gender;

    public SexValidator(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void initialize(SexAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.equals("MAN")||s.equals("WOMAN")){
            return true;
        }else {
            return false;
        }
    }
}
