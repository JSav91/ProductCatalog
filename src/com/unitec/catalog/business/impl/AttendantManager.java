package com.unitec.catalog.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.unitec.catalog.beans.AttendantBean;
import com.unitec.catalog.beans.BeanModel;
import com.unitec.catalog.business.intf.ManagerInterface;
import com.unitec.catalog.constants.ProjectConstants;

public class AttendantManager implements ManagerInterface{

	private Connection connection =null;
	private PreparedStatement preparedStatement = null;
	private Statement statement=null;
	private ResultSet resultSet = null;
	
	public AttendantManager(Connection connection) {
		this.connection=connection;

	}
	
	@Override
	public ArrayList<BeanModel> getAllRows() {
		ArrayList<BeanModel> attendantBeans= new ArrayList<BeanModel>();
		
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(ProjectConstants.GET_ALL_ATTENDANTS);
			
			while(resultSet.next()){
				AttendantBean attendantBean= new AttendantBean();
				attendantBean.setAttendantId(resultSet.getInt("ATT_ID"));
				attendantBean.setAttendantName(resultSet.getString("ATT_NAME"));
				attendantBean.setAttendantAddress(resultSet.getString("ATT_ADDRESS"));
				attendantBean.setAttendantPhone(resultSet.getString("ATT_MOBILENUM"));
				attendantBean.setAttendantComments(resultSet.getString("ATT_COMMENTS"));
				attendantBeans.add(attendantBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attendantBeans;
	}

	@Override
	public BeanModel saveBean(BeanModel model) {
		AttendantBean attendantBean=(AttendantBean)model;
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(ProjectConstants.INSERT_ATTENDANT);
			preparedStmt.setString(1,attendantBean.getAttendantName());
			preparedStmt.setString(2,attendantBean.getAttendantAddress());
			preparedStmt.setString(3,attendantBean.getAttendantPhone());
			preparedStmt.setString(4,attendantBean.getAttendantComments());
			boolean status=preparedStmt.execute();
			if(status)
				return attendantBean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BeanModel updateBean(BeanModel model) {
		AttendantBean attendantBean= (AttendantBean)model;
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(ProjectConstants.UPDATE_ATTENDANT);
			preparedStmt.setString(1,attendantBean.getAttendantName());
			preparedStmt.setString(2,attendantBean.getAttendantAddress());
			preparedStmt.setString(3,attendantBean.getAttendantPhone());
			preparedStmt.setString(4,attendantBean.getAttendantComments());
			System.out.println(attendantBean.getAttendantId());
			preparedStmt.setInt(5,attendantBean.getAttendantId());
			
			int status=preparedStmt.executeUpdate();
			if(status==1)
				return attendantBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteBean(BeanModel model) {
		AttendantBean attendantBean=(AttendantBean)model;
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(ProjectConstants.DELETE_ATTENDANT);
			preparedStmt.setInt(1,attendantBean.getAttendantId());
			int status=preparedStmt.executeUpdate();
			if(status==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public ArrayList<BeanModel> searchBeanByName(BeanModel model) {
		ArrayList<BeanModel> attendantBeans= new ArrayList<BeanModel>();
		AttendantBean searchBean=(AttendantBean)model;
		
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(ProjectConstants.SEARCH_ATTENDANT+"'"+searchBean.getAttendantName()+"'");
			while(resultSet.next()){
				AttendantBean attendantBean= new AttendantBean();
				attendantBean.setAttendantId(resultSet.getInt("ATT_ID"));
				attendantBean.setAttendantName(resultSet.getString("ATT_NAME"));
				attendantBean.setAttendantAddress(resultSet.getString("ATT_ADDRESS"));
				attendantBean.setAttendantPhone(resultSet.getString("ATT_MOBILENUM"));
				attendantBean.setAttendantComments(resultSet.getString("ATT_COMMENTS"));
				attendantBeans.add(attendantBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return attendantBeans;
	}

}
