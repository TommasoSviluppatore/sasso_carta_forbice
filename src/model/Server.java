package model;

import java.io.*; 
import java.net.*; 
import java.util.*;
import model.TCPBasic_Server;
import view.FinestraClient;
import control.OttenitoreCose;

import model.TCPBasic_Server.oggettochesie;

public class Server {
	private ServerSocket server;
	private Socket connessione;
	private BufferedReader dalClient;
	private PrintStream alClient; // Scrive bytes mentre PrintWriter scrive caratteri
	private Socket connection;
	private BufferedReader input;
	private BufferedWriter output;
	private FinestraClient interfaccia;
	private OttenitoreCose ricavitoreCose;
	
	private int vittorieServer=0, vittorieClient=0;
    private String rispostaServer, elementoEssereServer, elementoEssereGiocatore, rispostaGiocatore;
    private boolean toccaA=false;
	
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
				
				
				System.out.println("\nSERVER ATTIVO");
		        server = new ServerSocket(8081);
		        
		        System.out.println("\nSERVER IN ATTESA CHE UN CLIENT SI CONNETTA.....");
		        connection = server.accept();

		        System.out.println("\n"+connection+"---------------\n");

		        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		        output = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
		        
		        
		        
		        
		        System.out.println("Benvenuto in sesso, carta, forbice!");
		        System.out.println("Voi far fare la prima mossa al tuo avversario?");
		        
		        rispostaServer=System.console().readLine();
		        
		        if(rispostaServer=="si") {
		        	
		        		//mossa del client
		        		System.out.println("prima mossa del client");
		        		output.write("Il server ha acconsentito a darti la prima mossa, cosa vuoi essere");
		        		//rispostaGiocatore=input.readLine();
		        		for(int cont1=0;rispostaGiocatore!="" || cont1<4; cont1++) {
		            		rispostaGiocatore=ricavitoreCose.getMossaAvversario();
		        		}

		        		System.out.println("ora è il tuo turno, immetti la tua mossa");
		        		rispostaServer=System.console().readLine();
		        		toccaA=true;
		        		

		                oggettochesie mossa_giocatore = oggettochesie.valueOf(rispostaGiocatore.toUpperCase());
		                oggettochesie mossa_server = (oggettochesie.valueOf(rispostaServer.toUpperCase()));
		        		
		        		
		        		if( mossa_giocatore.getValore() == mossa_server.getValore()) {
		        			interfaccia.setContenuto1("");
		        			System.out.println("\nParreggio");
		        			output.write("Parreggio");
		        			
		        			
		        		}else if( mossa_giocatore.getValore() > mossa_server.getValore()) {
		        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
		        			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
		        			vittorieServer++;
		        			
		        			
		        		}else if( mossa_giocatore.getValore() < mossa_server.getValore() ){
		        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
		        			output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
		        			vittorieClient++;
		        			
		        		}else{
		        			output.write("errore generico da ignorare");
		        			System.out.println("errore generico da ingnorare");
		        		}
		        		
		        }else {
		        	//mossa del server
		    		System.out.println("prima mossa del server");
		    		output.write("Il server giocherà per primo");
		    		rispostaServer=System.console().readLine();

		    		output.write("ora è il tuo turno, immetti la tua mossa");
		    		for(int cont1=0;rispostaGiocatore!="" || cont1<4; cont1++) {
		        		rispostaGiocatore=ricavitoreCose.getMossaAvversario();
		    		}
		    		toccaA=false;
		    		
		            oggettochesie mossa_giocatore = oggettochesie.valueOf(rispostaGiocatore.toUpperCase());
		            oggettochesie mossa_server = (oggettochesie.valueOf(rispostaServer.toUpperCase()));
		    		
		    		
		    		if( mossa_giocatore.getValore() == mossa_server.getValore() ) {
		    			System.out.println("\nParreggio");
		    			output.write("Parreggio");
		    			
		    			
		    		}else if( mossa_giocatore.getValore() > mossa_server.getValore()) {
		    			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
		    			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
		    			vittorieServer++;
		    			
		    			
		    		}else if( mossa_giocatore.getValore() < mossa_server.getValore() ){
		    			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
		    			output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
		    			vittorieClient++;
		    			
		    		}else{
		    			output.write("errore generico da ignorare");
		    			System.out.println("errore generico da ingnorare");
		    		}
		        	
		        }
		        
		        while (true) {
		        	
		        	//INIZIO PROGRAMMA
		            String letta="" ;//= input.readLine();

		            if (letta.compareTo("EXIT") == 0) {
		                output.write("CLOSE");
		                output.flush();
		                System.out.println("Chiusura del canale");
		                break;
		            }

		            output.write(letta.toUpperCase() + "\n");
		            output.flush();
		            
		            String risposta=input.readLine();
		           
		            if(toccaA) {
		            	//mossa del client
		        		System.out.println("mossa del client");
		        		for(int cont1=0;rispostaGiocatore!="" || cont1<4; cont1++) {
		            		rispostaGiocatore=ricavitoreCose.getMossaAvversario();
		        		}

		        		System.out.println("mossa del server");
		        		output.write("mossa del server");
		        		rispostaServer=System.console().readLine();
		        		toccaA=!toccaA;
		        		
		        		oggettochesie mossa_giocatore = oggettochesie.valueOf(rispostaGiocatore.toUpperCase());
		                oggettochesie mossa_server = (oggettochesie.valueOf(rispostaServer.toUpperCase()));
		        		
		        		
		        		if(mossa_giocatore.getValore() == mossa_server.getValore()) {
		        			System.out.println("\nParreggio");
		        			output.write("Parreggio");
		        			
		        			
		        		}else if(mossa_giocatore.getValore() < mossa_server.getValore()) {
		        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
		        			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
		        			vittorieServer++;
		        			
		        			
		        		}else if(mossa_giocatore.getValore() > mossa_server.getValore()){
		        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
		        			output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
		        			vittorieClient++;
		        			
		        		}else{
		        			output.write("errore generico da ignorare");
		        			System.out.println("errore generico da ingnorare");
		        		}
		        		
		        		
		            }else{
		            	
		            	
		        		System.out.println("mossa del server");
		        		output.write("mossa del server");
		        		rispostaServer=System.console().readLine();
		        		
		            	System.out.println("mossa del client");
		            	for(int cont1=0;rispostaGiocatore!="" || cont1<4; cont1++) {
		            		rispostaGiocatore=ricavitoreCose.getMossaAvversario();
		        		}
		        		toccaA=!toccaA;
		        		
		        		oggettochesie mossa_giocatore = oggettochesie.valueOf(rispostaGiocatore.toUpperCase());
		                oggettochesie mossa_server = (oggettochesie.valueOf(rispostaServer.toUpperCase()));
		        		
		        		if(mossa_giocatore.getValore() == mossa_server.getValore()) {
		        			System.out.println("\nParreggio");
		        			output.write("Parreggio");
		        			
		        			
		        		}else if(mossa_giocatore.getValore() < mossa_server.getValore()) {
		        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
		        			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
		        			vittorieServer++;
		        			
		        			
		        		}else if(mossa_giocatore.getValore() > mossa_server.getValore()){
		        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
		        			output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
		        			vittorieClient++;
		        			
		        		}else{
		        			output.write("errore generico da ignorare");
		        			System.out.println("errore generico da ingnorare");
		        		}
		            }
		        }	
			}
			connessione.close();
		} catch(IOException e) {e.printStackTrace();}
	}
}

