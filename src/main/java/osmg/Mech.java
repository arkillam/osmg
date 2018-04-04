package osmg;

import java.util.List;

import osmg.enums.ChassisEnum;
import osmg.enums.WeaponEnum;

/**
 * Represents a mech in the game.
 */

public class Mech {

private int armour = 0;

private ChassisEnum chassis = null;

private String description;

private int heatSinks = 0;

private String name;

private List<WeaponEnum> weapons = null;

/**
 * Creates an undefined mech.
 */
public Mech() {
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

public int getHeatSinks() {
	return heatSinks;
}

public String getName() {
	return name;
}

public List<WeaponEnum> getWeapons() {
	return weapons;
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

public void setHeatSinks(int heatSinks) {
	this.heatSinks = heatSinks;
}

public void setName(String name) {
	this.name = name;
}

public void setWeapons(List<WeaponEnum> weapons) {
	this.weapons = weapons;
}

}
