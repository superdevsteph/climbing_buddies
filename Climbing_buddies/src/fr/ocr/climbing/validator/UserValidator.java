package fr.ocr.climbing.validator;
 
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.ocr.climbing.model.UserInfo;
 
@Component
public class UserValidator implements Validator {

    // common-validator library.
    private EmailValidator emailValidator =   EmailValidator.getInstance();
 
    // The classes is supported to Validate
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
    	UserInfo userInfo = (UserInfo) target;
 
        // Check the fields of UserInfo.
        // (See more in property file: messages/validator.properties)
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty.userForm.passwordConfirm");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cotation", "NotEmpty.userForm.cotation");
       
       /* 
       if (!userInfo.getPasswordConfirm().equals(userInfo.getPassword())) {
           errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
       */
        if(!emailValidator.isValid(userInfo.getEmail())) {
            // Error in email field.
            errors.rejectValue("email", "Pattern.userForm.email");
        }
      ;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
            if (userInfo.getUsername().length() < 6 || userInfo.getUsername().length() > 32) {
                errors.rejectValue("username", "Size.userForm.username");
            }
           

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
            if (userInfo.getPassword().length() < 8 || userInfo.getPassword().length() > 32) {
                errors.rejectValue("password", "Size.userForm.password");
            }

            if (!userInfo.getPasswordConfirm().equals(userInfo.getPassword())) {
                errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            }
        }
       
    }
      
    
 