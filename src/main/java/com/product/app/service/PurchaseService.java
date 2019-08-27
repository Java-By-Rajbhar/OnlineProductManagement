package com.product.app.service;

import com.product.app.dto.PurchesDetailsDto;
import com.product.app.dto.UploadFileResponseDto;

public interface PurchaseService {

	UploadFileResponseDto purchaseProduct(PurchesDetailsDto purchesDetailsDto);

}
