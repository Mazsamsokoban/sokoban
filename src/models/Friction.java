package models;

/**
 *	A súrlódást reprezentáló enumeráció
 */
public enum Friction {
	Oil(-2),
	Honey(7),
	Normal(2);
	
	/**
	 * A súrlódás számszerû értéke
	 */
	private float value;
	private Friction(float friction) {
		value = friction;
	}
	
	public float getValue() {
		return value;
	}
}
