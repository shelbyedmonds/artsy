package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;


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
	openMenu.getItems().addAll(picItem, pic2Item);
	fileTab.getItems().addAll(openMenu, new SeparatorMenuItem(), saveItem,new SeperatorMenuItem(), exitItem);
	menuBar.getMenus().add(fileTab);
	
	root.setTop(menuBar);
	stage.setScene(scene);
	stage.show();        
    } // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
