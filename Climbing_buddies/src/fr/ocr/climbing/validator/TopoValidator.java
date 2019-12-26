package fr.ocr.climbing.validator;
 
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.ocr.climbing.model.TopoInfo;
 
@Component
public class TopoValidator implements Validator {

   
    // The classes is supported to Validate
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == TopoInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
    	TopoInfo topoInfo = (TopoInfo) target;
 
        // Check the fields of TopoInfo.
        // (See more in property file: messages/validator.properties)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.userForm.nom");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", "NotEmpty.userForm.region");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbSites", "NotEmpty.userForm.nbSites");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbSecteurs", "NotEmpty.userForm.nbSecteurs");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nbVoies", "NotEmpty.userForm.nbVoies");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.userForm.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "datePublication", "NotEmpty.userForm.datePublication");
        
 
    
      
    }
 
}