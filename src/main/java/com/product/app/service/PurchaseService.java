package com.product.app.service;

import com.product.app.dto.ProductAnalysisResponseDto;
import com.product.app.dto.PurchesDetailsDto;
import com.product.app.dto.UploadFileResponseDto;

public interface PurchaseService {
	
	public ProductAnalysisResponseDto analysis(String daily);
	
	UploadFileResponseDto purchaseProduct(PurchesDetailsDto purchesDetailsDto);

}
