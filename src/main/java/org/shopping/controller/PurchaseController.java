package org.shopping.controller;

import java.util.List;

import org.shopping.dao.CartDao;
import org.shopping.dao.ProductDao;
import org.shopping.dao.PurchaseDao;
import org.shopping.entity.Cart;
import org.shopping.entity.Product;
import org.shopping.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PurchaseController 
{
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	PurchaseDao purchaseDao;
	
	@RequestMapping("/cartbuyproduct")	
	public String cartbuyproduct(Model model,HttpServletRequest request,int cartid)
	{
		HttpSession session = request.getSession();
		String customername = (String)session.getAttribute("customername");
		int customerid =(int) session.getAttribute("customerid");
		System.out.println(cartid);
		Cart cart= cartDao.findByCartId(cartid);
		if(cart!=null)
		{
			String productname= cart.getProductname();
			double productprice=cart.getProductprice();
			model.addAttribute("customername", customername);
			model.addAttribute("customerid", customerid);
			model.addAttribute("productname", productname);
			model.addAttribute("productprice", productprice);
			return "BuyProduct";
		}
		else
		{
			return "CartList";
		}
		
	}

	@RequestMapping("/productbuyproduct")	
	public String productbuyproduct(Model model,HttpServletRequest request, int productid)
	{
		HttpSession session = request.getSession();
		session.setAttribute("productid", productid);
		String customername = (String)session.getAttribute("customername");
		int customerid =(int) session.getAttribute("customerid");
		System.out.println(productid);
		Product product =productDao.getproductdetailsbyid(productid);
		if(product!=null)
		{
			String productname=product.getProductname();
			double productprice=product.getProductprice();
			model.addAttribute("customername", customername);
			model.addAttribute("customerid", customerid);
			model.addAttribute("productname", productname);
			model.addAttribute("productprice", productprice);
			session.setAttribute("customername", customername);
			session.setAttribute("customerid", customerid);
			session.setAttribute("productname", productname);
			session.setAttribute("productprice", productprice);
			return "BuyProduct";
		}
		else
		{
			return "ProductList";
		}
	}
	
	@RequestMapping("/addtopurchase")
	public String addtoputchase(Model model, HttpServletRequest request,int customerid,String productname,double productprice, int quantity, double amountpaid )
	{
		HttpSession session = request.getSession();
		Purchase purchase = new Purchase();
		purchase.setAmountpaid(amountpaid);
		purchase.setCustomerid(customerid);
		purchase.setProductname(productname);
		purchase.setProductprice(productprice);
		purchase.setQuantity(quantity);
		if(purchase!=null)
		{
			purchaseDao.savePurchase(purchase);
			String customername =(String) session.getAttribute("customername");
		    String customeremailid =(String) session.getAttribute("customeremailid");
		    String customermobilenumber =(String) session.getAttribute("customermobilenumber");
		    String customeraddress =(String) session.getAttribute("customeraddress");
		    String customergender =(String) session.getAttribute("customergender");
		    customerid =(Integer) session.getAttribute("customerid");
		    model.addAttribute("customername", customername);
			model.addAttribute("customeremailid", customeremailid);
			model.addAttribute("customermobilenumber",customermobilenumber);
			model.addAttribute("customeraddress", customeraddress);
			model.addAttribute("customergender", customergender);
			model.addAttribute("customerid", customerid);			
			return "CustomerOptions";
		}
		else
		{
			String customername = (String)session.getAttribute("customername");
			customerid  = (Integer) session.getAttribute("customerid");
			productname = (String)session.getAttribute("productname");
			productprice = (Double)session.getAttribute("productprice");
			model.addAttribute("msg","Product Purchase Fail");
			return "BuyProduct";
		}
	}
		
	@RequestMapping("/getallpurchasedetails")
	public String getAllPurchaseDetails(Model model,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		int customerid=(int)session.getAttribute("customerid");
		List<Purchase> purchaselist= purchaseDao.getAllPurchaseList(customerid);
		if(purchaselist!=null)
		{
			model.addAttribute("purchaselist", purchaselist);
			model.addAttribute("customername", (String)session.getAttribute("customername"));
		}
		else
		{
			model.addAttribute("msg","No Details Found");
			model.addAttribute("customername", (String)session.getAttribute("customername"));
		}
		return "PurchaseList";
	}
}
