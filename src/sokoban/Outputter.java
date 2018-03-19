package sokoban;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Outputter extends  HashMap<Object, String>{
	HashMap<String, Object> objects;
	private int tab;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	public Outputter() {
		tab = 0;
		objects = new HashMap<String, Object>();
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
	
	public Object getObject(String name) {
		return objects.get(name);
	}
	
	public void addPair(String name, Object obj) {
		objects.put(name, obj);
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
