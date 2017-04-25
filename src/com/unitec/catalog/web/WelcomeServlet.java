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
//		ProductBean bean= new ProductBean();
	//	bean.setProductId(6);
//		bean.setProductName("Desktop");
	//	bean.setProductPrice(1190.90);
	//	bean.setProductStock(2);
	//	bean.setProductComments("HP Pavilion");
/*		ManagerInterface interface1= new  ProductCatalougeManager((Connection)getServletContext().getAttribute("DBConnection"));
		ArrayList<BeanModel> list=interface1.searchBeanByName(bean);
		
		
		for(BeanModel bean2:list){
			ProductBean bean3=(ProductBean) bean2;
			System.out.println(bean3.getProductPrice()+"\n"+bean3.getProductName()+"\n"+bean3.getProductPrice()+"\n"+bean3.getProductStock());
		}*/
		
//		ManagerInterface interface2= new  AttendantManager((Connection)getServletContext().getAttribute("DBConnection"));
//		AttendantBean attendantBean= new AttendantBean();
//		attendantBean.setAttendantName("Tariq");
//		attendantBean.setAttendantAddress("Unitec");
//		attendantBean.setAttendantPhone("022612787");
//		attendantBean.setAttendantComments("Java Lecturer");
//		attendantBean.setAttendantId(2);
//		interface2.updateBean(attendantBean);
		
/*		for(BeanModel bean12:list2){
			AttendantBean beanq=(AttendantBean) bean12;
			System.out.println(beanq.getAttendantName()+"\n"+beanq.getAttendantPhone()+"\n"+beanq.getAttendantAddress()+"\n"+beanq.getAttendantAddress());
		}*/
		//ManagerInterface interface2= new AttendantManager();
		//resp.sendRedirect("jsp/index.jsp");
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/index.jsp");
        dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
