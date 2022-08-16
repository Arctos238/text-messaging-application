package dev.jrip.txtms.application;

import java.io.*;
import java.sql.*;
import java.sql.SQLException;

import dev.jrip.txtms.drivers.MariaDBDriver;
import dev.jrip.txtms.managers.ApplicationManager;

public class ApplicationDriver {
	
	public static void main(String[] args) throws SQLException {
		
	ApplicationManager applicationManager = new ApplicationManager();
		
	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

	}

}
