package com.ems.dbconnection;

import java.sql.*;

public class DatabaseConnection {

	public static Connection connection;

	private DatabaseConnection() {
		// Register load driver
	}

	public static Connection getConnection() {
		try {
			if (connection == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// Create Connection
				connection = DriverManager.getConnection("jdbc:oracle:thin:@10.97.106.62:1521:orcl", "Test1", "test1");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
