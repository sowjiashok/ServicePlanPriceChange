package com.service;

import com.exception.ApplicationException;
import com.model.PriceUpdateBasedOnCountryReportAsResponse;
import com.model.UpdatePriceBasedOnCountryRequest;

public interface UpdatePricingBasedOnCountryService {

	/* Api for updating Membership price based on given Country, Price and Service Description.*/
	public PriceUpdateBasedOnCountryReportAsResponse updateServicePricing(UpdatePriceBasedOnCountryRequest updatePriceRequest) throws ApplicationException, Exception;

}
