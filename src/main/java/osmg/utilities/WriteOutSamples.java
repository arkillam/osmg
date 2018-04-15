package osmg.utilities;

import osmg.Mecha;
import osmg.enums.ChassisEnum;

/**
 * This class creates the sample mechas Stuart Robertson published in this rule book, and writes them out to disk (they
 * serve as the game's sample mechas too).
 */

public class WriteOutSamples {

public static void main(String[] args) {

	Mecha mecha = null;

	mecha = new Mecha();
	mecha.setChassis(ChassisEnum.B1_MEDIUM_ECONOMY);
	mecha.setArmour(50);
	mecha.setHeatSinks(20);
	mecha.setVtol(true);

}

}
