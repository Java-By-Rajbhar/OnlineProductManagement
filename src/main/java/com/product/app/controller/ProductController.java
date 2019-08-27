package com.product.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.dto.ProductCategoryResponse;
import com.product.app.service.ProductCategoryService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ProductController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductCategoryService productCategoryService;
	
	
	/**
	 * This service is use get all product category
	 * @return List<ProductCategoryResponse>
	 */
	@GetMapping("/category")
	public ResponseEntity<List<ProductCategoryResponse>> getProductCategories()
	{
		LOGGER.info("Inside getProductCategories method of ProductController class");
	    List<ProductCategoryResponse> response  =	productCategoryService.getAllProductCategory();
	    return new ResponseEntity<List<ProductCategoryResponse>>(response, HttpStatus.OK);
	}

}
