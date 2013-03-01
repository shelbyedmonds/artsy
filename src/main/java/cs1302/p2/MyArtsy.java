package cs1302.p2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import cs1302.effects.Artsy;

public class MyArtsy implements Artsy {

    @Override
    public BufferedImage doCheckers(BufferedImage src1, BufferedImage src2, int size) {
	return null;
    } // doCheckers

    @Override
    public BufferedImage doHorizontalStripes(BufferedImage src1, BufferedImage src2, int height) {
	return null;
    } // doHorizontalStripes

    @Override
    public BufferedImage doRotate(BufferedImage src, double degrees) {
	return null;
    } // doRotate

    @Override
    public BufferedImage doVerticalStripes(BufferedImage src1, BufferedImage src2, int width) {
	return null;
    } // doVerticalStripes

    @Override
    public Dimension getMinDimension(BufferedImage src1, BufferedImage src2) {
	return null;
    } // getMinDimension

} // MyArtsy


