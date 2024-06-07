package org.shopping.dao;

import java.util.List;

import org.shopping.entity.Cart;

public interface CartDao {
	
	Cart addtocart(Cart cart);
	Cart findByCustomeridAndProductname(int customerid,String productname);
	List<Cart> findByCustomerid(int customerid);
	void removeproductbycartid(int cartid);
	Cart findByCartId(int cartid);
}
