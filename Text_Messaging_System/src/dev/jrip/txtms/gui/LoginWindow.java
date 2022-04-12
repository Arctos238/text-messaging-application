package dev.jrip.txtms.gui;

import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class LoginWindow extends Application {
   public void start(Stage stage) {
      //Creating a Label
      Label label = new Label("Sample label");
      //Filling color to the label
      label.setTextFill(Color.BROWN);
      //Setting the position
      label.setTranslateX(150);
      label.setTranslateY(25);
      
      Label label1 = new Label("Name:");
      TextField textField = new TextField ();
      Button button = new Button("Test");
      button.setStyle("-fx-background-color: #333333; -fx-text-fill: #FFFFFF ");
      button.setOnAction(new HelloEventHandler());
      
      
      Group root = new Group();
      root.getChildren().add(label);
      root.getChildren().add(label1);
      root.getChildren().add(textField);
      root.getChildren().add(button);
      
      //Setting the stage
      Scene scene = new Scene(root, 595, 150, Color.PINK);
      stage.setTitle("Login Screen");
      stage.setScene(scene);
      stage.show();
      
      LinkedList sll = new LinkedList();
   }
   public static void main(String args[]){
      launch(args);
   }
   
   private class HelloEventHandler implements EventHandler{

	@Override
	public void handle(Event arg0) {
		
	}
	   
   }
}