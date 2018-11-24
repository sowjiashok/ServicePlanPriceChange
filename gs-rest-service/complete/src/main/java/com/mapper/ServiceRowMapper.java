package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.ServicePlan;

public class ServiceRowMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServicePlan plan = new ServicePlan();
		plan.setServiceId(rs.getInt("service_id"));
		plan.setServideDesc(rs.getString("service_desc"));
		return plan;
	}

}
