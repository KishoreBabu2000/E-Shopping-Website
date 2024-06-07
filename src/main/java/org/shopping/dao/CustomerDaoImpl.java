package org.shopping.dao;

import org.shopping.entity.Customer;
import org.shopping.repositary.CustomerRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements CustomerDao
{
	@Autowired
	CustomerRepositary customerRepositary;
	@Override
	public Customer customerRegistration(Customer customer) {
		return customerRepositary.save(customer);	
	}
	@Override
	public Customer customerLogin(String emailid, String password) {
		return customerRepositary.findByCustomeremailidAndCustomerpassword(emailid, password);
	}

}
