package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionHandler {
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

	private Connection connection = null;

	public boolean login(String username, String password) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			System.out.println("SETUP DONE");
			return true; // Connection successful
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC Driver not found.");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
			return false;
		}
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
