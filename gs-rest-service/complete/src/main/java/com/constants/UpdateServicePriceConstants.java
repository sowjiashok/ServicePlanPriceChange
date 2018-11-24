package com.constants;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UpdateServicePriceConstants {
	
	public static Set<String> serviceSet = new HashSet<>();
	public static final String BASE_URI =  "/v1";
	public static final int SERVICE_DESC_MIN_LEN = 2;
	public static final String SERVICE_DESC_JSON_INPUT = "serviceDescription";
	
	static {
		serviceSet.add("1S");
		serviceSet.add("2S");
		serviceSet.add("4S");
		Collections.unmodifiableSet(serviceSet);
	}
	
	

}
