package model;

import java.io.*; 
import java.net.*; 
import java.util.*;
import control.CollegamentoFinestraMenu;
import view.Menu;

/**<p>sezione principale del client, finché non viene premuto
 * nel bottone menu il pulsante "inizia gioco" la finestra del
 * gioco principale e il gioco in se (compreso il server), vengono
 * solo preparati ma non avviati completamente</p>*/
public class Client { 
	private Socket connessione; 
	private BufferedReader dalServer; 
	private PrintStream alServer; // Scrive bytes mentre PrintWriter scrive caratteri 
	private BufferedReader tastiera;
	private CollegamentoFinestraMenu aiutanteAzioniMenu;
	//da risolvere perché puntatore nullo
	private Menu finestraMenu;
	private boolean proseguiConGioco=false;
	
	public void puoiProseguire(boolean a) {proseguiConGioco=a;}
	
	public Client() { 
		tastiera = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			//da fare che fa nascere l'interfaccia
			//Menu.main(null);
			while(/*menuInit.getContinua()*/!proseguiConGioco) {
				Thread.sleep(1000);
			}
			/**
			 * <p>dopo questa riga incomincia a giocare l'ospite</p>*/
			connessione = new Socket(aiutanteAzioniMenu.indirizzoConnesione(), aiutanteAzioniMenu.portaConnessione()); 
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

