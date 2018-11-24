package com.dao;

import java.math.BigDecimal;

public interface CountryDAO {
	
	public String getCountryCodeByDescription(String countryName);
	
	public BigDecimal getConversionValue(String currencyCode);
	
	public int insertNewPriceForService(String currencyCode, int serviceId, BigDecimal newPrice);


}
