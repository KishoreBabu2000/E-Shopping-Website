package org.shopping.dao;

import java.util.List;

import org.shopping.entity.Product;
import org.shopping.repositary.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository productRepositary;
	@Override
	public List<Product> getAllProductlist() {
		
		return productRepositary.findAll();
		
	}
	@Override
	public Product getproductdetailsbyid(int id) {
		
		return productRepositary.findById(id).get();
	}
	@Override
	public List<Product> findAllProductDetailsByNameOrCategoryOrBrandOrPrice(String data) {
		
		return productRepositary.findByProductbrandOrProductcategoryOrProductnameOrProductprice(data);
	}
//	@Override
//	public List<Product> findByPrice(double price) {
//		
//		return productRepositary.findByPrice(price);
//	}sss
	
}
