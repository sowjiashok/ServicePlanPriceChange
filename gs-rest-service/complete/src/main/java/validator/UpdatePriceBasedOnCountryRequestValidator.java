package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UpdatePriceBasedOnCountryRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clase) {
		
		return UpdatePriceBasedOnCountryRequestValidator.class.equals(clase);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
