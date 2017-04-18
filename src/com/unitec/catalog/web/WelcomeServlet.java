/**
 * 
 */
package com.unitec.catalog.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unitec.catalog.beans.BeanModel;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.impl.ProductCatalougeManager;
import com.unitec.catalog.business.intf.ManagerInterface;

/**
 * @author JOEL
 *
 */
@WebServlet(name = "Welcome", urlPatterns = { "/" },loadOnStartup=1)
public class WelcomeServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Server Started>Loading index page");
		ProductBean bean= new ProductBean();
		ManagerInterface interface1= new  ProductCatalougeManager((Connection)getServletContext().getAttribute("DBConnection"));
		ArrayList<BeanModel>list=interface1.getAllRows();
		for(BeanModel bean2:list){
			ProductBean bean3=(ProductBean) bean2;
			System.out.println(bean3.getProductId()+"\n"+bean3.getProductName()+"\n");
		}
		//ManagerInterface interface2= new AttendantManager();
		//resp.sendRedirect("jsp/index.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
