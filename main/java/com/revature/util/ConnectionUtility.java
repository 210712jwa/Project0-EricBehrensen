package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;

// This class will contain a static method that interacts with the JDBC API to return a connection object
public class ConnectionUtility {
	private ConnectionUtility() {
		
	}

	// Interacts with the DriverManager class from the JBDC API to return a connection object
	public static Connection getConnection() throws SQLException {
		// Allows JBDC to be able to communicate with the database
		DriverManager.registerDriver(new Driver());
		
		String url = System.getenv("db_url");
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");
		
		// Here we actually obtain a connection object
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
}
