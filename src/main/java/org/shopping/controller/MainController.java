package org.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MainController {
	@RequestMapping("/e-shoppingwebsite")
	public String indexpage()
	{
		return "Index";
	}
	
	@RequestMapping("/customerpage")
	public String customerPage()
	{
		return "Customer";
	}
	
	@RequestMapping("/customeroptions")
	public String customeroption(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession(); 
		String customername =(String) session.getAttribute("customername");
	    String customeremailid =(String) session.getAttribute("customeremailid");
	    String customermobilenumber =(String) session.getAttribute("customermobilenumber");
	    String customeraddress =(String) session.getAttribute("customeraddress");
	    String customergender =(String) session.getAttribute("customergender");
	    Integer customerid =(Integer) session.getAttribute("customerid");
	    model.addAttribute("customername", customername);
		model.addAttribute("customeremailid", customeremailid);
		model.addAttribute("customermobilenumber",customermobilenumber);
		model.addAttribute("customeraddress", customeraddress);
		model.addAttribute("customergender", customergender);
		model.addAttribute("customerid", customerid);
		
		return "CustomerOptions";
	}
	
	
	
}
