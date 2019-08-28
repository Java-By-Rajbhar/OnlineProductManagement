package com.product.app.dto;

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
@NoArgsConstructor
public class ProductCategoryResponse {
	
	private int categoryId;
	private String categoryName;

}
