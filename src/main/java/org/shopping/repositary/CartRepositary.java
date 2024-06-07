package org.shopping.repositary;

import org.shopping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface CartRepositary extends JpaRepository<Cart, Integer> {
	Cart findByCustomeridAndProductname(int customerid, String productname);
	List<Cart> findByCustomerid(int customerid);
}
