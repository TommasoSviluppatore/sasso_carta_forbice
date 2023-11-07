package model;

import java.io.*;
import java.net.*; 
import java.util.*;

import model.TCPBasic_Server;
import view.FinestraClient;
import control.OttenitoreCoseFinestraIniziale;

public class Server {
	private ServerSocket server;
	private Socket connection;
	private BufferedReader input,dalClient;
	private BufferedWriter output,dalServer;
	private PrintStream alClient;
	private FinestraClient finestra1;
	private OttenitoreCoseFinestraIniziale ottienicose;
	
	private int vittorieServer=0, vittorieClient=0;
    private String rispostaServer, elementoEssereServer, elementoEssereGiocatore, rispostaGiocatore;
    private boolean toccaA=false;
	
	public enum oggettochesie {
	    SASSO(1),
	    FORBICE(2),
	    CARTA(3);

	    private final int valore;

	    oggettochesie(int valore) {
	        this.valore = valore;
	    }

	    public int getValore() {
	        return valore;
	    }
	}
	
	public Server() {
		try {
			// port (20000): se = 0 sceglie la prima porta libera
			// backlog (5): lunghezza massima della coda delle richieste di connection
			server = new ServerSocket(5); // DatagramSocket per connessioni UDP
			System.out.println("Server attivo");
			System.out.println(server.getInetAddress());
			connection = server.accept();
			BufferedReader dalClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			PrintStream alClient = new PrintStream(connection.getOutputStream());
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void conversazione() {
		
		try {
			
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
        		rispostaGiocatore=input.readLine();

        		System.out.println("ora � il tuo turno, immetti la tua mossa");
        		rispostaServer=System.console().readLine();
        		toccaA=true;
        		
        		
        		if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() == oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("\nParreggio");
        			output.write("Parreggio");
        			
        			
        		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() < oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
        			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
        			vittorieServer++;
        			
        			
        		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() > oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()){
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
    		output.write("Il server giocher� per primo");
    		rispostaServer=System.console().readLine();

    		output.write("ora � il tuo turno, immetti la tua mossa");
    		rispostaGiocatore=input.readLine();
    		toccaA=false;
    		
    		
    		if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() == oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
    			System.out.println("\nParreggio");
    			output.write("Parreggio");
    			
    			
    		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() < oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
    			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
    			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
    			vittorieServer++;
    			
    			
    		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() > oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()){
    			System.out.println("il giocatore 2 "/*giocatoree*/+"ha accumulato un punto");
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
        		rispostaGiocatore=input.readLine();

        		System.out.println("mossa del server");
        		output.write("mossa del server");
        		rispostaServer=System.console().readLine();
        		toccaA=!toccaA;
        		
        		
        		if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() == oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("\nParreggio");
        			output.write("Parreggio");
        			
        			
        		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() < oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
        			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
        			vittorieServer++;
        			
        			
        		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() > oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()){
        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
        			output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
        			vittorieClient++;
        			
        		}else{
        			output.write("errore generico da ignorare");
        			System.out.println("errore generico da ingnorare");
        		}
        		
        		
            }else {
            	
            	
        		System.out.println("mossa del server");
        		output.write("mossa del server");
        		rispostaServer=System.console().readLine();
        		
            	System.out.println("mossa del client");
        		rispostaGiocatore=input.readLine();
        		toccaA=!toccaA;
        		
        		if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()) == oggettochesie.valueOf(rispostaServer.toUpperCase())) {
        			System.out.println("\nParreggio");
        			output.write("Parreggio");
        			
        			
        		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() < oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
        			output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
        			vittorieServer++;
        			
        			
        		}else if(oggettochesie.valueOf(rispostaGiocatore.toUpperCase()).getValore() > oggettochesie.valueOf(rispostaServer.toUpperCase()).getValore()){
        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
        			output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
        			vittorieClient++;
        			
        		}else{
        			output.write("errore generico da ignorare");
        			System.out.println("errore generico da ingnorare");
        		}
            }
        }

        input.close();
        output.close();

        connection.close();


    } catch (IOException e) {
        e.printStackTrace();
    }
		
	}
}
