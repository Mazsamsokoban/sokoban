package sokoban;

import java.util.ArrayList;

public class Timer extends ArrayList<Steppable> {
	
	public Timer() {

	}
	//l�pteti a Steppable-eket
	public void Tick() {
		for(Steppable s : this) {
			s.Step();
		}
	}
	
	//elindul
	public void Start() {
		
	}
}
