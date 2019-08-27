package com.product.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.app.dto.PurchesDetailsDto;
import com.product.app.dto.UploadFileResponseDto;
import com.product.app.entity.Customer;
import com.product.app.entity.ProductPurchase;
import com.product.app.repository.CustomerRepository;
import com.product.app.repository.ProductRepository;
import com.product.app.repository.PurchaseRepository;

/**
 * @author Laxman
 *
 */
@Service
public class PurchasePrudectServiceImpl implements PurchaseService {

	private final static Logger LOGGER = LoggerFactory.getLogger(PurchasePrudectServiceImpl.class);

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public UploadFileResponseDto purchaseProduct(PurchesDetailsDto purchesDetailsDto) {
	
		LOGGER.info(" PurchasePrudectServiceImpl :: purchaseProduct ");
		Customer customer = new Customer();
		UploadFileResponseDto response = new UploadFileResponseDto();
		
		BeanUtils.copyProperties(purchesDetailsDto, customer);
		
		customer= customerRepository.save(customer);
		
		ProductPurchase productPurchase = new ProductPurchase();
		productPurchase.setCustomerId(customer.getCustomerId());
		productPurchase.setProductId(purchesDetailsDto.getProductId());
		
		LocalDateTime rightNow = LocalDateTime.now();
		String pattern = "dd-MMM-yyyy HH:mm:ss";
		String patternDate = rightNow.format(DateTimeFormatter.ofPattern(pattern));
		
		productPurchase.setPurchaseDate(patternDate);
		
		purchaseRepository.save(productPurchase);
		
		response.setMessage("Purchased successfully.");
		response.setStatusCode(201);
		
		return response;
	}

}
