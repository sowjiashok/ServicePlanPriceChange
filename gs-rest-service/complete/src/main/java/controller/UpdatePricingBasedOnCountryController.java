package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.constants.UpdateServicePriceConstants;
import com.errorcodes.ServiceErrorCodes;
import com.exception.ApplicationException;
import com.model.PriceUpdateBasedOnCountryReportAsResponse;
import com.model.UpdatePriceBasedOnCountryRequest;
import com.service.UpdatePricingBasedOnCountryService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
@RequestMapping(value = UpdateServicePriceConstants.BASE_URI)
public class UpdatePricingBasedOnCountryController {
	
	private static Logger logger = LoggerFactory.getLogger(UpdatePricingBasedOnCountryController.class);
	
	
	@Autowired
	private UpdatePricingBasedOnCountryService updatePricingBasedOnCountryService;
	
	@Autowired
	@Qualifier("updatePriceBasedOnCountryRequestValidator")
	private Validator updatePriceBasedOnCountryRequestValidator;
	
	/* Wire the custom validator for the Request body */
	@InitBinder("updatePriceBasedOnCountryRequest")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(updatePriceBasedOnCountryRequestValidator);
	}
	

	/**
	 * Service to insert new pricing, based on given Country Code, New Pricing and Service Plan.
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/subscription-pricing", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PriceUpdateBasedOnCountryReportAsResponse> updatePricingBasedOnCountry(@Valid @RequestBody UpdatePriceBasedOnCountryRequest updatePriceBasedOnCountryRequest) throws Exception{
		logger.debug("Entering UpdatePricingBasedOnCountryController - updatePricingBasedOnCountry().." );
		
//		if(binding.hasErrors()) {
////			for(ObjectError e: binding.getAllErrors()) {
////				throw new ApplicationException(e.getCode(), ServiceErrorCodes.INVALID_SERVICE_DESCRIPTION.getReasonPhrase());
////			}
//			
//			throw new ApplicationException(ServiceErrorCodes.INVALID_SERVICE_DESCRIPTION.getValue(), ServiceErrorCodes.INVALID_SERVICE_DESCRIPTION.getReasonPhrase());
//		}

		/* Add new pricing based on Country and Service */
		PriceUpdateBasedOnCountryReportAsResponse updatedPriceReport = updatePricingBasedOnCountryService.updateServicePricing(updatePriceBasedOnCountryRequest);
		
		logger.debug("Exiting UpdatePricingBasedOnCountryController - updatePricingBasedOnCountry()" );

		return new ResponseEntity<PriceUpdateBasedOnCountryReportAsResponse> (updatedPriceReport, HttpStatus.OK);
	}

}
