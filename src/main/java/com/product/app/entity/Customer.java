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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobileNo;
	private String passportNo;
	private String address;
	private Integer pinCode;
	private String passportDocument;
	
}
