package com.product.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAnalysisResponseDto {
	
	private List<Integer> productCount;
	private List<String> productName;

}
