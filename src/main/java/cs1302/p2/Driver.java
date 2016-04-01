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
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.HPos;
import javafx.scene.text.Text;
import javafx.scene.shape.Shape;
import java.io.FileInputStream;
import java.io.InputStream;
import javafx.scene.image.ImageView;




/**
 * This is the driver for this application.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) {
	
	try{
        InputStream is1 = new FileInputStream("/home/ugrads/edmonds/artsy/samples/sample1.png");
        InputStream is2= new FileInputStream("/home/ugrads/edmonds/artsy/samples/sample2.png");
        ImageHandler img1= new ImageHandler(is1);
        ImageHandler img2= new ImageHandler(is2);
	
        FlowPane root = new FlowPane(Orientation.VERTICAL);
	root.setColumnHalignment(HPos.LEFT);
        Scene scene = new Scene(root, 1000,1000);



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
	checkers.setLayoutX(161);
	checkers.setLayoutY(80);
	checkers.setText("Checkers");

	Button horzStripes= new Button();
	horzStripes.setLayoutX(161);
	horzStripes.setLayoutY(80);
	horzStripes.setText("Horizontal Stripes");

	Button vertStripes= new Button();
	vertStripes.setLayoutX(161);
        vertStripes.setLayoutY(80);
        vertStripes.setText("Vertical Stripes"); 


	Button rotate= new Button();
	rotate.setLayoutX(161);
	rotate.setLayoutY(80);
	rotate.setText("Rotate");

	Button reset= new Button();
	reset.setLayoutX(161);
	reset.setLayoutY(80);
	reset.setText("Reset");

	Button rotate1= new Button();
        rotate1.setLayoutX(161);
        rotate1.setLayoutY(80);
        rotate1.setText("Rotate");

        Button reset1= new Button();
        reset1.setLayoutX(161);
        reset1.setLayoutY(80);
        reset1.setText("Reset");

	Button rotate2= new Button();
        rotate2.setLayoutX(161);
        rotate2.setLayoutY(80);
        rotate2.setText("Rotate");

        Button reset2= new Button();
        reset2.setLayoutX(161);
        reset2.setLayoutY(80);
        reset2.setText("Reset");






	HBox buttonBox = new HBox(5);
	buttonBox.setPadding(new Insets(5));
	buttonBox.getChildren().addAll(checkers, horzStripes, vertStripes);

	HBox bottomHalf=new HBox(10);
	bottomHalf.setPadding(new Insets(5));
	

	VBox left= new VBox(5);
	Text t= new Text();
	t.setText("Image 1: Sample1.png");
	ImageView pic2= new ImageView(img1.myImage);
	left.getChildren().addAll(t, pic2, rotate, reset);
	
	VBox middle= new VBox(5);
	Text t1= new Text();
	t1.setText("Image 2: Sample2.png");	
	ImageView pic1= new ImageView(img2.myImage);
	middle.getChildren().addAll(t1, pic1, rotate1, reset1);

	VBox right= new VBox(5);
	Text t3= new Text();
	t3.setText("Result");
	right.getChildren().addAll(t3, rotate2, reset2);



	bottomHalf.getChildren().addAll(left, middle, right);
	
	root.getChildren().addAll(myMenu, buttonBox, bottomHalf);        
    	stage.show();

	}
	catch(Exception e){
                System.exit(0);
        }
	} // createAndShowGUI
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
