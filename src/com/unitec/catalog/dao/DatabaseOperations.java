/**
 * 
 */
package com.unitec.catalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


/**
 * @author JOEL
 * no business implementation.only database configuration details
 */
public class DatabaseOperations {




	private Connection connection;

	public DatabaseOperations(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user, pwd);

	}

	public Connection getConnection(){
		return this.connection;
	}
}
