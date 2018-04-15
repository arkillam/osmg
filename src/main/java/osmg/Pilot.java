package osmg;

/**
 * A pilot; required to drive a mecha in combat. Skills start at 0 (neutral - neither good nor bad) and can be increased
 * for every 100 build points of mechas the pilot has destroyed in combat.
 */

public class Pilot {

/** aiming skill, affects attack rolls - 0 is neutral */
private int aimingSkill = 0;

/** destroyed build points - 100 of these can be exchanged for a +1 improvement for aiming or piloting */
private int destroyedBuildPoints = 0;

/** the pilot's name */
private String name;

/** pilot skill, affects piloting rolls - 0 is neutral */
private int pilotSkill = 0;

public int getAimingSkill() {
	return aimingSkill;
}

public int getDestroyedBuildPoints() {
	return destroyedBuildPoints;
}

public String getName() {
	return name;
}

public int getPilotSkill() {
	return pilotSkill;
}

public void setAimingSkill(int aimingSkill) {
	this.aimingSkill = aimingSkill;
}

public void setDestroyedBuildPoints(int destroyedBuildPoints) {
	this.destroyedBuildPoints = destroyedBuildPoints;
}

public void setName(String name) {
	this.name = name;
}

public void setPilotSkill(int pilotSkill) {
	this.pilotSkill = pilotSkill;
}



}
