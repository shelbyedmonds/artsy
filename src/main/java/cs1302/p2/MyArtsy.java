package cs1302.p2;

import cs1302.effects.Artsy;
import javafx.scene.image.Image;
import java.lang.Math;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class MyArtsy implements Artsy {


/**This method creates a checkered output that takes pixels from
 * both images.
 *
 * @param src1 Image
 * @param src2 Image
 * @param size int
 * @return Image
 */
    @Override
    public Image doCheckers(Image src1, Image src2, int size) {
        int picWidth = (int) src1.getWidth();
        int picHeight = (int) src1.getHeight();

        Image image1 = doVerticalStripes(src1, src2, size);
        Image image2 = doVerticalStripes(src2, src1, size);
        return  doHorizontalStripes(image1, image2, size);
    } // doCheckers


/**This method creates an output with horizontal stripes taken from 
 * pixels of both images
 *
 * @param src1 Image
 * @param src2 Image
 * @param height int
 * @return Image
 */
    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int height) {
        int picWidth = (int) src1.getWidth();
        int picHeight = (int) src1.getHeight();
	
        WritableImage ret = new WritableImage(picWidth, picHeight);
        PixelReader src1Reader = src1.getPixelReader();
        PixelReader src2Reader = src2.getPixelReader();
        PixelWriter writer =ret.getPixelWriter();

        for (int y = 0; y < picHeight; y++ ) {
                for (int x = 0; x < picWidth; x++) {
                        if (((y / height) % 2) == 0) {
                                writer.setArgb(x, y, src1Reader.getArgb(x, y));
                        }
                        else {
                                writer.setArgb(x, y, src2Reader.getArgb(x, y));
                        }
                }
        }
        return  ret;
    } // doHorizontalStripes


/**This method creates an output that is a rotated form of the original image.
 *
 * @param src Image
 * @param degrees double
 * @return Image
 */	
	@Override
    public Image doRotate(Image src, double degrees) {
        int picWidth = (int) src.getWidth();
        int picHeight = (int) src.getHeight();

        WritableImage ret = new WritableImage(picWidth, picHeight);
        PixelReader reader = src.getPixelReader();
        PixelWriter writer = ret.getPixelWriter();
	PixelReader retReader = ret.getPixelReader();
        int xx;
        int yy;

        for (int x = 0; x < picWidth; x++) {
                for (int y = 0; y < picHeight; y++) {
                        xx = (int) (((x - (src.getWidth() / 2)) * Math.cos(Math.toRadians(degrees)) -
                                (y - (src.getHeight() / 2)) * Math.sin(Math.toRadians(degrees))) + (src.getWidth() / 2));
                        yy = (int) (((x - (src.getWidth() / 2)) * Math.sin(Math.toRadians(degrees)) +
                                (y - (src.getHeight() / 2)) * Math.cos(Math.toRadians(degrees))) + (src.getHeight() / 2));
                        if (xx < ret.getWidth() && yy < ret.getHeight() && xx>=0 && yy>=0) {
                                writer.setArgb(xx, yy, reader.getArgb(x, y));
                     	}
		}
        }
	for (int i = 0; i < 300; i++) {
		for (int j = 0; j < 300; j++) {
			if(retReader.getArgb(i, j) == 0) {
				writer.setColor(i, j, getColorAverage(ret, i, j));
				//writer.setArgb(i, j, getColorAverage(ret, i, j));
			}
		}
	}
        return  ret;


    } // doRotate
	
/**This method returns the color average for the surrounding pixels.
 *
 * @param ret WritableImage
 * @param i int
 * @param j int
 *
 * @return Color
 */
	public  Color getColorAverage(WritableImage ret, int i, int j) {
		int count = 0;
		int red=0;
		int green= 0;
		int blue= 0;
		PixelReader retReader = ret.getPixelReader();
		if((j-1)>=0){
			if ((i-1) >= 0) {
				red += retReader.getColor((i-1), (j-1)).getRed();
				green+= retReader.getColor((i-1), (j-1)).getGreen();
                                blue+=retReader.getColor((i-1), (j-1)).getBlue();
			//	red += retReader.getArgb((i-1), (j-1));

				count++;
			}
			if ((i+1) < 300) {
				red+=retReader.getColor((i+1), (j-1)).getRed();
                                green+= retReader.getColor((i+1), (j-1)).getGreen();
                                blue+=retReader.getColor((i+1), (j-1)).getBlue();
			//	red+=retReader.getArgb((i+1), (j-1));
				count++;	
			}
                	red+=retReader.getColor((i), (j-1)).getRed();
			green+= retReader.getColor((i), (j-1)).getGreen();
			blue+=retReader.getColor((i), (j-1)).getBlue(); 
		//	red+=retReader.getArgb((i), (j-1));
			count++;
                }
		if ((i-1) >= 0) {
			if ((j+1) < 300) {
				red+=retReader.getColor((i-1), (j+1)).getRed();
                                green+= retReader.getColor((i-1), (j+1)).getGreen();
                                blue+=retReader.getColor((i-1), (j+1)).getBlue();
		//		red+=retReader.getArgb((i-1), (j+1));
				count++;
			}
			red+=retReader.getColor((i-1), (j)).getRed();
                        green+= retReader.getColor((i-1), (j)).getGreen();
                        blue+=retReader.getColor((i-1), (j)).getBlue();
		//		red+=retReader.getArgb((i-1), (j));
				count++;
		}
		if ((i+1) < 300) {
			if ((j+1) < 300) {
				red+=retReader.getColor((i+1), (j+1)).getRed();
                                green+= retReader.getColor((i+1), (j+1)).getGreen();
                                blue+=retReader.getColor((i+1), (j+1)).getBlue();
			//	red+=retReader.getArgb((i+1), (j+1));	
				count++;
			}
			red+=retReader.getColor((i+1), (j)).getRed();
                        green+= retReader.getColor((i+1), (j)).getGreen();
                        blue+=retReader.getColor((i+1), (j)).getBlue();
		//		red+=retReader.getArgb((i+1), (j));
				count++;
		}
		if ((j+1) < 300) {
			red+=retReader.getColor((i), (j+1)).getRed();
                        green+= retReader.getColor((i), (j+1)).getGreen();
                        blue+=retReader.getColor((i), (j+1)).getBlue();
		//		red+=retReader.getArgb((i), (j+1));
				count++;
		}
		Color average = Color.rgb((red/count),(green/count), (blue/count));
		return average;
	}	
		

/**This method creates an output with vertical stripes made from pixels
 * of both images.
 *
 * @param src1 Image
 * @param src2 Image
 * @param width int
 * @return Image
 */
	@Override
    public Image doVerticalStripes(Image src1, Image src2, int width) {
        int picWidth = (int) src1.getWidth();
        int picHeight = (int) src1.getHeight();

        WritableImage ret = new WritableImage(picWidth, picHeight);
        PixelReader src1Reader = src1.getPixelReader();
        PixelReader src2Reader = src2.getPixelReader();
        PixelWriter writer = ret.getPixelWriter();

        for (int x = 0; x < picWidth; x++) {
                for (int y = 0; y < picHeight; y++) {
                        if (((x / width) % 2) == 0) {
                                writer.setArgb(x, y, src1Reader.getArgb(x, y));
                        }
                        else {
                                writer.setArgb(x, y, src2Reader.getArgb(x, y));
                        }
                }
        }
        return  ret;
    } // doVerticalStripes

} // MyArtsy
 // MyArtsy

