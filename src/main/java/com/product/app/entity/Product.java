package com.product.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	private int categoryId;
	private String productName;
	private String productDescription;
	private double charges;
}
