package osmg.factories;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import osmg.enums.ChassisSizeEnum;
import osmg.enums.DirectionEnum;

/**
 * Provides images of mechs as needed. The minimum required is a 32x32 north-facing mech image - the factory can expand
 * that to 64x64 and 128x128 images, and rotate to get the four directions. Optionally, 64x64 and 128x128 images with
 * more details can be provided in the resources folders.
 */

public class ImageFactory {

	/** caches images */
	private Map<String, Image> cachedImages = new HashMap<>();

	/**
	 * @param uniqueImageId
	 *            the image's unique id
	 * @param chassisSize
	 *            the chassis size
	 * @param imageSize
	 *            the image's size (32, 64, 128 etc pixels)
	 * @param facing
	 *            direction the mech is facing
	 * @return the requested image
	 */
	public final Image getImage(int uniqueImageId, ChassisSizeEnum chassisSize, int imageSize, DirectionEnum facing) {

		String imageKey = String.format("%s_%d_%d_%s", chassisSize.toString().toUpperCase(), imageSize, uniqueImageId,
				facing.toString().toUpperCase());

		if (cachedImages.containsKey(imageKey))
			return cachedImages.get(imageKey);
		
		... 

		return null;
	}

}
