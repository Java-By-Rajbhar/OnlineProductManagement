package com.product.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
@Entity
@Table
public class Product {

	private int productId;
	private String productName;
	private String description;
	private double price;
}
