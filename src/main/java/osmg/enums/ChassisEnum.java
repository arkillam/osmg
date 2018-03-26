package osmg.enums;

/**
 * The different types of chassis in the game. For a quick, easy approach, I have made all chasis values fields of these
 * enums. The lead letters are to ensure they sort lightest to heaviest. (Yes, this class is a hack of a job. :)
 */

@SuppressWarnings("unused")
public enum ChassisEnum {

	A1_LIGHT_ECONOMY("Light w/ Economy Engine", 10, 50, 1, true, 5, 8),
	A2_LIGHT("Light", 11, 50, 1, true, 6, 9),
	A3_LIGHT_UPGRADED("Light w/ Upgraded Engine", 12, 50, 1, true, 8, 12),
	B1_MEDIUM_ECONOMY("Medium w/ Economy Engine", 17, 75, 2, true, 4, 6),
	B2_MEDIUM("Medium", 18, 75, 2, true, 5, 8),
	B3_MEDIUM_UPGRADED("Medium w/ Upgraded Engine", 19, 75, 2, true, 6, 9),
	C1_HEAVY("Heavy", 25, 100, 3, false, 4, 6),
	C2_HEAVY_UPGRADED("Heavy w/ Upgraded Engine", 26, 100, 3, false, 5, 8),
	D1_SUPER_HEAVY("Super Heavy", 32, 120, 4, false, 3, 5),
	D2_SUPER_HEAVY_UPGRADED("Super Heavy w/ Upgraded Engine", 34, 120, 4, false, 5, 8);

	/** the build point cost for the chassis itself */
	private final int buildPoints;

	/**
	 * each allocated build point adds five points of armour; this is the max that can be added (armour points, not
	 * build points)
	 */
	private final int maxArmour;

	/** the chassis can have, at most, this many large weapons (plus all the small ones the player wants) */
	private final int maxLargeWeapons;

	private final String name;

	/** the maximum number of squares this chassis can run in one round */
	private final int runSpeed;

	/** if true, this chassis can fly via jets */
	private final boolean vtolCapable;

	/** the maximum number of squares this chassis can walk in one round */
	private final int walkSpeed;

	/**
	 * @param name
	 *            chassis name
	 * @param buildPoints
	 *            the build point cost for the chassis itself
	 * @param maxArmour
	 *            each allocated build point adds five points of armour; this is the max that can be added (armour
	 *            points, not build points)
	 * @param maxLargeWeapons
	 *            the chassis can have, at most, this many large weapons
	 * @param vtolCapable
	 *            if true, this chassis can fly via jets
	 * @param walkSpeed
	 *            the maximum number of squares this chassis can walk in one round
	 * @param runSpeed
	 *            the maximum number of squares this chassis can run in one round
	 */
	private ChassisEnum(String name, int buildPoints, int maxArmour, int maxLargeWeapons, boolean vtolCapable,
			int walkSpeed, int runSpeed) {
		this.name = name;
		this.buildPoints = buildPoints;
		this.maxArmour = maxArmour;
		this.maxLargeWeapons = maxLargeWeapons;
		this.vtolCapable = vtolCapable;
		this.walkSpeed = walkSpeed;
		this.runSpeed = runSpeed;
	}

	public int getBuildPoints() {
		return buildPoints;
	}

	public int getMaxArmour() {
		return maxArmour;
	}

	public int getMaxLargeWeapons() {
		return maxLargeWeapons;
	}

	private String getName() {
		return name;
	}

	public int getRunSpeed() {
		return runSpeed;
	}

	public int getWalkSpeed() {
		return walkSpeed;
	}

	public boolean isVtolCapable() {
		return vtolCapable;
	}
}
