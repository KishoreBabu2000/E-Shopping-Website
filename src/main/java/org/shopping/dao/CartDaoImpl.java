package org.shopping.dao;

import java.util.List;

import org.shopping.entity.Cart;
import org.shopping.repositary.CartRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDaoImpl implements CartDao{

	@Autowired
	CartRepositary cartRepositary;
	@Override
	public Cart addtocart(Cart cart) {
		return cartRepositary.save(cart);
	}
	@Override
	public Cart findByCustomeridAndProductname(int customerid, String productname) {
		return cartRepositary.findByCustomeridAndProductname(customerid, productname);
	}
	@Override
	public List<Cart> findByCustomerid(int customerid) {
		
		 List<Cart> cartlist = cartRepositary.findByCustomerid(customerid);
		 return cartlist;
	}
	@Override
	public void removeproductbycartid(int cartid) {
		cartRepositary.deleteById(cartid);		
	}
	@Override
	public Cart findByCartId(int cartid) {
		
		return cartRepositary.findById(cartid).get();
	}

}
