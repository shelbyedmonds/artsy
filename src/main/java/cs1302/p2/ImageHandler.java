javafx.scene.image.Image; 
javafx.scene.image.WritableImage; 
javafx.scene.image.PixelReader;
javafx.scene.image.PixelWriter;
javax.imageio.ImageIO;
javafx.embed.swing.SwingFXUtils;
java.awt.image.BufferedImage;
java.io.File;



public class ImageHandler{
	public Image myImage;

	public ImageHandler(InputStream src ){
		myImage= new Image(src);
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

		File file = new File("image.png");
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		ImageIO.write(bImage, "png", file);

	}//saveImage

	

	


}//imageHandler
