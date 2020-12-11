package com.example.lambda;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author oracle
 */
public class ClickTest extends Application{
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage){
    
    primaryStage.setTitle("Click Test");
    Button btn= new Button();
    Button btn2 = new Button();
    HBox hb = new HBox();
    
    btn.setText("Test Button");
    btn.setOnAction(
      (ActionEvent event) -> 
        { System.out.println("Click detected by Anon Class"); });
    
    btn.addEventHandler(ActionEvent.ACTION, 
       e -> System.out.println("Button 1 2nd listner"));
    
    btn2.setText("Test Button 2");
    btn2.setOnAction(e -> System.out.println("Test 2 button clicked"));
    btn2.addEventHandler(ActionEvent.ACTION, 
       e -> {
         System.out.println("Button 2 Message 1");
         System.out.println("Message 2");
         System.out.println("Message 3");
       });
    
    
    StackPane root = new StackPane();
    hb.getChildren().add(btn);
    hb.getChildren().add(btn2);
    root.getChildren().add(hb);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
    
  } 
}
