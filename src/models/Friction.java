package models;

/**
 *	A s�rl�d�st reprezent�l� enumer�ci�
 */
public enum Friction {
	Oil(-2),
	Honey(7),
	Normal(2);
	
	/**
	 * A s�rl�d�s sz�mszer� �rt�ke
	 */
	private float value;
	private Friction(float friction) {
		value = friction;
	}
	
	public float getValue() {
		return value;
	}
}
