package validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.constants.UpdateServicePriceConstants;
import com.errorcodes.ServiceErrorCodes;
import com.model.UpdatePriceBasedOnCountryRequest;

@Component(value = "updatePriceBasedOnCountryRequestValidator")
public class UpdatePriceBasedOnCountryRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clase) {
		
		return UpdatePriceBasedOnCountryRequestValidator.class.equals(clase);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UpdatePriceBasedOnCountryRequest request =  (UpdatePriceBasedOnCountryRequest	) target;
		validateUpdatePriceBasedOnCountryRequest(errors, request);
	}
	
	public void validateUpdatePriceBasedOnCountryRequest(Errors errors, UpdatePriceBasedOnCountryRequest updatePriceBasedOnCountryRequest) {
		String serviceDescription = updatePriceBasedOnCountryRequest.getServiceDescription();
		String customerCountryCode = updatePriceBasedOnCountryRequest.getCustomerCountry();
		BigDecimal priceChange = updatePriceBasedOnCountryRequest.getPriceChangeAmt();
		
		System.out.println("In validator");
		
		/* Validation against the input serviceDescription field
		 * 1. The service decription is allowed to be only either of the following; 1S, 2S, 4S
		 * 2. The alphabet needs to be uppercase, no lowercase bound is checked in the interest of time.
		 * 3. Uppercase/ lowercase enhancements can be supported in future */
		if(serviceDescription == null || serviceDescription.length() < UpdateServicePriceConstants.SERVICE_DESC_MIN_LEN || 
				serviceDescription.length() > UpdateServicePriceConstants.SERVICE_DESC_MIN_LEN || !UpdateServicePriceConstants.serviceSet.contains(serviceDescription)) {
			errors.rejectValue(UpdateServicePriceConstants.SERVICE_DESC_JSON_INPUT, ServiceErrorCodes.INVALID_SERVICE_DESCRIPTION.getValue());
		}
	}

}
