package com.unitec.catalog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.unitec.catalog.beans.AttendantBean;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.impl.AttendantManager;
import com.unitec.catalog.business.impl.ProductCatalougeManager;
import com.unitec.catalog.business.intf.ManagerInterface;

@WebServlet(name = "CreateAttendant", urlPatterns = { "/createAttendant" })
public class CreateAttendantServlet extends HttpServlet {
	/**
	 * @author Ravi
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// creating error string
		String errorString = null;
		String  address = null;
	    String phone = null;
	    // new product bean and getting parameters from jsp tags
		AttendantBean bean= new AttendantBean();
		String name = (String) req.getParameter("name");
	    String addressString = (String) req.getParameter("address");
	    String phoneString = (String) req.getParameter("phone");
	    String comment = (String) req.getParameter("comment");

	    try {
	        address = addressString;
	        phone = phoneString;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    // setting bean
	    bean.setAttendantName(name);
	    bean.setAttendantAddress(address);
	    bean.setAttendantPhone(phone);
	    bean.setAttendantComments(comment);
	    
	    // save bean
	    try{
	    ManagerInterface interface1= new  AttendantManager((Connection)getServletContext().getAttribute("DBConnection"));
	    interface1.saveBean(bean);
	   	}
	   	catch (Exception e){
	   			e.printStackTrace();
	   			errorString = e.getMessage();
	   		}
	    
	 // Store info in request attribute, before forward to views
        req.setAttribute("errorString", errorString);
        req.setAttribute("attendant", bean);
        
        resp.sendRedirect(req.getContextPath() + "/attendant");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
