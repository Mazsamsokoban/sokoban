package sokoban;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class Game {
	//private ArrayList<Maze> maze;+
	public Tester tester;
	private Maze currentLevel;
	static Outputter op = new Outputter();
	
	
	public Game() {
	}
	
	//elkezdi a játékot, létrehozza a raktárépületet
	public void startGame() {
		currentLevel = new Maze();
		currentLevel.tester = tester;
		currentLevel.setGame(this);
		op.put(currentLevel, "m");
		tester.m = currentLevel;
		currentLevel.init();
		op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
	}
	
	//befejezi a játékot, ha a feltételek teljesülnek
	public void endGame() {
	}
	
	//menürendszer kiírása és választás kezelése
	public static void main(String[] args) throws IOException {
		/*Switch sw = new Switch("sw");
		Box box0 = new Box("box0");
		Box box1 = new Box("box1");
		Worker w1 = new Worker("w1");
		w1.d = Direction.Right;
		box0.d = Direction.Right;
		box1.d = Direction.Up;
		SwitchableHole sh = new SwitchableHole("sh");
		sw.SetSh(sh);
		Field f1 = new Field("f1");
		Field f2 = new Field("f2");
		Field f3 = new Field("f3");
		sw.setNeighbor(Direction.Down, f1);
		sw.setNeighbor(Direction.Up, f2);
		sw.setNeighbor(Direction.Left, f3);
		sw.setNeighbor(Direction.Right, sh);
		sw.thing = w1;
		f1.thing = box1;
		sw.setFriction(Friction.Honey);
		w1.setField(sw);
		
		box0.field = sh;
		box1.field = f1;
		sh.thing = box0;
		
		
		box0.printState(System.out);
		
		System.out.println("\n\n");
		try {
		File file = new File("state.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Worker.class, Box.class, Switch.class, Field.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//jaxbMarshaller.marshal(sw, file);
		jaxbMarshaller.marshal(w1, System.out);
		System.out.println("\n");
		jaxbMarshaller.marshal(box0, System.out);
		System.out.println("\n");
		jaxbMarshaller.marshal(sh, System.out);
		System.out.println("\n");
		jaxbMarshaller.marshal(sw, System.out);
		System.out.println("\n");
		jaxbMarshaller.marshal(f1, System.out);
		

	     } catch (JAXBException e) {
	    	  e.printStackTrace();
	     }*/
		
		
		
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String command ;
		
		
		System.out.println("KILLER SOKOBAN játék" + 
						"\nMazsam csapat"
		);
		
		
		Tester tester = new Tester();
		Game game = new Game();
		game.tester = tester;
	
		
		System.out.println("\n\nA menübe való továbblépéshez nyomjon ENTER-t!\n");
		br.readLine();
		
		
		while(true) {
			System.out.println("Adjon meg egy parancsot!");
			
			command = br.readLine();
			
			tester.processCommand(command);
		}
	}
}
