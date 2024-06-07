package org.shopping.controller;

import org.shopping.dao.CustomerDao;
import org.shopping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class CustomerController 
{
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/customerregistration")
	public String customerRegistration(Model model,HttpServletRequest request,String customername,String customeremailid, String customerpassword,String customerrepassword,String customermobilenumber,String customeraddress,String customergender) {
		if(customerpassword.equals(customerrepassword))
		{
		Customer customer = new Customer();
		customer.setCustomername(customername);
		customer.setCustomeremailid(customeremailid);
		customer.setCustomerpassword(customerpassword);
		customer.setCustomeraddress(customeraddress);
		customer.setCustomergender(customergender);
		customer.setCustomermobilenumber(customermobilenumber);
		Customer customerInfo = customerDao.customerRegistration(customer);
		if(customerInfo!=null)
		{
			model.addAttribute("msg", "Registration Successfull...");
			return "LoginPage";
		}
		else
		{
			model.addAttribute("msg", "Registration Unsuccessfull...");
			return "Customer";
		}
		}
		else
		{
			model.addAttribute("msg", "Password MisMatch");
			return "Customer";
		}		
	}	
	
	@RequestMapping("/customerlogin")
	public String customerLogin(Model model,HttpServletRequest request,String customeremailid,String customerpassword)
	{
		HttpSession session = request.getSession();
		Customer customer = customerDao.customerLogin(customeremailid, customerpassword);
		if(customer!=null)
		{
			session.setAttribute("customername", customer.getCustomername());
			session.setAttribute("customeremailid", customer.getCustomeremailid());
			session.setAttribute("customermobilenumber", customer.getCustomermobilenumber());
			session.setAttribute("customeraddress", customer.getCustomeraddress());
			session.setAttribute("customergender", customer.getCustomergender());
			session.setAttribute("customerid", customer.getCustomerid());
			model.addAttribute("customername", customer.getCustomername());
			model.addAttribute("customeremailid", customer.getCustomeremailid());
			model.addAttribute("customermobilenumber", customer.getCustomermobilenumber());
			model.addAttribute("customeraddress", customer.getCustomeraddress());
			model.addAttribute("customergender", customer.getCustomergender());
			model.addAttribute("customerid", customer.getCustomerid());
			model.addAttribute("msg", "Login Successfull");
			return "CustomerOptions";
		}
		else
		{
			model.addAttribute("msg", "Login UnSuccessfull");
			return "Customer";
		}
	}
}





















