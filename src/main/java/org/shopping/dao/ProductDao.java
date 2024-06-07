package org.shopping.dao;

import java.util.List;

import org.shopping.entity.Product;

public interface ProductDao {
	List<Product> getAllProductlist();
	Product getproductdetailsbyid(int id);
	List<Product> findAllProductDetailsByNameOrCategoryOrBrandOrPrice(String data);
//	List<Product> findByPrice(double price);
}
