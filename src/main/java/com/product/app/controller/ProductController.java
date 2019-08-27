package com.product.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.dto.ProductCategoryResponse;
import com.product.app.dto.ProductDetailsResponseDTO;
import com.product.app.dto.ProductResponseDto;
import com.product.app.service.ProductCategoryService;
import com.product.app.service.ProductService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ProductController {

	@Autowired
	ProductCategoryService productCategoryService;

	@Autowired
	ProductService productService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/category")
	public ResponseEntity<List<ProductCategoryResponse>> getProductCategories() {
		LOGGER.info("Inside getProductCategories method of ProductController class");
		List<ProductCategoryResponse> response = productCategoryService.getAllProductCategory();
		return new ResponseEntity<List<ProductCategoryResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<ProductResponseDto>> getAllProducts(@PathVariable int categoryId) {
		LOGGER.info(" in Products List");
		List<ProductResponseDto> productsList = productService.getAllProducts(categoryId);
		return new ResponseEntity<>(productsList, HttpStatus.OK);

	}

	@GetMapping("/prodcuts/{productId}")
	public ResponseEntity<ProductDetailsResponseDTO> getProductDetails(@PathVariable int productId) {
		LOGGER.info(" in Products List");
		ProductDetailsResponseDTO productDetails = productService.getProductDetails(productId);
		return new ResponseEntity<>(productDetails, HttpStatus.OK);

	}
}
