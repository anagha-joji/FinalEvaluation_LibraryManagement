package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	
	public static Connection getMySqlConnection()
			 throws ClassNotFoundException, SQLException {
		
		String hostName = "localhost";
		String dbName = "librarymanagement";
		String userName = "root";
		String password = "Ab##cd**1999";
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		
		Connection con = DriverManager.getConnection(connectionURL, userName,
	             password);
		
		return con;
	}

	
}
