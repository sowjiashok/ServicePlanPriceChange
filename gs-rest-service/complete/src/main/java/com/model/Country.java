package com.model;

public class Country {
	/* Represents the 2-digit ISO standard country code */
	private String countryCode;
	/* Represents the country description */
	private String countryName;
	/* Each Country has a separate pricing for the Netflix Service Subscription.
	 * aggregation relation - Each Country 'has-a' CountryServicePricing based on the kind of service. */
    private CountryServicePricing countryServicePricing;
	
    public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public CountryServicePricing getCountryServicePricing() {
		return countryServicePricing;
	}
	public void setCountryServicePricing(CountryServicePricing countryServicePricing) {
		this.countryServicePricing = countryServicePricing;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((countryServicePricing == null) ? 0 : countryServicePricing.hashCode());
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
		Country other = (Country) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (countryServicePricing == null) {
			if (other.countryServicePricing != null)
				return false;
		} else if (!countryServicePricing.equals(other.countryServicePricing))
			return false;
		return true;
	}
	

}
