package com.model;

import java.math.BigDecimal;

public class PriceUpdateBasedOnCountryReportAsResponse {
	
	private int countryServiceId;
	
	private String countryCode;
	
	private int serviceId;
	
	private BigDecimal updatedPrice;

	/**
	 * @return the countryServiceId
	 */
	public int getCountryServiceId() {
		return countryServiceId;
	}

	/**
	 * @param countryServiceId the countryServiceId to set
	 */
	public void setCountryServiceId(int countryServiceId) {
		this.countryServiceId = countryServiceId;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the serviceId
	 */
	public int getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the updatedPrice
	 */
	public BigDecimal getUpdatedPrice() {
		return updatedPrice;
	}

	/**
	 * @param updatedPrice the updatedPrice to set
	 */
	public void setUpdatedPrice(BigDecimal updatedPrice) {
		this.updatedPrice = updatedPrice;
	}
	
	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("PriceUpdateBasedOnCountryReportAsResponse: countryServiceId: ").append(countryServiceId).append(", countryCode: ").append(countryCode)
    	.append(", serviceId: ").append(serviceId).append(", updatedPrice: ").append(updatedPrice);
    	return sb.toString();
    }


}
