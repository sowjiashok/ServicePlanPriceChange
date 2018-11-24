package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.PriceUpdateBasedOnCountryReportAsResponse;
import com.model.UpdatePriceBasedOnCountryRequest;
import com.service.UpdatePricingBasedOnCountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Validated
@RestController
public class UpdatePricingBasedOnCountryController {
	
	private static Logger logger = LoggerFactory.getLogger(UpdatePricingBasedOnCountryController.class);
	
	
	@Autowired
	UpdatePricingBasedOnCountryService updatePricingBasedOnCountryService;
	
	
	
	
	/**
	 * Service to create a Message
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/subscription-pricing", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PriceUpdateBasedOnCountryReportAsResponse> updatePricingBasedOnCountry(@RequestBody UpdatePriceBasedOnCountryRequest updatePriceRequest) throws Exception{
		logger.debug("Entering UpdatePricingBasedOnCountryController - updatePricingBasedOnCountry().." );

		/* Add message to the in-memory store */
		PriceUpdateBasedOnCountryReportAsResponse updatedPriceReport = updatePricingBasedOnCountryService.updateServicePricing(updatePriceRequest);
		
		logger.debug("Exiting UpdatePricingBasedOnCountryController - updatePricingBasedOnCountry()" );

		return new ResponseEntity<PriceUpdateBasedOnCountryReportAsResponse> (updatedPriceReport, HttpStatus.OK);
	}

}
