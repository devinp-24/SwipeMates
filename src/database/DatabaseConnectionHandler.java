package database;

import model.userModel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class DatabaseConnectionHandler {
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

	private Connection connection = null;

	public boolean login(String username, String password) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			databaseSetup();
			// printUsersTable();

			System.out.println("Login and setup done.");
			return true;
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

	public void databaseSetup() {
		try (InputStream is = getClass().getResourceAsStream("/scripts/script.sql");  // Corrected path
			 BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			 Statement stmt = connection.createStatement()) {

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				if (line.trim().endsWith(";")) {
					String statementToExecute = sb.toString().replaceAll(";$", "").trim();
					if (!statementToExecute.isEmpty()) {
						try {
							stmt.execute(statementToExecute);
						} catch (SQLException e) {
							if (e.getErrorCode() == 942) {
								System.out.println("Table does not exist, no need to drop");
							} else {
								throw e;  // Rethrow for other SQL errors
							}
						}
					}
					sb.setLength(0);  // Reset StringBuilder for next SQL command
				}
			}
		} catch (SQLException e) {
			System.out.println("[EXCEPTION] " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[EXCEPTION] " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("[EXCEPTION] Unable to load script file. Ensure the file path is correct.");
		}
	}

	public void printUsersTable() {
		String query = "SELECT * FROM Users";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			// Print column headers
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(String.format("%-30s", rsmd.getColumnName(i)));
			}
			System.out.println();

			// Print rows
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					String columnValue = rs.getString(i);
					System.out.print(String.format("%-30s", columnValue));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("[EXCEPTION] " + e.getMessage());
		}
	}


	public void insertUser(userModel user) {
		String insertSql = "INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getName());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getBio());
			ps.setInt(5, user.getAge());
			ps.executeUpdate();
			appendInsertStatementToFile(user);
			printUsersTable();
		} catch (SQLException e) {
			System.out.println("[EXCEPTION] " + e.getMessage());
		}
	}

	private void appendInsertStatementToFile(userModel model) {
		String sqlStatement = String.format("INSERT INTO Users VALUES ('%s', '%s', '%s', '%s', %d);\n",
				model.getUserID(), model.getName(), model.getGender(), model.getBio(), model.getAge());

		try(FileWriter fw = new FileWriter("src/scripts/script.sql", true);
			PrintWriter out = new PrintWriter(fw)) {
			out.println(sqlStatement);
		} catch (IOException e) {
			System.out.println("EXCEPTION + " + e.getMessage());
		}
	}

	public boolean checkUserId(String userIdInput) {
		String checkSql = "SELECT UserID FROM Users WHERE UserID = ?";
		boolean userIdExists = false;
		try (PreparedStatement ps = connection.prepareStatement(checkSql)) {
			ps.setString(1, userIdInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					userIdExists = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("[EXCEPTION] " + e.getMessage());
		}
		return userIdExists;
	}
}
