package dev.jrip.txtms.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomepageWindow extends Application{

	public void start(Stage stage) throws Exception {
		
		// TODO Auto-generated method stub
		
		Group root = new Group();
		
		Scene scene = new Scene(root, 595, 150, Color.WHITE);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

}
