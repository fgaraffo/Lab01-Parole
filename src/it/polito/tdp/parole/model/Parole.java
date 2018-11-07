package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	List <String> parole;
	
	public Parole() {
		
		parole = new LinkedList <String> ();
//		parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		
		parole.add(p);

	}
	
	public List<String> getElenco() {
		
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	public void cancella (String string) {
		
		parole.remove(string);
//		String s = parole.toString();
//		System.out.println(s);
					
	}
}
