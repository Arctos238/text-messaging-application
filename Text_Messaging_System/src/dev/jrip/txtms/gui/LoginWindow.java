package dev.jrip.txtms.gui;

import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class LoginWindow extends Application {
	Alert a = new Alert(AlertType.NONE);
	TextField phoneNumberTextField;
	TextField passwordTextField;
	
	public void start(Stage stage) {
		
		
		Label phoneNumberLabel = new Label("Phone Number:");
		phoneNumberLabel.setTextFill(Color.WHITE);
		phoneNumberLabel.setTranslateX(18);
		phoneNumberLabel.setTranslateY(18);
		
		phoneNumberTextField = new TextField();
		phoneNumberTextField.setTranslateX(110);
		phoneNumberTextField.setTranslateY(15);
		
		Label passwordLabel = new Label("Password:");
		passwordLabel.setTextFill(Color.WHITE);
		passwordLabel.setTranslateX(18);
		passwordLabel.setTranslateY(50);
		
		passwordTextField = new TextField();
		passwordTextField.setTranslateX(110);
		passwordTextField.setTranslateY(45);
		
		
		Button button = new Button("Login");
		button.setTranslateX(70);
		button.setTranslateY(100);
		button.setStyle("-fx-background-color: #333333; -fx-text-fill: #FFFFFF ");
		button.setOnAction((ActionEvent e) -> {
			
			String phoneNumber = phoneNumberTextField.getText();
			String password = passwordTextField.getText();
			
			if (phoneNumber.length() != 0 && password.length() != 0) {
				boolean correctInformation = this.CheckLoginDetails(phoneNumber, password);
				
				if(correctInformation) {
					HomepageWindow homepageWindow = new HomepageWindow();
					
					try {
						
						Stage stage1 = new Stage();
						homepageWindow.start(stage1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println(e1 + "Error loading main page");
					}
				} else {
					a.setAlertType(AlertType.ERROR);
					a.setContentText("Incorrect phone number or password");
					a.show();
				}
			} else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("Phone Number or Password Field was left blank");
				a.show();
			}
			
			
			
		});

		Group root = new Group();
		root.getChildren().add(phoneNumberLabel);
		root.getChildren().add(phoneNumberTextField);
		root.getChildren().add(passwordLabel);
		root.getChildren().add(passwordTextField);
		root.getChildren().add(button);

		// Setting the stage
		Scene scene = new Scene(root, 595, 150, Color.BLACK);
		stage.setTitle("Login Screen");
		stage.setScene(scene);
		stage.show();

	}

	private boolean CheckLoginDetails(String phoneNumber, String password) {
		
		return false;
	}

	public static void main(String args[]) {
		launch(args);
	}

}