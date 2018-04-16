package osmg.utilities;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import osmg.Mecha;
import osmg.enums.ChassisEnum;
import osmg.enums.WeaponEnum;

/**
 * This class creates the sample mechas Stuart Robertson published in this rule book, and writes them out to disk (they
 * serve as the game's sample mechas too).
 */

public class WriteOutExampleMechas {

/** path to the directory we want to wright examples to */
private static final String pathToExamples = "c:\\Files\\workspace\\osmg\\src\\main\\resources\\examples\\mechas\\";

public static void main(String[] args) {

	try {
		ObjectMapper mapper = new ObjectMapper();

		Mecha mecha = null;

		mecha = new Mecha();
		mecha.setDesignName("Hoplite Medium Fire Support Mecha");
		mecha.setChassis(ChassisEnum.B1_MEDIUM_ECONOMY);
		mecha.setArmour(50);
		mecha.setHeatSinks(20);
		mecha.setVtol(true);
		mecha.addWeapon(WeaponEnum.MISSILE_LARGE);
		mecha.addWeapon(WeaponEnum.MISSILE_LARGE);
		mapper.writeValue(new File(pathToExamples + "Hoplite.json"), mecha);
	} catch (Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	System.exit(0);
}

}
