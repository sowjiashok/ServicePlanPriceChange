package com.model;

import java.util.Objects;

public class Customer {

	/* Represents the customer ID for the Customer */
	private int customerId;
	/* Represents the country code for the Customer */
	private String countryCode;
	/* Each Customer has a membership, this represents the details on the membership - 
	 * aggregation relation - 'has-a'  */
	private CustomerMembershipDetail custMemDetail;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public CustomerMembershipDetail getCustMemDetail() {
		return custMemDetail;
	}
	public void setCustMemDetail(CustomerMembershipDetail custMemDetail) {
		this.custMemDetail = custMemDetail;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer user = (Customer) o;
        return customerId == user.customerId &&
                Objects.equals(countryCode, user.countryCode) &&
                Objects.equals(custMemDetail, user.getCustMemDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, countryCode, custMemDetail);
    }
    
	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Customer Id: ").append(customerId).append("Country Code: ").append(countryCode);
    	return sb.toString();
    }
}
