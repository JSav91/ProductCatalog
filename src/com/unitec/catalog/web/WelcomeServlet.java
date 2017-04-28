/**
 * 
 */
package com.unitec.catalog.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unitec.catalog.beans.AttendantBean;
import com.unitec.catalog.beans.BeanModel;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.impl.AttendantManager;
import com.unitec.catalog.business.impl.ProductCatalougeManager;
import com.unitec.catalog.business.intf.ManagerInterface;

/**
 * @author JOEL, Sharun
 *
 */
@WebServlet(name = "Welcome", urlPatterns = { "/" },loadOnStartup=1)
public class WelcomeServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static Connection test;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Server Started>Loading index page");

		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/index.jsp");
        dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
