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
		ProductBean savedBean=(ProductBean)model;
		
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(ProjectConstants.INSERT_PRODUCT);
			
			preparedStmt.setString(1,savedBean.getProductName());
			preparedStmt.setDouble(2,savedBean.getProductPrice());
			preparedStmt.setInt(3,savedBean.getProductStock());
			preparedStmt.setString(4,savedBean.getProductComments());
			boolean status=preparedStmt.execute();
			if(status)
				return model;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BeanModel updateBean(BeanModel model) {
		ProductBean savedBean=(ProductBean)model;

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(ProjectConstants.UPDATE_PRODUCT);
			preparedStmt.setString(1,savedBean.getProductName());
			preparedStmt.setDouble(2,savedBean.getProductPrice());
			preparedStmt.setInt(3,savedBean.getProductStock());
			preparedStmt.setString(4,savedBean.getProductComments());
			preparedStmt.setInt(5,savedBean.getProductId());
			
			int status=preparedStmt.executeUpdate();
			if(status==1)
				return savedBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteBean(BeanModel model) {
		ProductBean savedBean=(ProductBean)model;
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(ProjectConstants.DELETE_PRODUCT);
			preparedStmt.setInt(1,savedBean.getProductId());
			int status=preparedStmt.executeUpdate();
			if(status==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<BeanModel> searchBeanByName(BeanModel model) {
		ArrayList<BeanModel> productBeans= new ArrayList<BeanModel>();
		ProductBean searchBean=(ProductBean)model;

		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(ProjectConstants.SEARCH_PRODUCT+"'"+searchBean.getProductName()+"'");
			while(resultSet.next()){
				ProductBean productBean=new ProductBean();
				productBean.setProductId(resultSet.getInt("PRD_ID"));
				productBean.setProductName(resultSet.getString("PRD_NAME"));
				productBean.setProductPrice(resultSet.getDouble("PRD_PRICE"));
				productBean.setProductStock(resultSet.getInt("PRD_STOCK"));
				productBean.setProductComments(resultSet.getString("PRD_COMMENTS"));
				productBeans.add(productBean);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return productBeans;
	}
	
	
}
