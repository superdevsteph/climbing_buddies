package fr.ocr.climbing.validator;
 
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.ocr.climbing.model.UserInfo;
 
@Component
public class LoginValidator implements Validator {

  
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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");

    
      
    }
 
}