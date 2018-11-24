package com.model;

import java.math.BigDecimal;

public class CountryServicePricing {
	
	private int countryServiceId;
	/* */
	private String countryCode;
	
	private int  serviceId;
	/* Represents the price for membership, based on service type (1S,2S,4S). 
	 * Also, this includes the conversion rate. example if 1S in US costs 8.00 dollars then for IN the cost is 560.00 */
	private BigDecimal servicePrice;

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
	 * @return the servicePrice
	 */
	public BigDecimal getServicePrice() {
		return servicePrice;
	}

	/**
	 * @param servicePrice the servicePrice to set
	 */
	public void setServicePrice(BigDecimal servicePrice) {
		this.servicePrice = servicePrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + countryServiceId;
		result = prime * result + serviceId;
		result = prime * result + ((servicePrice == null) ? 0 : servicePrice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryServicePricing other = (CountryServicePricing) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryServiceId != other.countryServiceId)
			return false;
		if (serviceId != other.serviceId)
			return false;
		if (servicePrice == null) {
			if (other.servicePrice != null)
				return false;
		} else if (!servicePrice.equals(other.servicePrice))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("CountryServicePricing [countryServiceId=").append(countryServiceId).append(", countryCode=").append(countryCode).append(", serviceId=")
		.append(serviceId).append(serviceId).append(", servicePrice=").append(servicePrice).append("]");

		return sb.toString();
	}

}
