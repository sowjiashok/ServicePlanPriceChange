package com.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePriceBasedOnCountryRequest {
	
	@JsonProperty("serviceDescription")
	private String serviceDescription;

	@JsonProperty("priceChangeAmt")
	private BigDecimal priceChangeAmt;
	
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
