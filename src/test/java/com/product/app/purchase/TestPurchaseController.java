package com.product.app.purchase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.app.controller.ProductController;
import com.product.app.dto.PurchesDetailsDto;
import com.product.app.service.PurchasePrudectServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestPurchaseController {

	private MockMvc mockMvc;
	
	@InjectMocks
	private ProductController productController;
	
	@Mock
	private PurchasePrudectServiceImpl purchasePrudectServiceImpl;
	
	PurchesDetailsDto purchesDetailsDto ;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		purchesDetailsDto = new PurchesDetailsDto(101, 10, "Laxman", "Verma", "laxman@hcl.com", 90235678L, "AKS9092K", "HCL EC", 5600095, "hello");
	}
	
	@Test
	public void testPurchaseProduct() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/product").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(purchesDetailsDto))).andExpect(status().isCreated());
	}
	
	
	
}
