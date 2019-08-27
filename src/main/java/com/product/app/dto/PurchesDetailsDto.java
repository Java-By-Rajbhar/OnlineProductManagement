package com.product.app.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Laxman
 *
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PurchesDetailsDto {

	private Integer productId;
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobileNo;
	@Pattern(regexp = "^[A-Z][0-9]{8}$")
	private String passportNo;
	private String address;
	
	@Size(max = 6, min = 6, message = "PinCode length should be 6-digit only.")
	private Integer pinCode;
	private String passportDocument;
}
