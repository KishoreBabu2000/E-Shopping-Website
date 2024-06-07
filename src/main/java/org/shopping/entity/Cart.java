package org.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cart
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartid;
	private int customerid;
	private String productname;
	private double productprice;
}
