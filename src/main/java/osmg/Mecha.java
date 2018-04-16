package osmg;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import osmg.enums.ChassisEnum;
import osmg.enums.WeaponEnum;

/**
 * Represents a mecha in the game.
 */

public class Mecha {

private int armour = 0;

private ChassisEnum chassis = null;

/** a description of the design (e.g. "A lightweight design designed for long-range support.") */
private String description;

/** the name of the mecha design (e.g. "Sprinter Light Mecha") */
private String designName;

private int heatSinks = 0;

/** mecha images are identified by their chassis and a unique value; this is the unique value */
private int imageId;

/** the name of the individual mecha NOT its design (something like "Red One", not "Sprinter Light Mecha") */
private String name;

/** if true, has VTOL - can jump short distances */
private boolean vtol = false;

private List<WeaponEnum> weapons = null;

/**
 * Creates an undefined mecha.
 */
public Mecha() {
}

/**
 * Adds a weapon to the mecha;
 * 
 * @param weapon
 *            the weapon to add
 */
public void addWeapon(WeaponEnum weapon) {
	if (chassis == null)
		throw new RuntimeException("cannot add weapons before specifying a chassis");

	Objects.requireNonNull(weapon);

	if (weapons == null)
		weapons = new ArrayList<>();

	// make sure the large weapon limit has not been passed
	if (weapons.size() > 0) {
		long largeCount = weapons.stream().filter(w -> w.isLarge()).count();
		if (largeCount >= chassis.getMaxLargeWeapons())
			throw new RuntimeException("cannot add another large weapon to this chassis");
	}

	weapons.add(weapon);
}

public int getArmour() {
	return armour;
}

public ChassisEnum getChassis() {
	return chassis;
}

public String getDescription() {
	return description;
}

public String getDesignName() {
	return designName;
}

public int getHeatSinks() {
	return heatSinks;
}

public int getImageId() {
	return imageId;
}

public String getName() {
	return name;
}

public List<WeaponEnum> getWeapons() {
	return weapons;
}

public boolean isVtol() {
	return vtol;
}

public void setArmour(int armour) {
	this.armour = armour;
}

public void setChassis(ChassisEnum chassis) {
	this.chassis = chassis;
}

public void setDescription(String description) {
	this.description = description;
}

public void setDesignName(String designName) {
	this.designName = designName;
}

public void setHeatSinks(int heatSinks) {
	this.heatSinks = heatSinks;
}

public void setImageId(int imageId) {
	this.imageId = imageId;
}

public void setName(String name) {
	this.name = name;
}

public void setVtol(boolean vtol) {
	this.vtol = vtol;
}

public void setWeapons(List<WeaponEnum> weapons) {
	this.weapons = weapons;
}

}
