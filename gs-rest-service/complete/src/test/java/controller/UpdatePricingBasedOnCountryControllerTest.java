package controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.model.PriceUpdateBasedOnCountryReportAsResponse;
import com.model.UpdatePriceBasedOnCountryRequest;
import com.service.UpdatePricingBasedOnCountryService;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UpdatePricingBasedOnCountryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UpdatePricingBasedOnCountryService updatePricingBasedOnCountryService;
	
	@Test
	public void updatePriceBasedOnCountry_success_test() throws Exception {
		String requestJSON = "{\"serviceDescription\":\"2S\",\"priceChangeAmt\":\"13.00\",\"customerCountry\":\"Canada\"}";
		
		PriceUpdateBasedOnCountryReportAsResponse response = new PriceUpdateBasedOnCountryReportAsResponse();
		response.setCountryServiceId(13);
		response.setServiceId(2);
		response.setCountryCode("CA");
		
		UpdatePriceBasedOnCountryRequest request = new UpdatePriceBasedOnCountryRequest();
		request.setPriceChangeAmtTo(new BigDecimal(11.00));
		when(updatePricingBasedOnCountryService.updateServicePricing(request)).thenReturn(response);

        this.mockMvc.perform(post("/v1/subscription-pricing").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}

	@Test(expected = Exception.class)
	public void updatePriceBasedOnCountry_failureonServiceDesc_test() throws Exception {
		String requestJSON = "{\"serviceDescription\":\"2SS\",\"priceChangeAmt\":\"13.00\",\"customerCountry\":\"Canada\"}";
		
		UpdatePriceBasedOnCountryRequest request = new UpdatePriceBasedOnCountryRequest();
		request.setPriceChangeAmtTo(new BigDecimal(11.00));
		doNothing().when(updatePricingBasedOnCountryService.updateServicePricing(request));

        this.mockMvc.perform(post("/v1/subscription-pricing").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(status().isInternalServerError());
	}
	
	@Test(expected = Exception.class)
	public void updatePriceBasedOnCountry_failureonCountry_test() throws Exception {
		String requestJSON = "{\"serviceDescription\":\"2SS\",\"priceChangeAmt\":\"13.00\",\"customerCountry\":\"Canada!__-$\"}";
		
		UpdatePriceBasedOnCountryRequest request = new UpdatePriceBasedOnCountryRequest();
		request.setPriceChangeAmtTo(new BigDecimal(11.00));
		doNothing().when(updatePricingBasedOnCountryService.updateServicePricing(request));

        this.mockMvc.perform(post("/v1/subscription-pricing").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(status().isInternalServerError());
	}

}
