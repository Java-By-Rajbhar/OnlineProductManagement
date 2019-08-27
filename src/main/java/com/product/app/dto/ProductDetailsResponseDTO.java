package com.product.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailsResponseDTO {
	
	private int productId;
	private String productDescription;
	private double charges;

}
