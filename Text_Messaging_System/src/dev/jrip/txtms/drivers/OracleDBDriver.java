package dev.jrip.txtms.drivers;

import java.sql.*;
import dev.jrip.txtms.contracts.*;

public class OracleDBDriver implements DatabaseDriver {
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "text_messaging_system";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

	Connection connection;

	@Override
	public void connect() throws SQLException {
		final String DB_URL = String.format("jdbc:oracle:thin:cprg250/password@localhost:1521/ORCL");

		connection = DriverManager.getConnection(DB_URL);
		
	}

	@Override
	public ResultSet get(String query) throws SQLException {

		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		

		return resultSet;
		
	}

	@Override
	public int update(String query) throws SQLException {

		connect();
		Statement stmt = connection.createStatement();
		int rows = stmt.executeUpdate(query);
		disconnect();

		return rows;
	}

	@Override
	public void disconnect() throws SQLException {
		connection.close();

	}
	
	public static void main(String[] args) throws SQLException {
		OracleDBDriver db = new OracleDBDriver();
		
		db.connect();
		
		String query = "SELECT * FROM emp";
		
		ResultSet resultSet = db.get(query);
		
		while(resultSet.next()) {
			System.out.println("Emp Number: " + resultSet.getString(1) + " " + "Emp Name: " + resultSet.getString(2));
		}
		
		db.disconnect();
	}
}
