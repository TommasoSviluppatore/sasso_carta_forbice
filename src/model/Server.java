package model;

import java.io.*; 
import java.net.*; 
import java.util.*;

public class Server {
	private ServerSocket server;
	private Socket connessione;
	private BufferedReader dalClient;
	private PrintStream alClient; // Scrive bytes mentre PrintWriter scrive caratteri
	
	public Server() { // costruttore
		try {
			// port (20000): se = 0 sceglie la prima porta libera
			// backlog (5): lunghezza massima della coda delle richieste di connessione
			server = new ServerSocket(20000, 5); // DatagramSocket per connessioni UDP
			System.out.println("Server attivo");
			System.out.println(server.getInetAddress());
			connessione = server.accept();
			dalClient = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alClient = new PrintStream(connessione.getOutputStream());
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void conversazione() {
		String messaggio = "";
		BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
		try {
			alClient.println("Salve");
			while(!messaggio.equals("fine")) {
				messaggio = dalClient.readLine();
				System.out.println(messaggio);
				if (!messaggio.equals("fine")) {
					messaggio = tastiera.readLine();
					
					
					//alClient.println(messaggio);
					//qui invia il server
					
					
					
				}
			}
			connessione.close();
		} catch(IOException e) {e.printStackTrace();}
	}
}
