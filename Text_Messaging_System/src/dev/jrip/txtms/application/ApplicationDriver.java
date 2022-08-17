package dev.jrip.txtms.application;

import java.sql.*;
import java.sql.SQLException;
import dev.jrip.txtms.gui.LoginWindow;
import javafx.application.Application;
import javafx.stage.Stage;


public class ApplicationDriver {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		
		Application.launch(LoginWindow.class, args);
	}

}
