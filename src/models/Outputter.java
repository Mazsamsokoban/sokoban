package models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


//kiírást végzõ osztály, A PROTOTÍPUSHOZ NEM HASZNÁLJUK
public class Outputter extends  HashMap<Object, String>{
	HashMap<String, Object> objects;
	private int tab;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	//hívás mélysége kezdetben 0
	public Outputter() {
		tab = 0;
		objects = new HashMap<String, Object>();
	}
	
	
	//hívás történt obj objektumon
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
	
	//visszaadja a megadott objektum nevét
	public String getName(Object obj) {
		return this.getName(obj);
	}
	//visszaadja a megadott nevû objektumot
	public Object getObject(String name) {
		return objects.get(name);
	}
	
	//berak egy név-objektum párt
	public void addPair(String name, Object obj) {
		objects.put(name, obj);
	}
	
	//függvénybõl való visszatérés kiírása
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
	
	
	//függvényhívás függvény nevével együtt
	public void callfunc(Object obj, String funcName) {
		makeCall(obj);
		System.out.print(funcName);
	}
	//függvényhívásból visszatérés függvény nevével együtt
	public void returnfunc(Object obj, String funcName) {
		returnFromFunc(obj);
		System.out.print(funcName);
	}
}
