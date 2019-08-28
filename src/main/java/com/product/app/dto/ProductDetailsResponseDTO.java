package com.product.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductDetailsResponseDTO {
	
	private int productId;
	private String productDescription;
	private double charges;

}
