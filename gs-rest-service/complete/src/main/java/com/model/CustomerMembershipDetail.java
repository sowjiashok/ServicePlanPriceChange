package com.model;

import java.util.Objects;

/* CustomerMembershipDetail has customer membership ID, customer ID and service ID as properties  */
public class CustomerMembershipDetail {

	private int customerMemId;

	private int customerId;

	private int serviceId;

	public int getCustomerMemId() {
		return customerMemId;
	}

	public void setCustomerMemId(int customerMemId) {
		this.customerMemId = customerMemId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof CustomerMembershipDetail)) {
			return false;
		}
		CustomerMembershipDetail user = (CustomerMembershipDetail) o;
		return customerMemId == user.customerMemId && customerId == user.customerId && serviceId == user.serviceId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerMemId, customerId, serviceId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Customer Id: ").append(customerId).append("Customer Member Id: ").append(customerMemId)
				.append("Service ID: ").append(serviceId);
		return sb.toString();
	}

}
