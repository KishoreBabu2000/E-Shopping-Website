package org.shopping.repositary;

import java.util.List;

import org.shopping.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepositary extends JpaRepository<Purchase, Integer> 
{
	List<Purchase> findByCustomerid(int customerid);
}
