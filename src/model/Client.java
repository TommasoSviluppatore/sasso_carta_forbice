package model;

import java.io.*; 
import java.net.*; 
import java.util.*;
import control.OttenitoreCoseFinestraIniziale;

public class Client { 
	private Socket connessione; 
	private BufferedReader dalServer; 
	private PrintStream alServer; // Scrive bytes mentre PrintWriter scrive caratteri 
	private BufferedReader tastiera;
	private OttenitoreCoseFinestraIniziale ottieni1;
	
	public Client() { 
		tastiera = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			connessione = new Socket(ottieni1.indirizzoConnesione1(), ottieni1.portaConnessione1()); 
			dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream())); 
			alServer = new PrintStream(connessione.getOutputStream()); 
			} catch (IOException e) { e.printStackTrace(); } 
	}
	
	public void conversazione() { 
		String messaggio = ""; 
		tastiera = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			while(!messaggio.equals("fine")) { 
				
				
				
				
				
			} 
			connessione.close(); 
			} catch(IOException e) { e.printStackTrace(); }
		} 
}

