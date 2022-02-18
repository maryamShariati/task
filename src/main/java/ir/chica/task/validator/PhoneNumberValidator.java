package ir.chica.task.validator;


import ir.chica.task.customAnnotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {


    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String phone = "";
        if (s.startsWith("+98")) {
            phone = s.replace("+98", "09");
        }else if  (s.startsWith("0098")) {
            phone = s.replace("0098", "09");
        }

        if (phone.startsWith("09") && phone.length() == 11) {
            return true;
        }else {
            return false;
        }
        }
    }
