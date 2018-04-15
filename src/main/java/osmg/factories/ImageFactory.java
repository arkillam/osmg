package osmg.factories;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;

import osmg.enums.ChassisSizeEnum;
import osmg.enums.DirectionEnum;

/**
 * Provides images of mechas as needed. The minimum required is a 32x32 north-facing mecha image - the factory can
 * expand that to 64x64 and 128x128 images, and rotate to get the four directions. Optionally, 64x64 and 128x128 images
 * with more details can be provided in the resources folders.
 */

public class ImageFactory {

/** caches images */
private Map<String, BufferedImage> cachedImages = new HashMap<>();

/**
 * @param uniqueImageId
 *            the image's unique id
 * @param chassisSize
 *            the chassis size
 * @param imageSize
 *            the image's size (32, 64, 128 etc pixels)
 * @param facing
 *            direction the mecha is facing
 * @return the standard image key for this set of values
 */
private String createImageKey(int uniqueImageId, ChassisSizeEnum chassisSize, int imageSize, DirectionEnum facing) {
	return String.format("%s_%d_%d_%s", chassisSize.toString().toUpperCase(), imageSize, uniqueImageId,
			facing.toString().toUpperCase());
}

/**
 * @param uniqueImageId
 *            the image's unique id
 * @param chassisSize
 *            the chassis size
 * @param imageSize
 *            the image's size (32, 64, 128 etc pixels)
 * @param facing
 *            direction the mecha is facing
 * @return the requested image
 */
public BufferedImage getImage(int uniqueImageId, ChassisSizeEnum chassisSize, int imageSize, DirectionEnum facing) {

	String imageKey = createImageKey(uniqueImageId, chassisSize, imageSize, facing);

	if (cachedImages.containsKey(imageKey))
		return cachedImages.get(imageKey);

	BufferedImage image = null;

	// can we load this image from disk?
	image = loadImage(imageKey + ".png", false);
	if (image != null) {
		cachedImages.put(imageKey, image);
		return image;
	}

	// can we get the north-facing image and rotate it?
	String ik = createImageKey(uniqueImageId, chassisSize, imageSize, DirectionEnum.NORTH);
	image = loadImage(ik + ".png", false);
	if (image != null) {
		if (facing == DirectionEnum.EAST)
			image = rotate(image, 90.0d);
		else if (facing == DirectionEnum.SOUTH)
			image = rotate(image, 180.0d);
		else
			image = rotate(image, 270.0d);

		cachedImages.put(imageKey, image);
		return image;
	}

	// can we get the half-sized image and double its size? (every image should have a 32x32 north-facing version at
	// least)
	image = getImage(uniqueImageId, chassisSize, imageSize / 2, facing);
	if (image != null) {
		image.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
		cachedImages.put(imageKey, image);
		return image;
	}

	System.out.println(String.format("Failed to load or create an image for %s", imageKey));

	return null;
}

/**
 * Loads a specified image from our resources. This should be wrapped in some kind of caching mechanism.
 * 
 * @param path
 *            the full path to the resource
 * @param makeTransparent
 *            if true, the image's background is made transparent (assumes the top left corner is part of the
 *            background)
 */

private BufferedImage loadImage(String name, boolean makeTransparent) {
	try {
		Objects.requireNonNull(name);
		URL url = this.getClass().getResource("/images/" + name);
		if (url == null)
			return null;

		BufferedImage image = ImageIO.read(url);

		if (makeTransparent) {
			int color = image.getRGB(image.getWidth() - 1, 0);
			image = makeColorTransparent(image, new Color(color));
		}

		return image;

	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

/** caches image filters */
private Map<Color, ImageFilter> cachedFilters = new HashMap<>();

/**
 * Makes a specified color transparent in the submitted image.
 * 
 * @param image
 *            the image to modify
 * @param color
 *            the colour to make transparent
 * 
 * @return the image, with a transparent colour
 */

private BufferedImage makeColorTransparent(BufferedImage image, final Color color) {

	if (!cachedFilters.containsKey(color)) {
		cachedFilters.put(color, new RGBImageFilter() {
		// the color we are looking for... Alpha bits are set to opaque
		public int markerRGB = color.getRGB() | 0xFF000000;

		public final int filterRGB(int x, int y, int rgb) {
			if ((rgb | 0xFF000000) == markerRGB) {
				// Mark the alpha bits as zero - transparent
				return 0x00FFFFFF & rgb;
			} else {
				// nothing to do
				return rgb;
			}
		}
		});
	}

	ImageFilter filter = cachedFilters.get(color);

	ImageProducer ip = new FilteredImageSource(image.getSource(), filter);

	Image tmp = Toolkit.getDefaultToolkit().createImage(ip);

	// only create a new image if necessary
	if (image.getType() == BufferedImage.TYPE_INT_ARGB) {
		image.createGraphics().drawImage(tmp, 0, 0, null);
		return image;
	} else {
		BufferedImage i = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		i.createGraphics().drawImage(tmp, 0, 0, null);
		return i;
	}
}

/**
 * Returns a rotated copy of the image (the original is unchanged).
 * 
 * @param image
 *            the image to rotate
 * @param angle
 *            the angle (in degrees)
 * @return the new rotated image
 */
private BufferedImage rotate(BufferedImage image, double angle) {

	double sin = Math.abs(Math.sin(Math.toRadians(angle))), cos = Math.abs(Math.cos(Math.toRadians(angle)));

	int currentWidth = image.getWidth(null);
	int currentHeight = image.getHeight(null);

	int newWidth = (int) Math.floor(currentWidth * cos + currentHeight * sin);
	int newHeight = (int) Math.floor(currentHeight * cos + currentWidth * sin);

	BufferedImage rc = new BufferedImage(newWidth, newHeight, image.getType());
	Graphics2D g2d = rc.createGraphics();

	g2d.translate((newWidth - currentWidth) / 2, (newHeight - currentHeight) / 2);
	g2d.rotate(Math.toRadians(angle), currentWidth / 2, currentHeight / 2);
	g2d.drawRenderedImage(image, null);
	g2d.dispose();

	return rc;
}

}
