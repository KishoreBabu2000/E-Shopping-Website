package org.shopping.dao;

import java.util.List;

import org.shopping.entity.Purchase;
import org.shopping.repositary.PurchaseRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDaoImpl implements PurchaseDao
{
	@Autowired
	PurchaseRepositary purchaseRepositary;
	@Override
	public Purchase savePurchase(Purchase purchase) {
		
		return purchaseRepositary.save(purchase);
	}
	@Override
	public List<Purchase> getAllPurchaseList(int customerid) {
		
		return purchaseRepositary.findByCustomerid(customerid);
	}

}
