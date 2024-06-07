package org.shopping.dao;

import org.shopping.entity.Customer;

public interface CustomerDao {
	Customer customerRegistration(Customer customer);
	Customer customerLogin(String emailid,String password);
}
