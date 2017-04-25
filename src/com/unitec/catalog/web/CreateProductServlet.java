package com.unitec.catalog.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.unitec.catalog.beans.BeanModel;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.impl.ProductCatalougeManager;
import com.unitec.catalog.business.intf.ManagerInterface;


@WebServlet(name = "CreateProduct", urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {

	/**
	 * @author Sharun
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// creating error string
		String errorString = null;
		double price = 0;
	    int stock = 0;
	    // new product bean and getting parameters from jsp tags
		ProductBean bean= new ProductBean();
		String name = (String) req.getParameter("name");
	    String priceString = (String) req.getParameter("price");
	    String stockString = (String) req.getParameter("stock");
	    String comment = (String) req.getParameter("comment");

	    try {
	        price = Double.parseDouble(priceString);
	        stock = Integer.parseInt(stockString);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    // setting bean
	    bean.setProductName(name);
	    bean.setProductPrice(price);
	    bean.setProductStock(stock);
	    bean.setProductComments(comment);
	    
	    // save bean
	    try{
	    ManagerInterface interface1= new  ProductCatalougeManager((Connection)getServletContext().getAttribute("DBConnection"));
	    interface1.saveBean(bean);
	   	}
	   	catch (Exception e){
	   			e.printStackTrace();
	   			errorString = e.getMessage();
	   		}
	    
	 // Store info in request attribute, before forward to views
        req.setAttribute("errorString", errorString);
        req.setAttribute("product", bean);
        
        resp.sendRedirect(req.getContextPath() + "/product");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
