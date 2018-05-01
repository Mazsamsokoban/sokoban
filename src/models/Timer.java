package models;

import java.util.ArrayList;

/**
 * Az ütemezést segítõ idõzítõ
 */
public class Timer extends ArrayList<Steppable> {
	
	public Timer() {

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
