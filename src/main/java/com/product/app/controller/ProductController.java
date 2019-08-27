package com.product.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.dto.PurchesDetailsDto;
import com.product.app.service.PurchaseService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ProductController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProductController.class); 
	@Autowired
	private PurchaseService purchaseService;
	
	  @PostMapping("/product") 
	  public ResponseEntity<String> purchaseProduct(@RequestBody PurchesDetailsDto purchesDetailsDto){
	  
		  LOGGER.info("ProductController :: purchaseProduct() -- "+purchesDetailsDto);
		  return new ResponseEntity<String>(purchaseService.purchaseProduct(purchesDetailsDto), HttpStatus.OK);
	  }

}
