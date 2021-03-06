
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
import java.io.File;
import javafx.scene.image.WritableImage;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import java.lang.Object;
import java.awt.image.BufferedImage;
import java.lang.IllegalArgumentException;
	
public class Driver extends Application {

	public static ImageView pic1;
	public static ImageView pic2;
    	public static ImageView pic3;
	public static ImageHandler img1;
	public static ImageHandler img2;
	public static ImageHandler img3;
	public static ImageHandler X;
	public static ImageHandler Y;
	@Override
    
/**This method is the body of the photo editor program, it sets up the stage and calls 
 * different methods to make parts of the stage functional.
 *
 *
 * @param stage Stage 
 * @return void
 */

	public void start(Stage stage) throws Exception {
	
	try{
	MyArtsy ArtObj= new MyArtsy();
        InputStream is1 = new FileInputStream("/home/ugrads/edmonds/artsy/resources/default.png");
        InputStream is2= new FileInputStream("/home/ugrads/edmonds/artsy/resources/default.png");
        InputStream is3= new FileInputStream("/home/ugrads/edmonds/artsy/resources/default.png");
	img1= new ImageHandler(is1);
        img2= new ImageHandler(is2);
	img3= new ImageHandler(is3);	

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
	saveItem.setOnAction(actionEvent -> {
		Image image= pic3.getImage();
		FileChooser fileFinder= new FileChooser();
		fileFinder.setTitle("Save Image As");
		//fileFinder.showSaveDialog(stage)
		//File file= fileFinder.showSaveDialog(stage);
		File file = new File(fileFinder.showSaveDialog(stage) +".png");
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		try{
		ImageIO.write(bImage, "png", file);	
		}
		catch(Exception e){
			System.out.println("unable to save image!");
		}


		});
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
        t.setText("Image 1");
        pic1= new ImageView(img1.myImage);
        left.getChildren().addAll(t, pic1, rotate, reset);

        VBox middle= new VBox(5);
        Text t1= new Text();
        t1.setText("Image 2");
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
                        fileFinder1.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png","*.bmp", "*.jpg", "*.gif"));
                        try{
                        InputStream newStream= new FileInputStream(fileFinder1.showOpenDialog(stage));
                        X= new ImageHandler(newStream);
                        pic1= new ImageView(X.myImage);
                        left.getChildren().clear();
			left.getChildren().addAll(t, pic1, rotate, reset);
                        bottomHalf.getChildren().addAll(left, middle, right);
        		root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
			stage.show();		
			}
                        catch(Exception e){
                        }
        });

	 picItem2.setOnAction(actionEvent -> {
                        FileChooser fileFinder2= new FileChooser();
                        fileFinder2.setTitle("Open Image 1");
                        fileFinder2.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.bmp" ,"*.png", "*.jpg", "*.gif"));
                        try{
                        InputStream newStream2= new FileInputStream(fileFinder2.showOpenDialog(stage));
                        Y= new ImageHandler(newStream2);
			pic2= new ImageView(Y.myImage);
                        middle.getChildren().clear();
                        middle.getChildren().addAll(t1, pic2, rotate1, reset1);
                        bottomHalf.getChildren().addAll(left, middle, right);
                        root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                        stage.show();


			}
                        catch(Exception e){
                        }
        });

	checkers.setOnAction(actionEvent -> {
		root.getChildren();
		stage.show();
	
		BorderPane pane= new BorderPane();
                Stage stageCheck= new Stage();
                Scene sceneCheck= new Scene(pane, 200, 200);

                stageCheck.setScene(sceneCheck);
                stageCheck.setTitle("Checkers Options");
                Label optLabel= new Label ("Please enter the desired checker width, in pixels.");
                pane.setTop(optLabel);
                pane.setAlignment(optLabel, Pos.CENTER);
                TextField checkField= new TextField("10");
                Button cancelButton= new Button("Cancel");
                cancelButton.setLayoutX(161);
                cancelButton.setLayoutY(80);
                cancelButton.setOnAction(actionEvent2 -> stageCheck.close());
                Button okButton= new Button("Ok");
                okButton.setLayoutX(161);
                okButton.setLayoutY(80);

		HBox bottom= new HBox();
                bottom.setPadding(new Insets(10));
                bottom.getChildren().addAll(cancelButton, okButton);

                pane.setCenter(checkField);
                pane.setAlignment(checkField, Pos.CENTER);
                pane.setBottom(bottom);
                pane.setAlignment(bottom, Pos.CENTER);


                stageCheck.show();


                okButton.setOnAction(actionEvent3 -> {
			try{
		        Integer pix = Integer.parseInt(checkField.getText());
			
			if(pix<=0 || pix>300)
				throw new Exception();
			stageCheck.close();
                        Image newImg= ArtObj.doCheckers(pic1.getImage(), pic2.getImage(), pix);
                        pic3= new ImageView(newImg);
			right.getChildren().clear();
                        right.getChildren().addAll(t3, pic3, rotate2, reset2);
                        bottomHalf.getChildren().clear();
			bottomHalf.getChildren().addAll(left, middle, right);
			root.getChildren().clear();
                        root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                        stage.show();
			}
			catch(Exception e){
			optLabel.setText("Invalid input, try again.");
                        pane.setTop(optLabel);
                        stageCheck.show();		

			}
                        });

	});

	horzStripes.setOnAction(actionEvent -> {
                root.getChildren();
                stage.show();

		BorderPane pane= new BorderPane();
                Stage stageHorz= new Stage();
                Scene sceneHorz= new Scene(pane, 200, 200);

                stageHorz.setScene(sceneHorz);
                stageHorz.setTitle("Horizontal Stripes Options");
                Label optLabel= new Label ("Please enter the desired stripe height, in pixels.");
                pane.setTop(optLabel);
                pane.setAlignment(optLabel, Pos.CENTER);
                TextField horzField= new TextField("10");
                Button cancelButton= new Button("Cancel");
                cancelButton.setLayoutX(161);
                cancelButton.setLayoutY(80);
                cancelButton.setOnAction(actionEvent2 -> stageHorz.close());
                Button okButton= new Button("Ok");
                okButton.setLayoutX(161);
                okButton.setLayoutY(80);
                
		HBox bottom= new HBox();
                bottom.setPadding(new Insets(10));
                bottom.getChildren().addAll(cancelButton, okButton);

                pane.setCenter(horzField);
                pane.setAlignment(horzField, Pos.CENTER);
                pane.setBottom(bottom);
                pane.setAlignment(bottom, Pos.CENTER);


                stageHorz.show();


		okButton.setOnAction(actionEvent3 -> {
			try{
                        Integer pix = Integer.parseInt(horzField.getText());
                        if(pix<=0 ||pix>300)
				throw new Exception();

                        stageHorz.close();
                        Image newImg= ArtObj.doHorizontalStripes(pic1.getImage(), pic2.getImage(), pix);
                        pic3= new ImageView(newImg);
                        right.getChildren().clear();
                        right.getChildren().addAll(t3, pic3, rotate2, reset2);
                        bottomHalf.getChildren().clear();
                        bottomHalf.getChildren().addAll(left, middle, right);
                        root.getChildren().clear();
                        root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                        stage.show();
			}
			catch(Exception e){
			optLabel.setText("Invalid input, try again.");
			pane.setTop(optLabel);
                        stageHorz.show();
                        }
		});


                });

	vertStripes.setOnAction(actionEvent -> {
                root.getChildren();
                stage.show();

		BorderPane pane= new BorderPane();
		Stage stageVert= new Stage();
		Scene sceneVert= new Scene(pane, 200, 200);

		stageVert.setScene(sceneVert);
		stageVert.setTitle("Vertical Stripes Options");
		Label optLabel= new Label ("Please enter the desired stripe width, in pixels.");
		pane.setTop(optLabel);
		pane.setAlignment(optLabel, Pos.CENTER);
		TextField vertField= new TextField("10");
		Button cancelButton= new Button("Cancel");
		cancelButton.setLayoutX(161);
		cancelButton.setLayoutY(80);
		cancelButton.setOnAction(actionEvent2 -> stageVert.close());
		Button okButton= new Button("Ok");
		okButton.setLayoutX(161);
		okButton.setLayoutY(80);

		HBox bottom= new HBox();
                bottom.setPadding(new Insets(10));
                bottom.getChildren().addAll(cancelButton, okButton);

                pane.setCenter(vertField);
                pane.setAlignment(vertField, Pos.CENTER);
                pane.setBottom(bottom);
                pane.setAlignment(bottom, Pos.CENTER);


                stageVert.show();

		okButton.setOnAction(actionEvent3 -> {
		


			try{	
			Integer pix = Integer.parseInt(vertField.getText());
                        if(pix<=0 || pix>300)
				throw new Exception(); 
			
			stageVert.close();
                        Image newImg= ArtObj.doVerticalStripes(pic1.getImage(), pic2.getImage(), pix);
                        pic3.setImage(newImg);
                        right.getChildren().clear();
                        right.getChildren().addAll(t3, pic3, rotate2, reset2);
                        bottomHalf.getChildren().clear();
                        bottomHalf.getChildren().addAll(left, middle, right);
                        root.getChildren().clear();
                        root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                        stage.show();

			}
			catch(Exception e){
				optLabel.setText("Invalid input, try again.");
				pane.setTop(optLabel);
				stageVert.show();	
			}
			});	



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


		
		Button cancelButton= new Button ("Cancel");
		cancelButton.setLayoutX(161);
        	cancelButton.setLayoutY(80);
		
		HBox bottomRot= new HBox();
		bottomRot.setPadding(new Insets(10));
		bottomRot.getChildren().addAll(cancelButton, saveButton);
	
		bp.setCenter(rotField);
		bp.setAlignment(rotField, Pos.CENTER);
		bp.setBottom(bottomRot);
		bp.setAlignment(bottomRot, Pos.CENTER);
		
			
		stage2.show();	

		cancelButton.setOnAction(actionEvent3 -> stage2.close());

			
		saveButton.setOnAction(actionEvent2 -> {
			try {
				Double degrees1 = Double.parseDouble(rotField.getText());
				Image imgX= ArtObj.doRotate(pic1.getImage(), degrees1);
                	        stage2.close();

                	        ImageView newPic = new ImageView(imgX);
                	        left.getChildren().clear();
				pic1.setImage(newPic.getImage());
                	        left.getChildren().addAll(t, pic1, rotate, reset);
                	        bottomHalf.getChildren().clear();
                	        bottomHalf.getChildren().addAll(left, middle, right);
                	        root.getChildren().clear();
                	        root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                	        stage.show();

			}
			catch (Exception e) {
				boxLabel.setText("Invalid Input. Try again.");
				bp.setTop(boxLabel);
				stage2.show();
			}
		});	


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


                

			
		saveButton2.setOnAction(actionEvent2 -> {
			try {
				Double degrees1 = Double.parseDouble(rotField2.getText());
				Image imgX= ArtObj.doRotate(pic2.getImage(), degrees1);
                	        stage3.close();

                	        ImageView newPic = new ImageView(imgX);
                	        middle.getChildren().clear();
				pic2.setImage(newPic.getImage());
                	        middle.getChildren().addAll(t1, pic2, rotate1, reset1);
                	        bottomHalf.getChildren().clear();
                	        bottomHalf.getChildren().addAll(left, middle, right);
                	        root.getChildren().clear();
                	        root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                	        stage.show();

			}
			catch (Exception e) {
				boxLabel2.setText("Invalid Input. Try again.");
				bp2.setTop(boxLabel2);
				stage3.show();
			}
		});	

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


                

		
		saveButton3.setOnAction(actionEvent2 -> {
                        try {
                                Double degrees1 = Double.parseDouble(rotField3.getText());
                                Image imgX= ArtObj.doRotate(pic3.getImage(), degrees1);
                                stage4.close();

                                ImageView newPic = new ImageView(imgX);
                                right.getChildren().clear();
				pic3.setImage(newPic.getImage());
                                right.getChildren().addAll(t3, pic3, rotate2, reset2);
                                bottomHalf.getChildren().clear();
                                bottomHalf.getChildren().addAll(left, middle, right);
                                root.getChildren().clear();
                                root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                                stage.show();

                        }
                        catch (Exception e) {
                                boxLabel3.setText("Invalid Input. Try again.");
                                bp3.setTop(boxLabel3);
                                stage4.show();
                        }
                });
	});

	reset.setOnAction(actionEvent -> {
		pic1=new ImageView (X.myImage);
		left.getChildren().clear();
                left.getChildren().addAll(t, pic1, rotate, reset);
                bottomHalf.getChildren().clear();
                bottomHalf.getChildren().addAll(left, middle, right);
                root.getChildren().clear();
                root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                stage.show();
		


		});

	reset1.setOnAction(actionEvent -> {
		pic2=new ImageView (Y.myImage);
		middle.getChildren().clear();
                middle.getChildren().addAll(t1, pic2, rotate1, reset1);
                bottomHalf.getChildren().clear();
                bottomHalf.getChildren().addAll(left, middle, right);
                root.getChildren().clear();
                root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                stage.show();


		});



	reset2.setOnAction(actionEvent -> {
	
		//img3= new ImageHandler(is3);
		pic3=new ImageView (img3.myImage);
		right.getChildren().clear();
                right.getChildren().addAll(t3, pic3, rotate2, reset2);
                bottomHalf.getChildren().clear();
                bottomHalf.getChildren().addAll(left, middle, right);
                root.getChildren().clear();
                root.getChildren().addAll(myMenu, buttonBox, bottomHalf);
                stage.show();



		});

	stage.show();

	

	}
	catch(Exception e){
                Platform.exit();
        }
	} // createAndShowGUI

/**This is the main method of the program that launches the program.
 *
 * @param args String []
 * @return void
 */	
public static void main(String[] args) {
        launch(args);
    } // main

} // Driver










