package com.dao;

import org.springframework.stereotype.Component;

import com.model.ServicePlan;
@Component("ServicePlanDAO")
public interface ServicePlanDAO {
	
	public ServicePlan getServiceIdByServiceDecsription(String serviceDescription);


}
