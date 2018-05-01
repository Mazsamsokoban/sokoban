package models;

import java.util.ArrayList;

/**
 * Az ütemezést segítõ idõzítõ
 */
public class GameTimer extends ArrayList<Steppable> {
	
	public GameTimer() {

	}
	/**
	 * lépteti a Steppable-eket
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
