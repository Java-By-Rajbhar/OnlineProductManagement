package com.product.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Laxman
 *
 */
@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productPurchaseId;
	private Integer productId;
	private Integer customerId;
	private String purchaseDate;
//	private String remarks;
	
}
