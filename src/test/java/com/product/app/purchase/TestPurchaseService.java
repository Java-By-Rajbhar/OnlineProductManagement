package com.product.app.purchase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.product.app.dto.PurchesDetailsDto;
import com.product.app.dto.UploadFileResponseDto;
import com.product.app.entity.Customer;
import com.product.app.entity.ProductPurchase;
import com.product.app.repository.CustomerRepository;
import com.product.app.repository.PurchaseRepository;
import com.product.app.service.PurchasePrudectServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestPurchaseService {
	
	@Mock
	private PurchaseRepository purchaseRepository;

	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private PurchasePrudectServiceImpl purchasePrudectServiceImpl;
	
	@Mock
	private Customer customer;
	
	@Mock
	private ProductPurchase productPurchase;
	PurchesDetailsDto purchesDetailsDto ;
	Customer customerEntity;
	UploadFileResponseDto response;
	@Before
	public void setup() {
		purchesDetailsDto = new PurchesDetailsDto(101, 10, "Laxman", "Verma", "laxman@hcl.com", 90235678L, "AKS9092K", "HCL EC", 5600095, "hello");
		customerEntity = new Customer(101, "Abhi", "Srivastav", "abh@hcl.com", 9093333L, "AJS9099L", "HCL ", 748733, "hello");
		response = new UploadFileResponseDto();
		response.setMessage("Purchased successfully.");
		response.setStatusCode(201);
	}
	
	@Test
	public void testPurchaseProduct() {
		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(customerEntity);
		Mockito.when(purchaseRepository.save(Mockito.anyObject())).thenReturn(productPurchase);
		UploadFileResponseDto actualResult = purchasePrudectServiceImpl.purchaseProduct(purchesDetailsDto);
		assertEquals("Purchased successfully.", actualResult.getMessage());
	}
}
