package co.za.myprofileservice.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import co.za.myprofileservice.services.IsEmailValid;

public class EmailValidator implements ConstraintValidator<IsEmailValid, String>{

	private Pattern pattern;
	private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return validateEmail(email);
	}
	
	// validate email
	public boolean validateEmail(String email) {
		
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
