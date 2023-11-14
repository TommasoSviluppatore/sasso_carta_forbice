package model;

import java.io.*; 
import java.net.*; 
import java.util.*;
import control.CollegamentoFinestraMenu;
import view.Menu;

public class Client { 
	private Socket connessione; 
	private BufferedReader dalServer; 
	private PrintStream alServer; // Scrive bytes mentre PrintWriter scrive caratteri 
	private BufferedReader tastiera;
	private CollegamentoFinestraMenu ottienicose;
	//da risolvere perché puntatore nullo
	private Menu menuInit;
	
	public Client() { 
		tastiera = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			//Menu.main(null);
			while(menuInit.getContinua()) {
				Thread.sleep(1000);
			}
			connessione = new Socket(ottienicose.indirizzoConnesione(), ottienicose.portaConnessione()); 
			dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream())); 
			alServer = new PrintStream(connessione.getOutputStream()); 
			} catch (IOException e) { e.printStackTrace(); } 
			  catch (InterruptedException e) { e.printStackTrace(); } 
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

