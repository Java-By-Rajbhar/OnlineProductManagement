package com.product.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsResponseDTO {
	
	private int productId;
	private String productDescription;
	private double charges;

}
