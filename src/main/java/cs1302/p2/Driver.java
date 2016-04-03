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
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Label;
import javafx.geometry.Pos;



/**
 * This is the driver for this application.
 */
public class Driver extends Application {

	public static ImageView pic1;
	public static ImageView pic2;
    	public static ImageView  pic3;
	
	@Override
    public void start(Stage stage) {
	
	try{
	MyArtsy ArtObj= new MyArtsy();
        InputStream is1 = new FileInputStream("/home/ugrads/edmonds/artsy/resources/default.png");
        InputStream is2= new FileInputStream("/home/ugrads/edmonds/artsy/resources/default.png");
        InputStream is3= new FileInputStream("/home/ugrads/edmonds/artsy/resources/default.png");
	ImageHandler img1= new ImageHandler(is1);
        ImageHandler img2= new ImageHandler(is2);
	ImageHandler img3= new ImageHandler(is3);	


        FlowPane root = new FlowPane(Orientation.VERTICAL);
	root.setColumnHalignment(HPos.LEFT);
        Scene scene = new Scene(root, 1000,950);



        stage.setScene(scene);
        stage.setTitle("Artsy!");
        stage.sizeToScene();
        stage.show();

	MenuBar myMenu= new MenuBar();
	Menu fileTab= new Menu("File");
	MenuItem openItem= new MenuItem("Open");
	MenuItem picItem= new MenuItem("Open Image 1");


	MenuItem picItem2= new MenuItem("Open Image 2");
	MenuItem saveItem= new MenuItem("Save Result As");
	
	MenuItem exitItem= new MenuItem("Exit");
	exitItem.setOnAction(actionEvent -> Platform.exit());
	
	Menu openMenu= new Menu("Open");
	SeparatorMenuItem bar= new SeparatorMenuItem();
	SeparatorMenuItem bar2= new SeparatorMenuItem();
	openMenu.getItems().addAll(picItem, picItem2);
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
	int height=2;
	

	Button vertStripes= new Button();
	vertStripes.setLayoutX(161);
        vertStripes.setLayoutY(80);
        vertStripes.setText("Vertical Stripes"); 
	int width=2;
	
	Button rotate= new Button();
	rotate.setLayoutX(161);
	rotate.setLayoutY(80);
	rotate.setText("Rotate");
	double degrees=0;
	
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

	HBox bottomHalf=new HBox(10);
        bottomHalf.setPadding(new Insets(5));

        VBox left= new VBox(5);
        Text t= new Text();
        t.setText("Image 1:");
        pic1= new ImageView(img1.myImage);
        left.getChildren().addAll(t, pic1, rotate, reset);

        VBox middle= new VBox(5);
        Text t1= new Text();
        t1.setText("Image 2: ");
        pic2= new ImageView(img2.myImage);
        middle.getChildren().addAll(t1, pic2, rotate1, reset1);

        VBox right= new VBox(5);
        Text t3= new Text();
        t3.setText("Result");
        pic3= new ImageView(img3.myImage);
        right.getChildren().addAll(t3, pic3, rotate2, reset2);

	HBox buttonBox = new HBox(5);
	buttonBox.setPadding(new Insets(5));
	buttonBox.getChildren().addAll(checkers, horzStripes, vertStripes);
	
	bottomHalf.getChildren().addAll(left, middle, right);
	root.getChildren().addAll(myMenu, buttonBox, bottomHalf);        
    	
	picItem.setOnAction(actionEvent -> {
                        FileChooser fileFinder1= new FileChooser();
                        fileFinder1.setTitle("Open Image 1");
                        fileFinder1.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
                        try{File myFile= fileFinder1.showOpenDialog(stage);
                        InputStream newStream= new FileInputStream(myFile);
                        ImageHandler X= new ImageHandler(newStream);
                        pic1= new ImageView(X.myImage);
                        left.getChildren();
                        }
                        catch(Exception e){
                        System.out.println();
                        }
        });

	 picItem2.setOnAction(actionEvent -> {
                        FileChooser fileFinder2= new FileChooser();
                        fileFinder2.setTitle("Open Image 1");
                        fileFinder2.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
                        try{File myFile2= fileFinder2.showOpenDialog(stage);
                        InputStream newStream2= new FileInputStream(myFile2);
                        ImageHandler Y= new ImageHandler(newStream2);
                        pic2= new ImageView(Y.myImage);
                        middle.getChildren();
                        }
                        catch(Exception e){
                        System.out.println();
                        }
        });

	checkers.setOnAction(actionEvent -> {
                ArtObj.doCheckers(img1.myImage, img2.myImage, 300);
                root.getChildren();
                stage.show();
                });

	horzStripes.setOnAction(actionEvent -> {
                ArtObj.doHorizontalStripes(img1.myImage,img2.myImage, height);
                root.getChildren();
                stage.show();
                });

	vertStripes.setOnAction(actionEvent -> {
                ArtObj.doVerticalStripes(img1.myImage, img2.myImage, width);
                root.getChildren();
                stage.show();

                });

	rotate.setOnAction(actionEvent -> {
                root.getChildren();
                stage.show();
		
		BorderPane bp= new BorderPane();
		Stage stage2= new Stage();
		Scene sceneRot = new Scene(bp, 100,90);
		
		stage2.setScene(sceneRot);
		stage2.setTitle("Rotate Image Options");
		Label boxLabel= new Label("Please enter your angle, in degrees: ");
		bp.setTop(boxLabel);
		bp.setAlignment(boxLabel, Pos.CENTER);
		TextField rotField= new TextField("45.0");
		Button saveButton= new Button("Save");
		saveButton.setLayoutX(161);
        	saveButton.setLayoutY(80);
		saveButton.setOnAction(actionEvent2 -> {
			Double degrees1= Double.parseDouble(rotField.getText());
			ArtObj.doRotate(img1.myImage, degrees1);
			stage2.close();
		});	


	
		Button cancelButton= new Button ("Cancel");
		cancelButton.setLayoutX(161);
        	cancelButton.setLayoutY(80);
		cancelButton.setOnAction(actionEvent3 -> stage2.close());

		HBox bottomRot= new HBox();
		bottomRot.setPadding(new Insets(10));
		bottomRot.getChildren().addAll(cancelButton, saveButton);
	
		bp.setCenter(rotField);
		bp.setAlignment(rotField, Pos.CENTER);
		bp.setBottom(bottomRot);
		bp.setAlignment(bottomRot, Pos.CENTER);
		
		
		stage2.show();	
                

		});

	 rotate1.setOnAction(actionEvent -> {
                root.getChildren();
                stage.show();

		BorderPane bp2= new BorderPane();
                Stage stage3= new Stage();
                Scene sceneRot2 = new Scene(bp2, 100,90);

                stage3.setScene(sceneRot2);
                stage3.setTitle("Rotate Image Options");
                Label boxLabel2= new Label("Please enter your angle, in degrees: ");
                bp2.setTop(boxLabel2);
                bp2.setAlignment(boxLabel2, Pos.CENTER);
                TextField rotField2= new TextField("45.0");
                Button saveButton2= new Button("Save");
                saveButton2.setLayoutX(161);
                saveButton2.setLayoutY(80);
		saveButton2.setOnAction(actionEvent2 -> {
                        Double degrees1= Double.parseDouble(rotField2.getText());
                        ArtObj.doRotate(img1.myImage, degrees1);
                        stage3.close();
                });		


                Button cancelButton2= new Button ("Cancel");
                cancelButton2.setLayoutX(161);
                cancelButton2.setLayoutY(80);
                cancelButton2.setOnAction(actionEvent3 -> stage3.close());

		HBox bottomRot2= new HBox();
                bottomRot2.setPadding(new Insets(10));
                bottomRot2.getChildren().addAll(cancelButton2, saveButton2);

                bp2.setCenter(rotField2);
                bp2.setAlignment(rotField2, Pos.CENTER);
                bp2.setBottom(bottomRot2);
                bp2.setAlignment(bottomRot2, Pos.CENTER);



                stage3.show();


                });

	rotate2.setOnAction(actionEvent -> {
                root.getChildren();
                stage.show();
                

		BorderPane bp3= new BorderPane();
                Stage stage4= new Stage();
                Scene sceneRot3 = new Scene(bp3, 100,90);

                stage4.setScene(sceneRot3);
                stage4.setTitle("Rotate Image Options");
                Label boxLabel3= new Label("Please enter your angle, in degrees: ");
                bp3.setTop(boxLabel3);
                bp3.setAlignment(boxLabel3, Pos.CENTER);
                TextField rotField3= new TextField("45.0");
                Button saveButton3= new Button("Save");
                saveButton3.setLayoutX(161);
                saveButton3.setLayoutY(80);
		saveButton3.setOnAction(actionEvent2 -> {
                        Double degrees1= Double.parseDouble(rotField3.getText());
                        ArtObj.doRotate(img1.myImage, degrees1);
                        stage4.close();
                });		

                Button cancelButton3= new Button ("Cancel");
                cancelButton3.setLayoutX(161);
                cancelButton3.setLayoutY(80);
         	cancelButton3.setOnAction(actionEvent3 -> stage4.close());

	        HBox bottomRot3= new HBox();
                bottomRot3.setPadding(new Insets(10));
                bottomRot3.getChildren().addAll(cancelButton3, saveButton3);

                bp3.setCenter(rotField3);
                bp3.setAlignment(rotField3, Pos.CENTER);
                bp3.setBottom(bottomRot3);
                bp3.setAlignment(bottomRot3, Pos.CENTER);



                stage4.show();


		});



	stage.show();

	

	}
	catch(Exception e){
                Platform.exit();
        }
	} // createAndShowGUI

 
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
