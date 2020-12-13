package com.mmt.myPort.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PropertyFileReader propReader = new PropertyFileReader();
			Connection con = DriverManager.getConnection(
					propReader.getProperty("url"), propReader.getProperty("username"), propReader.getProperty("password"));

			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
