package models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


//ki�r�st v�gz� oszt�ly, A PROTOT�PUSHOZ NEM HASZN�LJUK
public class Outputter extends  HashMap<Object, String>{
	HashMap<String, Object> objects;
	private int tab;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	//h�v�s m�lys�ge kezdetben 0
	public Outputter() {
		tab = 0;
		objects = new HashMap<String, Object>();
	}
	
	
	//h�v�s t�rt�nt obj objektumon
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
	
	//visszaadja a megadott objektum nev�t
	public String getName(Object obj) {
		return this.getName(obj);
	}
	//visszaadja a megadott nev� objektumot
	public Object getObject(String name) {
		return objects.get(name);
	}
	
	//berak egy n�v-objektum p�rt
	public void addPair(String name, Object obj) {
		objects.put(name, obj);
	}
	
	//f�ggv�nyb�l val� visszat�r�s ki�r�sa
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
	
	
	//f�ggv�nyh�v�s f�ggv�ny nev�vel egy�tt
	public void callfunc(Object obj, String funcName) {
		makeCall(obj);
		System.out.print(funcName);
	}
	//f�ggv�nyh�v�sb�l visszat�r�s f�ggv�ny nev�vel egy�tt
	public void returnfunc(Object obj, String funcName) {
		returnFromFunc(obj);
		System.out.print(funcName);
	}
}
