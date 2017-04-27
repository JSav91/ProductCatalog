package com.unitec.catalog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.unitec.catalog.beans.AttendantBean;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.impl.AttendantManager;
import com.unitec.catalog.business.impl.ProductCatalougeManager;
import com.unitec.catalog.business.intf.ManagerInterface;

public class EditAttendantServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null,address=null,phone=null;
		 
	    int  id = 0;
		AttendantBean bean= new AttendantBean();
		
		 // new product bean and getting parameters from jsp tags
		String idString = (String) req.getParameter("id");
		String name = (String) req.getParameter("name");
	    String addressString = (String) req.getParameter("address");
	    String phoneString = (String) req.getParameter("phone");
	    String comment = (String) req.getParameter("comment");

	    try {
	         
	        id = Integer.parseInt(idString);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    // setting bean
	    bean.setAttendantId(id);
	    bean.setAttendantName(name);
	    bean.setAttendantAddress(addressString);
	    bean.setAttendantPhone(phoneString);
	    bean.setAttendantComments(comment);
	   
	   // save bean
	    try{
	    ManagerInterface interface1= new  AttendantManager((Connection)getServletContext().getAttribute("DBConnection"));
	    interface1.updateBean(bean);
	   	}
	   	catch (Exception e){
	   			e.printStackTrace();
	   			errorString = e.getMessage();
	   		}
	    
	 // Store info in request attribute, before forward to views
        req.setAttribute("errorString", errorString);
        
        resp.sendRedirect(req.getContextPath() + "/attendant");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
