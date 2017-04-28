/**
 * 
 */
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
import com.unitec.catalog.beans.AttendantBean;
import com.unitec.catalog.beans.BeanModel;
import com.unitec.catalog.business.impl.AttendantManager;
import com.unitec.catalog.business.intf.ManagerInterface;

/**
 * @author Ravi
 *
 */
@WebServlet(name = "Attendant", urlPatterns = { "/attendant" })
public class AttendantManagerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// creating error string
				String errorString = null;
				
				 // getting parameters from jsp tags
				String nameSearch = (String) req.getParameter("searchByName");
				ArrayList<BeanModel> list = null;
				System.out.println("Loading attendant page ");
				
				// get all rows if search is empty
				if (nameSearch == null || nameSearch.isEmpty()){
					try{
					ManagerInterface interface1= new  AttendantManager((Connection)getServletContext().getAttribute("DBConnection"));
					list = interface1.getAllRows();
					
					}
					catch (Exception e){
						e.printStackTrace();
						errorString = e.getMessage();
						
					}
				}
				
				// get searched rows on search
				else{
					
					AttendantBean bean= new AttendantBean();
					bean.setAttendantName(nameSearch);
					
					try{
						ManagerInterface interface1= new  AttendantManager((Connection)getServletContext().getAttribute("DBConnection"));
						list = interface1.searchBeanByName(bean);
						
						}
						catch (Exception e){
							e.printStackTrace();
							errorString = e.getMessage();
						}
					if (list == null || list.isEmpty()){
						errorString = "Your search yielded no results";
					}
				}
				// Store info in request attribute, before forward to view jsp
				if (list == null || list.isEmpty()){
					req.setAttribute("errorString", errorString);
				}
				else{
			        req.setAttribute("errorString", errorString);
			        req.setAttribute("attendantList", list);
				}
		        
				RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/Attendant.jsp");
		        dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
