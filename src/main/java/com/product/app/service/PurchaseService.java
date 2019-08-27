package com.product.app.service;

import com.product.app.dto.ProductAnalysisResponseDto;
import com.product.app.dto.PurchesDetailsDto;

public interface PurchaseService {

	String purchaseProduct(PurchesDetailsDto purchesDetailsDto);
	
	public ProductAnalysisResponseDto analysis(String daily);

}
