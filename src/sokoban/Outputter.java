package sokoban;

import java.util.HashMap;

public class Outputter extends  HashMap<Object, String>{
	private int tab;
	
	public Outputter() {
		tab = 0;
	}
	
	public void makeCall(Object obj) {
		System.out.println("");
		System.out.print("> ");
		for(int i = 0; i < tab; ++i)
			System.out.print("\t");
		System.out.print("--> ");
		if(obj == null)
			System.out.print("");
		else
			System.out.print(this.get(obj)+".");
		tab++;
	}
	
	public String getName(Object obj) {
		return this.getName(obj);
	}
	
	public void returnFromFunc(Object obj) {
		tab--;
		System.out.println("");
		System.out.print("< ");
		for(int i = 0; i < tab; ++i)
			System.out.print("\t");
		System.out.print("<-- ");
		if(obj == null)
			System.out.print("");
		else
			System.out.print(this.get(obj)+".");
	}
	
	public void callfunc(Object obj, String funcName) {
		makeCall(obj);
		System.out.print(funcName);
	}
	
	public void returnfunc(Object obj, String funcName) {
		returnFromFunc(obj);
		System.out.print(funcName);
	}
}
