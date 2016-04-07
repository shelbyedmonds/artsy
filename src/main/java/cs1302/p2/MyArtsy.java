package cs1302.p2;

import cs1302.effects.Artsy;
import javafx.scene.image.Image;
import java.lang.Math;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class MyArtsy implements Artsy {

    @Override
    public Image doCheckers(Image src1, Image src2, int size) {
        int picWidth = (int) src1.getWidth();
        int picHeight = (int) src1.getHeight();

        Image image1 = doVerticalStripes(src1, src2, size);
        Image image2 = doVerticalStripes(src2, src1, size);
        return (Image) doHorizontalStripes(image1, image2, size);
    } // doCheckers

    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int height) {
        int picWidth = (int) src1.getWidth();
        int picHeight = (int) src1.getHeight();

        WritableImage ret = new WritableImage(picWidth, picHeight);
        PixelReader src1Reader = src1.getPixelReader();
        PixelReader src2Reader = src2.getPixelReader();
        PixelWriter writer = ret.getPixelWriter();

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
        return (Image) ret;
    } // doHorizontalStripes
	
	@Override
    public Image doRotate(Image src, double degrees) {
        int picWidth = (int) src.getWidth();
        int picHeight = (int) src.getHeight();

        WritableImage ret = new WritableImage(picWidth, picHeight);
        PixelReader reader = src.getPixelReader();
        PixelWriter writer = ret.getPixelWriter();

        int xx;
        int yy;

        for (int x = 0; x < picWidth; x++) {
                for (int y = 0; y < picHeight; y++) {
                        xx = (int) (((x - (src.getWidth() / 2)) * Math.cos(Math.toRadians(degrees)) -
                                (y - (src.getHeight() / 2)) * Math.sin(Math.toRadians(degrees))) + (src.getWidth() / 2));
                        yy = (int) (((x - (src.getWidth() / 2)) * Math.sin(Math.toRadians(degrees)) +
                                (y - (src.getHeight() / 2)) * Math.cos(Math.toRadians(degrees))) + (src.getHeight() / 2));
                        if (xx < ret.getWidth() && yy < ret.getHeight()) {
                                writer.setArgb(xx, yy, reader.getArgb(x, y));
                        }
                }
        }
        return (Image) ret;


    } // doRotate
	
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
        return (Image) ret;
    } // doVerticalStripes

} // MyArtsy
 // MyArtsy

