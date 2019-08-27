package com.product.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.app.dto.ProductAnalysisResponseDto;
import com.product.app.dto.PurchesDetailsDto;
import com.product.app.entity.Customer;
import com.product.app.entity.Product;
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
	ProductRepository productRepository;

	@Override
	public String purchaseProduct(PurchesDetailsDto purchesDetailsDto) {
	
		LOGGER.info(" PurchasePrudectServiceImpl :: purchaseProduct ");
		Customer customer = new Customer();
		
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
		
		return "Purchased successfully.";
	}

	@Override
	public ProductAnalysisResponseDto analysis(String dailyDate) {
		LOGGER.info("Inside analysis method of PurchasePrudectServiceImpl class");
		List<Integer[]> response = purchaseRepository.getPruductNameAndCount(dailyDate);
		List<String>  productName = new ArrayList<>();
		List<Integer>  productCount = new ArrayList<>();
		LOGGER.info("count data ={}",response.size());
		
		response.forEach(data->{
			int id =  data[0];
			int count  = (int) data[1];
			Product product = productRepository.findAllByProductId(id);
			LOGGER.info("product name ={}",product.getProductName());
			productName.add(product.getProductName());
			productCount.add(count);
		});
		LOGGER.info("product list={}",productName);
		LOGGER.info("product count={}",productCount);
		ProductAnalysisResponseDto dto =  new  ProductAnalysisResponseDto();
		dto.setProductCount(productCount);
		dto.setProductName(productName);
		return dto;
	}

}
