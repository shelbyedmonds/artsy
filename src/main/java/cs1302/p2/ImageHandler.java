package cs1302.p2;

import javafx.scene.image.Image; 
import javafx.scene.image.WritableImage; 
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


public class ImageHandler{
	public Image myImage;

	public ImageHandler(InputStream src ){
		myImage= new Image(src, 300, 300, false, false);
	}

	public Image copyImage(Image src) {

    	int width = (int) src.getWidth();
    	int height = (int) src.getHeight();

    	WritableImage ret = new WritableImage(width, height);
    	PixelReader pr = src.getPixelReader();
    	PixelWriter pw = ret.getPixelWriter();

    	for (int x = 0; x < width; ++x) {
        	for (int y = 0; y < height; ++y) {
            		pw.setArgb(x, y, pr.getArgb(x, y));
       		 } // for
   	 } // for

    	return ret;

	} // copyImage

	public Image saveImage(Image image){

		File file = new File("MyArtProject.png");
		try{
			BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
			ImageIO.write(bImage, "png", file);
		}
		catch(Exception e){
			System.exit(0);
		}	
	return image;
	}//saveImage

	

	


}//imageHandler
