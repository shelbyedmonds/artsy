package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem; 
import javafx.scene.control.SeparatorMenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) {

        FlowPane root = new FlowPane();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Artsy!");
        stage.sizeToScene();
        stage.show();
	

	MenuBar myMenu= new MenuBar();
	Menu fileTab= new Menu("File");
	MenuItem openItem= new MenuItem("Open");
	MenuItem picItem= new MenuItem("Open Image 1");
	MenuItem pic2Item= new MenuItem("Open Image 2");
	MenuItem saveItem= new MenuItem("Save Result As");
	MenuItem exitItem= new MenuItem("Exit");
	Menu openMenu= new Menu("Open");
	SeparatorMenuItem bar= new SeparatorMenuItem();
	SeparatorMenuItem bar2= new SeparatorMenuItem();
	openMenu.getItems().addAll(picItem, pic2Item);
	fileTab.getItems().addAll(openMenu, bar, saveItem, bar2, exitItem);
	myMenu.getMenus().add(fileTab);
	
	stage.setScene(scene);
	stage.show();


	Button checkers= new Button();
	checkers.setLayoutX(100);
	checkers.setLayoutY(80);
	checkers.setText("Checkers");

	Button horzStripes= new Button();
	horzStripes.setLayoutX(100);
	horzStripes.setLayoutY(80);
	horzStripes.setText("Horizontal Stripes");

	Button vertStripes= new Button();
	vertStripes.setLayoutX(100);
        vertStripes.setLayoutY(80);
        vertStripes.setText("Vertical Stripes"); 


	HBox buttonBox = new HBox(5);
//	buttonBox.setPadding(1);
	buttonBox.getChildren().addAll(checkers, horzStripes, vertStripes);

	root.getChildren().addAll(myMenu,buttonBox);        
    	stage.show();
	} // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
