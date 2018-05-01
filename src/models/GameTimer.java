package models;

import java.util.ArrayList;

/**
 * Az �temez�st seg�t� id�z�t�
 */
public class GameTimer extends ArrayList<Steppable> {
	
	public GameTimer() {

	}
	/**
	 * l�pteti a Steppable-eket
	 */
	public void Tick() {
		for(Steppable s : this) {
			s.Step();
		}
	}
	
	/**
	 * elindul
	 */
	public void Start() {
		
	}
}
