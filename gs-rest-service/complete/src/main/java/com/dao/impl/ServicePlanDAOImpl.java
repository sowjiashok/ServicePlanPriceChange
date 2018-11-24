package com.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.ServicePlanDAO;
import com.mapper.ServiceRowMapper;
import com.model.ServicePlan;
import com.service.impl.UpdatePricingBasedOncountryServiceImpl;

@Repository(value="ServicePlanDAOImpl")
public class ServicePlanDAOImpl implements ServicePlanDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ServicePlanDAOImpl.class);
	
	private static final String GET_SERVICE_PLAN_QUERY = "select * from service_plan where service_desc = ?";
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ServicePlan getServiceIdByServiceDecsription(String serviceDescription) {
		logger.info("Entered getServiceIdByServiceDecsription..");
		@SuppressWarnings("unchecked")
		ServicePlan serviceplan = (ServicePlan) jdbcTemplate.queryForObject(GET_SERVICE_PLAN_QUERY,  
				new Object [] {serviceDescription}, new ServiceRowMapper());
		
		logger.info("ServicePlan: " + serviceplan.getServiceId());

		
		logger.info("Exited getServiceIdByServiceDecsription..");

		
		return serviceplan;
				
	}
	

}
