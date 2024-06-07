package org.shopping.controller;

import java.util.List;

import org.shopping.dao.CartDao;
import org.shopping.dao.ProductDao;
import org.shopping.entity.Cart;
import org.shopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/addtocart")
	public String addtocart(Model model,HttpServletRequest request,int productid)
	{
		 Product product = productDao.getproductdetailsbyid(productid);
		 HttpSession session = request.getSession();
		 int customerid = (int)session.getAttribute("customerid");
		 List<Product> productlist = (List<Product>) session.getAttribute("productlist");
		 String customername=(String)session.getAttribute("customername");
		 
		 if(product!=null)
		 {
			 Cart cart= cartDao.findByCustomeridAndProductname(customerid, product.getProductname());
			 if(cart!=null)
			 {
				 model.addAttribute("msg",product.getProductname()+" Is Already Added To Cart");
				 model.addAttribute("customername", customername);
				 model.addAttribute("productlist", productlist);
			 }
			 else
			 {	
			 	cart = new Cart();
				 cart.setCustomerid((Integer)session.getAttribute("customerid"));
				 cart.setProductname(product.getProductname());
				 cart.setProductprice(product.getProductprice());
				 Cart addedCart=cartDao.addtocart(cart);
				 if(addedCart!=null)
				 {
					 model.addAttribute("msg",product.getProductname()+" Is Added To Cart");
					 model.addAttribute("customername", customername);
					 model.addAttribute("productlist", productlist);
				 }
				 else
				 {
					 model.addAttribute("msg",product.getProductname()+" Is Not Added To Cart");
					 model.addAttribute("customername", customername);
					 model.addAttribute("productlist", productlist);
				 }
			 }
		 }
		return "ProductList";
	}
	
	@RequestMapping("/cartlist")
	public String cartlist(Model model,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		int customerid=(int)session.getAttribute("customerid");
		List<Cart> cartlist = cartDao.findByCustomerid(customerid);
		if(cartlist!=null)
		{
			session.setAttribute("cartlist", cartlist);
			model.addAttribute("cartlist", cartlist);
			model.addAttribute("customername", (String)session.getAttribute("customername"));
		}
		else
		{
			model.addAttribute("msg", "No Cart Details Found");
			model.addAttribute("customername", (String)session.getAttribute("customername"));
		}
		return "CartList";
		
	}
	
	@RequestMapping("/deletecartdetails")
	public String deleteCartDetailsByCartId(int cartid, Model model,HttpServletRequest request)
	{
		cartDao.removeproductbycartid(cartid);
		HttpSession session = request.getSession();
		int customerid=(int)session.getAttribute("customerid");
		List<Cart> cartlist = cartDao.findByCustomerid(customerid);
		if(cartlist!=null)
		{
			model.addAttribute("cartlist", cartlist);
			model.addAttribute("customername", (String)session.getAttribute("customername"));
		}
		else
		{
			model.addAttribute("msg", "No Cart Details Found");
		}
		return "CartList";
		
	}
	
}
