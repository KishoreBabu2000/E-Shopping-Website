package org.shopping.repositary;

import org.shopping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositary extends JpaRepository<Customer, Integer>{
	
	Customer findByCustomeremailidAndCustomerpassword(String customeremailid,String customerpassword);
}
