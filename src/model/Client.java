package model;

import java.io.*; 
import java.net.*; 
import java.util.*;
import control.OttenitoreCoseFinestraIniziale;

public class Client { 
	private Socket connessione; 
	private ObjectInputStream input; 
	private ObjectOutputStream output;
	
	public Client() { 	
		try {
			connessione = new Socket("127.0.0.1", 50000); 
			this.input=new ObjectInputStream(connessione.getInputStream());
			this.output=new ObjectOutputStream(connessione.getOutputStream());
		} catch (IOException e) { e.printStackTrace(); } 
	}
	
	public void conversazione(String sceltaGiocatore) { 
		String messaggio = ""; 
		
		try { 
			while(!messaggio.equals("fine")) { 
				
							
			} 
			connessione.close(); 
			} catch(IOException e) { e.printStackTrace(); }
		} 
}

