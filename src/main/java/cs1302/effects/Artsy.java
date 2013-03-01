package cs1302.effects;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 * This interface describes artsy effects that can be applied to BufferedImages.
 */
public interface Artsy {

	/**
	 * Given two BufferedImages, this method returns a new BufferedImage, the contents of which
	 * is composed of the source images alternating horizontally and vertically at the specified 
	 * size, in pixels. This causes the images to appear woven together in a checkered fashion. 
	 * For an example, please see the reference provided in the see also section of this comment.
	 * 
	 * @see http://tinyurl.com/amlo7w7
	 * @param src1 the first BufferedImage
	 * @param src2 the second BufferedImage
	 * @param height the height, in pixels, of the horizontal stripes.
	 * @return a BufferedImage with the horizontal stripes effect
	 */
	public BufferedImage doCheckers(BufferedImage src1, BufferedImage src2, int size);
	
	/**
	 * Given two BufferedImages, this method returns a new BufferedImage, the contents of which
	 * is composed of the source images alternating horizontally at the specified pixel height. 
	 * For an example, please see the reference provided in the see also section of this comment.
	 * 
	 * @see http://tinyurl.com/ahejkbx
	 * @param src1 the first BufferedImage
	 * @param src2 the second BufferedImage
	 * @param height the height, in pixels, of the horizontal stripes.
	 * @return a BufferedImage with the horizontal stripes effect
	 */
	public BufferedImage doHorizontalStripes(BufferedImage src1, BufferedImage src2, int height);
	
	/**
	 * Given two BufferedImages, this method returns a new BufferedImage, the contents of which
	 * is composed of the source images alternating vertically at the specified pixel width. For
	 * an example, please see the reference provided in the see also section of this comment.
	 * 
	 * @see http://tinyurl.com/asvzut9
	 * @param src1 the first BufferedImage
	 * @param src2 the second BufferedImage
	 * @param width the width, in pixels, of the vertical stripes.
	 * @return a BufferedImage with the vertical stripes effect
	 */
	public BufferedImage doVerticalStripes(BufferedImage src1, BufferedImage src2, int width);
	
	/**
	 * Given a BufferedImage, this method returns a new BufferedImage which contains
	 * the source image rotated clockwise by a certain number of degrees. The image
	 * should be rotated about the center of the image.
	 * 
	 * @param src     the source BufferedImage
	 * @param degrees the degrees to rotate the image, in degrees (not radians)
	 * @return a new BufferedImage containing a rotated version of the source image
	 */
	public BufferedImage doRotate(BufferedImage src, double degrees);
	
	/**
	 * Given two BufferedImages, this method returns a java.awt.Dimension object
	 * where the width is set to the minimum of the two width and the height is
	 * set to the minimum of the two heights.
	 * 
	 * @param src1 a BufferedImage
	 * @param src2 a BufferedImage
	 * @return a Dimension object containing the minimum width and height.
	 */
	public Dimension getMinDimension(BufferedImage src1, BufferedImage src2);

} // Artsy
