package com.product.app.dto;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
public class ProductAnalysisResponseDto {
	
	private List<Integer> productCount;
	private List<String> productName;

}
