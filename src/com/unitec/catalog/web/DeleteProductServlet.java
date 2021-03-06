package com.unitec.catalog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.impl.ProductCatalougeManager;
import com.unitec.catalog.business.intf.ManagerInterface;


@WebServlet(name = "DeleteProduct", urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
	    int id = 0;
		ProductBean bean= new ProductBean();
		
		String idString = (String) req.getParameter("id");

	    try {
	        id = Integer.parseInt(idString);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    bean.setProductId(id);
	   
	    try{
	    ManagerInterface interface1= new  ProductCatalougeManager((Connection)getServletContext().getAttribute("DBConnection"));
	    interface1.deleteBean(bean);
	   	}
	   	catch (Exception e){
	   			e.printStackTrace();
	   			errorString = e.getMessage();
	   		}
	    
	 // Store info in request attribute, before forward to views
        req.setAttribute("errorString", errorString);
        
        resp.sendRedirect(req.getContextPath() + "/product");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
