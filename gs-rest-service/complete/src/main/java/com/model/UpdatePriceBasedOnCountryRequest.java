package com.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePriceBasedOnCountryRequest {
	
	@Size(min=2, max=2)
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	@JsonProperty("serviceDescription")
	private String serviceDescription;
	
    @Digits(integer=5, fraction=2)
	@JsonProperty("priceChangeAmt")
	private BigDecimal priceChangeAmt;
    
	@Pattern(regexp = "^[a-zA-Z]*$")
	@JsonProperty("customerCountry")
	private String customerCountry;

	/**
	 * @return the serviceDescription
	 */
	public String getServiceDescription() {
		return serviceDescription;
	}

	/**
	 * @param serviceDescription the serviceDescription to set
	 */
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	/**
	 * @return the updatePriceTo
	 */
	public BigDecimal getPriceChangeAmt() {
		return priceChangeAmt;
	}

	/**
	 * @param updatePriceTo the updatePriceTo to set
	 */
	public void setPriceChangeAmtTo(BigDecimal priceChangeAmt) {
		this.priceChangeAmt = priceChangeAmt;
	}

	/**
	 * @return the customerCountrty
	 */
	public String getCustomerCountry() {
		return customerCountry;
	}

	/**
	 * @param customerCountrty the customerCountrty to set
	 */
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	
	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("UpdatePriceBasedOnCountryRequest: serviceDescription: ").append(serviceDescription).append(", Update Price To: ").append(priceChangeAmt)
    	.append(", customer country: ").append(customerCountry);
    	return sb.toString();
    }

}
