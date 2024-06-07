package org.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer customerid;
	@Column(nullable = false)
	private String customername;
	@Column(nullable = false,unique = true)
	private String customeremailid;
	@Column(nullable = false,unique = true)
	private String customerpassword;
	@Column(nullable = false,unique = true)
	private String customermobilenumber;
	@Column(nullable = false)
	private String customeraddress;
	@Column(nullable = false)
	private String customergender;
}
