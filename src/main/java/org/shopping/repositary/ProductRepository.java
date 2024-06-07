package org.shopping.repositary;

import org.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query(value =  "select product from Product product where product.productbrand=?1 or product.productcategory=?1 or product.productname=?1 or product.productprice<=?1")
	List<Product> findByProductbrandOrProductcategoryOrProductnameOrProductprice(String data);
}
