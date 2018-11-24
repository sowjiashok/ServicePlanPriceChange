package com.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CurrencyCode {
	
	/* The following fields are defined transient, as these are not to be serialized as 
	 * the codes are represented in the database, based on the ISO-3166 standard. */
	/* Represents the 2-digit currency code alpha example 'IN' */
	private transient String currencyCode;
	/* Represents the conversion rate example US $1 is represented as 70.52 */
	private transient BigDecimal conversionValue;
	
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        CurrencyCode currency = (CurrencyCode) o;
        return Objects.equals(currencyCode, currency.getCurrencyCode()) &&
                Objects.equals(conversionValue, currency.getConversionValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, conversionValue);
    }

	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Currency Code: ").append(currencyCode)
    	.append("Conversion Value: ").append(conversionValue);
    	return sb.toString();
    }

}
