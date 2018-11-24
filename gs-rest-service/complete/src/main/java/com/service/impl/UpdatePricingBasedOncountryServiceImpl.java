package com.service.impl;

import java.math.BigDecimal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.CountryDAO;
import com.dao.ServicePlanDAO;
import com.exception.ApplicationException;
import com.model.PriceUpdateBasedOnCountryReportAsResponse;
import com.model.ServicePlan;
import com.model.UpdatePriceBasedOnCountryRequest;
import com.service.UpdatePricingBasedOnCountryService;
@Component
@Service(value = "UpdatePricingBasedOnCountryService")
public class UpdatePricingBasedOncountryServiceImpl implements UpdatePricingBasedOnCountryService {
	
	private static final Logger logger = LoggerFactory.getLogger(UpdatePricingBasedOncountryServiceImpl.class);
	
	@Autowired
	@Qualifier("ServicePlanDAOImpl")
	private ServicePlanDAO servicePlanDao;
	
	@Autowired
	@Qualifier("CountryDAOImpl")
	private CountryDAO countryDAO;
		
	/* Api for updating Membership price based on given Country, Price and Service Description.*/
	public PriceUpdateBasedOnCountryReportAsResponse updateServicePricing (UpdatePriceBasedOnCountryRequest updatePriceRequest) throws ApplicationException, Exception {
		
		if(logger.isDebugEnabled()) {
			logger.debug("Entering UpdatePricingBasedOncountryServiceImpl - updateServicePricing() class.." );
		}
		
		PriceUpdateBasedOnCountryReportAsResponse response = new PriceUpdateBasedOnCountryReportAsResponse();
		String serviceDesc = updatePriceRequest.getServiceDescription();
		if(logger.isDebugEnabled()) {
			logger.info("Service Description: " + serviceDesc);
		}
		
		BigDecimal priceChange = updatePriceRequest.getPriceChangeAmt();
		
		String countryName = updatePriceRequest.getCustomerCountry();
		/* Step 1: Get the Service ID, for the given service description*/
		ServicePlan servicePlan = servicePlanDao.getServiceIdByServiceDecsription(serviceDesc);
		int serviceId = servicePlan.getServiceId();
		
		if(logger.isDebugEnabled()) {
			logger.debug("Step 1-Result: Service Desc" + serviceDesc);
		}
		
		/* Step 2: Get the country code, for the given country*/
        String countryCode = countryDAO.getCountryCodeByDescription(countryName);
		if(logger.isDebugEnabled()) {
			logger.debug("Step 2-Result: Country code: " + countryCode);
		}
		
		/* Step 3: Get the exchange rate, for the given country*/
		BigDecimal exchangeRate = countryDAO.getConversionValue(countryCode);
		
		if(logger.isDebugEnabled()) {
			logger.debug("Step 3-Result: Exchange Rate: " + exchangeRate);
		}
		
		/* Step 4: Calculate new price, exchangeRate * given proposed priceChange*/
		
		BigDecimal newPrice = exchangeRate.multiply(priceChange);
		
		if(logger.isDebugEnabled()) {
			logger.debug("Step 4-Result: New Price Change: " + newPrice);
		}
		
		/* Step 5: Insert new price, with country code and service_id*/
		int countryServiceId = countryDAO.insertNewPriceForService(countryCode, servicePlan.getServiceId(), newPrice);
		response.setCountryServiceId(countryServiceId);
		response.setServiceId(serviceId);
		response.setCountryCode(countryCode);
		response.setUpdatedPrice(newPrice);

        
		if(logger.isDebugEnabled()) {
			logger.debug("Exiting UpdatePricingBasedOncountryServiceImpl - updateServicePricing()  class." );
		}
		
		
		return response;
		
	}

}
