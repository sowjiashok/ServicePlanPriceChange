package com.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dao.CountryDAO;

@Repository(value = "CountryDAOImpl")
public class CountryDAOImpl implements CountryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

	private static final String GET_COUNTRY_CODE_QUERY = "SELECT country_code FROM country WHERE country_name = ?";
	private static final String GET_CONVERSION_VALUE_QUERY = "SELECT conversion_value from currency_code WHERE currency_code = ?";
	private static final String INSERT_NEW_PRICE_QUERY = "INSERT INTO country_service_pricing (country_code, service_id, service_price) VALUES (?, ?, ?);  ";
	private static final String GET_MAX_COUNTRY_SERVICE_ID_QUERY = "SELECT max(country_service_id) FROM country_service_pricing;";



	@Autowired
	JdbcTemplate jdbcTemplate;

	public String getCountryCodeByDescription(String countryName) {
		if (logger.isDebugEnabled()) {
			logger.debug("Entered getCountryCodeByeDecsription()..");

		}
		String countryCode = (String) jdbcTemplate.queryForObject(GET_COUNTRY_CODE_QUERY, new Object[] { countryName },
				String.class);

		if (logger.isDebugEnabled()) {
			logger.debug("Country Code: " + countryCode);
			logger.debug("Exited getCountryCodeByeDecsription()..");
		}
		return countryCode;

	}

	public BigDecimal getConversionValue(String currencyCode) {
		if(logger.isDebugEnabled()) {
		logger.debug("Entered getConversionValue()..");
		}
		BigDecimal conversionValue = (BigDecimal) jdbcTemplate.queryForObject(GET_CONVERSION_VALUE_QUERY, new Object[] { currencyCode },
				BigDecimal.class);

		if(logger.isDebugEnabled()) {
		logger.debug("Conversion Value: " + conversionValue);
		logger.debug("Exited getConversionValue()..");
		}
		return conversionValue;
	
	}
	/* 1. Inserts new price along with service_id and currency_code into country_service_pricing table
	 * 2. Gets the latest country_service_id */
	public int insertNewPriceForService(String currencyCode, int serviceId, BigDecimal newPrice) {
		if(logger.isDebugEnabled()) {
			logger.debug("Entered insertNewPriceForService()..");
			}
		
		Object[] obj =  new Object[] {currencyCode, serviceId, newPrice};

		int result = jdbcTemplate.update(INSERT_NEW_PRICE_QUERY, obj);
		
		if(logger.isDebugEnabled()) {
			logger.debug("Insert result: " + result);
		}
		int maxId = jdbcTemplate.queryForObject(GET_MAX_COUNTRY_SERVICE_ID_QUERY, Integer.class);
		if(logger.isDebugEnabled()) {
			logger.debug("Exited insertNewPriceForService()..");
			}
		return maxId;
	}


}
