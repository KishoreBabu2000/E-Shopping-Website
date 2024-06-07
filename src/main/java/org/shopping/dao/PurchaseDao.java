package org.shopping.dao;

import java.util.List;

import org.shopping.entity.Purchase;

public interface PurchaseDao {
	Purchase savePurchase(Purchase purchase);
	List<Purchase> getAllPurchaseList(int customerid);
}
