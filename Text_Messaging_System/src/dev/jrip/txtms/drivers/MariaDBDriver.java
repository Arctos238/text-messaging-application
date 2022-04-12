package dev.jrip.txtms.drivers;

import java.sql.*;
import dev.jrip.txtms.contracts.*;

public class MariaDBDriver implements DatabaseDriver {
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "text_messaging_system";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

	Connection connection;

	@Override
	public void connect() throws SQLException {
		final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", SERVER, PORT, DATABASE,
				USERNAME, PASSWORD);

		connection = DriverManager.getConnection(DB_URL);

	}

	@Override
	public ResultSet get(String query) throws SQLException {

		connect();
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		disconnect();

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
		MariaDBDriver db = new MariaDBDriver();
		db.connect();
	}
}
