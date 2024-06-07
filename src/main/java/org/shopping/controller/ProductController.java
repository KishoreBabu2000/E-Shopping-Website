package org.shopping.controller;

import java.util.List;

import org.shopping.dao.ProductDao;
import org.shopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	@RequestMapping("/productlist")
	public String productlist(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("customername",(String)session.getAttribute("customername"));
		List<Product> productlist= productDao.getAllProductlist();
		session.setAttribute("productlist", productlist);
		model.addAttribute("productlist", productlist);
		return "ProductList";
	}
	
	@RequestMapping("/filterproduct")
	public String filterproduct(Model model,HttpServletRequest request, String data)
	{
		List<Product> productlist = productDao.findAllProductDetailsByNameOrCategoryOrBrandOrPrice(data);
		HttpSession session = request.getSession();
		if(productlist!=null)
		{
		model.addAttribute("customername",(String)session.getAttribute("customername"));
		model.addAttribute("productlist", productlist);
		}
		else
		{
			productlist=(List<Product>) session.getAttribute("productlist");
			model.addAttribute("customername",(String)session.getAttribute("customername"));
			model.addAttribute("productlist", productlist);
		}
		return "ProductList";
	}
	
	
}
