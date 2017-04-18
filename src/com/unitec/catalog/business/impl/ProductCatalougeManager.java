/**
 * 
 */
package com.unitec.catalog.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.unitec.catalog.beans.BeanModel;
import com.unitec.catalog.beans.ProductBean;
import com.unitec.catalog.business.intf.ManagerInterface;
import com.unitec.catalog.constants.ProjectConstants;

/**
 * @author JOEL
 * All business implementaion goes here
 */
public class ProductCatalougeManager implements ManagerInterface{

	
	private Connection connection =null;
	private PreparedStatement preparedStatement = null;
	private Statement statement=null;
	private ResultSet resultSet = null;

	public ProductCatalougeManager(Connection connection) {
		this.connection=connection;
	}

	@Override
	public ArrayList<BeanModel> getAllRows() {
		
		ArrayList<BeanModel> productBeans= new ArrayList<BeanModel>();
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(ProjectConstants.GET_ALL_PRODUCTS);
			
			while(resultSet.next()){
				ProductBean productBean=new ProductBean();
				productBean.setProductId(resultSet.getInt("PRD_ID"));
				productBean.setProductName(resultSet.getString("PRD_NAME"));
				productBean.setProductPrice(resultSet.getDouble("PRD_PRICE"));
				productBean.setProductStock(resultSet.getInt("PRD_STOCK"));
				productBean.setProductComments(resultSet.getString("PRD_COMMENTS"));
				productBeans.add(productBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productBeans;
	}

	@Override
	public BeanModel saveBean(BeanModel model) {

		return null;
	}

	@Override
	public BeanModel updateBean(BeanModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBean(BeanModel model) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
