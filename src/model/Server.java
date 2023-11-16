package model;

import java.io.*;
import java.net.*; 
import java.util.*;

import model.TCPBasic_Server;
import view.FinestraGioco;
import control.CollegamentoFinestraMenu;
import control.CollegamentoFinestraGioco;
import model.Client;

public class Server {
	private ServerSocket server;
	private Socket connection;
	private BufferedReader ricezioneDalClient;
	private BufferedWriter invioAlClient;
	
	private FinestraGioco finestraGioco;
	private CollegamentoFinestraMenu aiutanteAzioniMenu;
	private CollegamentoFinestraGioco aiutanteAzioniGioco;
	
	private int vittorieServer=0, vittorieClient=0;
    private String rispostaServer, mossaServer, mossaGiocatore, rispostaGiocatore;
    private boolean toccaA=false;
    private final int numeroMosse=9;
	private boolean proseguiConGioco=false;
	
	
	/**
	 * <p>controllo del proseguimento, se il bottone nella pagina di menu,
	 * l'indirizzo ip e la porta non sono stati inseriti / premuti, il programma si blocca</p>
	 * @param valore booleano solo in scrittura
	 * @return non esistente
	 * @see niente
	 * @since addesso*/
	public void puoiProseguire(boolean a) {proseguiConGioco=a;}
	
	/**<p>gestione valori con un enum di sasso, carta e forbice</p>
	 * @param non esistente
	 * @return non esistente
	 * @see niente
	 * @since adesso*/
	public enum mossaNumerata {
	    SASSO(1),
	    FORBICE(2),
	    CARTA(3);

	    private final int valore;

	    mossaNumerata(int valore) {
	        this.valore = valore;
	    }

	    public int getValore() {
	        return valore;
	    }
	}
	
	/**
	 * </p>costruttore della sezione server</p>
	 * @param server, serve a dire il tipo di connessione che vuole
	 * <p>dalClient e alClient servono a ricevere e inviare testo</p>
	 * */
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
	
	//questa sezione non funziona, correggere
	/**
	 * <p>questa funzione è la parte principale del server, in questa parte 
	 * definisce crea un entrata e uscita di testo per client e server
	 * e aspetta che il client si connetta</p>
	 * */
	public void conversazione() {
		
		try {
		System.out.println("\nSERVER ATTIVO");
        server = new ServerSocket(8081);
        
        System.out.println("\nSERVER IN ATTESA CHE UN CLIENT SI CONNETTA.....");
        connection = server.accept();

        System.out.println("\n"+connection+"---------------\n");

        if (rispostaServer.compareTo("EXIT") == 0) {
            invioAlClient.write("CLOSE");
            invioAlClient.flush();
            System.out.println("Chiusura del canale");
            invioAlClient.close();
            ricezioneDalClient.close();
            return;
        }
        
        
        ricezioneDalClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        invioAlClient = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        
        
        /**<p>qui aspetta che il gioco inizi asperttando che nel menu 
         * il bottone "inizia gioco" venga premuto</p>*/
        while(!proseguiConGioco) { try { Thread.sleep(1000); } 
        catch (InterruptedException e) { e.printStackTrace(); } }

        
        
        invioAlClient.flush();
        
        
    	//INIZIO PROGRAMMA
        
        ObjectInputStream versoIlServerOggetti=new ObjectInputStream(connection.getInputStream());
        ObjectOutputStream versoIlClientOggetti=new ObjectOutputStream(connection.getOutputStream());
        /**<p>gestione del gioco in se, diviso in due parti:
         * la prima è per decidere se il giocatore o il server iniziano la 
         * partita e dopodiché c'è un ciclo finito di 20 turni dove il 
         * server immette le parole che vuole giocare mentre
         * il giocatore ha una bella interfaccia grafica</p>*/
        System.out.println("Benvenuto in sasso, carta, forbice!");
        System.out.println("Voi far fare la prima mossa al tuo avversario?");
        
        rispostaServer=System.console().readLine();

        if(rispostaServer=="si") {
        	
        	//sostituisci la input readline del client con il ricevitore dell'interfaccia
        	//sostituisci la output del giocatore al terminale con la output nella stringa di testo nell'interfaccia
        	
        		//mossa del client
        		System.out.println("prima mossa del client");
    			aiutanteAzioniGioco.impostaScritte("Il server ha acconsentito a darti la prima mossa, cosa vuoi essere");
        		//output.write("Il server ha acconsentito a darti la prima mossa, cosa vuoi essere");
        		rispostaGiocatore=/*input.readLine();*/aiutanteAzioniGioco.getMossa();

        		System.out.println("ora � il tuo turno, immetti la tua mossa");
        		rispostaServer=System.console().readLine();
        		toccaA=true;
        		
        		
        		if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() == mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("\nParreggio");
        			//output.write("Parreggio");
        			aiutanteAzioniGioco.impostaScritte("parreggio");
        			
        			
        		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() < mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
        			//output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
        			aiutanteAzioniGioco.impostaScritte("il server ha fatto un punto");
        			vittorieServer++;
        			
        			
        		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() > mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()){
        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
        			//output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
        			aiutanteAzioniGioco.impostaScritte("hai fatto un punto, complimenti!");
        			vittorieClient++;
        			
        		}else{
        			invioAlClient.write("errore generico da ignorare");
        			System.out.println("errore generico da ingnorare");
        		}
        		
        }else {
        	//mossa del server
    		System.out.println("prima mossa del server");
    		invioAlClient.write("Il server giocher� per primo");
    		rispostaServer=System.console().readLine();

    		invioAlClient.write("ora � il tuo turno, immetti la tua mossa");
    		rispostaGiocatore=aiutanteAzioniGioco.getMossa();
    		toccaA=false;
    		
    		
    		if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() == mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
    			System.out.println("\nParreggio");
    			//output.write("Parreggio");
    			aiutanteAzioniGioco.impostaScritte("vi siete scontrati e siete morti entrambi");
    			
    			
    		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() < mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
    			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
    			//output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
    			vittorieServer++;
    			
    			
    		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() > mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()){
    			System.out.println("il giocatore 2 "/*giocatoree*/+"ha accumulato un punto");
    			//output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
    			vittorieClient++;
    			
    			
    		}else{
    			invioAlClient.write("errore generico da ignorare");
    			System.out.println("errore generico da ingnorare");
    		}
        	
        }
        
        /**<p>parte del programma che prosegue per 
         * numero specificato di mosse</p>
         * */
        for(int mosse=0;mosse<numeroMosse;mosse++) {


            if (rispostaServer.compareTo("EXIT") == 0) {
                invioAlClient.write("CLOSE");
                invioAlClient.flush();
                System.out.println("Chiusura del canale");
                invioAlClient.close();
                ricezioneDalClient.close();
                return;
            }
        	
        	try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        	
           
            if(toccaA) {
            	//mossa del client
        		System.out.println("mossa del client");
        		rispostaGiocatore=aiutanteAzioniGioco.getMossa();

        		System.out.println("mossa del server");
        		invioAlClient.write("mossa del server");
        		rispostaServer=System.console().readLine();
        		toccaA=!toccaA;
        		
        		
        		if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() == mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("\nParreggio");
        			//output.write("Parreggio");
        			aiutanteAzioniGioco.impostaScritte("vi siete scontrati e siete morti entrambi");
        			
        			
        		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() < mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
        			//output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
        			vittorieServer++;
        			aiutanteAzioniGioco.impostaScritte("il server ha fatto un punto!");
        			
        			
        		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() > mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()){
        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
        			//output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
        			vittorieClient++;
        			aiutanteAzioniGioco.impostaScritte("hai fatto punto!");
        			
        		}else{
        			//output.write("errore generico da ignorare");
        			aiutanteAzioniGioco.impostaScritte("errore generico da ingnorare");
        			System.out.println("errore generico da ingnorare");
        		}
        		
        		
            }else {
            	
            	
        		System.out.println("mossa del server");
        		//output.write("mossa del server");
    			aiutanteAzioniGioco.impostaScritte("mossa del server");
        		rispostaServer=System.console().readLine();
        		
            	System.out.println("mossa del client");
        		rispostaGiocatore=aiutanteAzioniGioco.getMossa();
        		toccaA=!toccaA;
        		
        		if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()) == mossaNumerata.valueOf(rispostaServer.toUpperCase())) {
        			System.out.println("\nParreggio");
        			//output.write("Parreggio");
        			aiutanteAzioniGioco.impostaScritte("vi siete scontrati e siete morti entrambi");
        			
        			
        			
        		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() < mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()) {
        			vittorieServer++;
        			System.out.println("il giocatore 1 "/*server*/+"ha accumulato un punto");
        			//output.write("il giocatore 1 \"/*server*/+\"ha accumulato un punto");
        			aiutanteAzioniGioco.impostaScritte("Nah");
        			
        			
        		}else if(mossaNumerata.valueOf(rispostaGiocatore.toUpperCase()).getValore() > mossaNumerata.valueOf(rispostaServer.toUpperCase()).getValore()){
        			vittorieClient++;
        			System.out.println("il giocatore 2 "/*giocatore*/+"ha accumulato un punto");
        			//output.write("il giocatore 2 \"/*client*/+\"ha accumulato un punto");
        			aiutanteAzioniGioco.impostaScritte("hai fatto punto");
        			
        		}else{
        			//output.write("errore generico da ignorare");
        			aiutanteAzioniGioco.impostaScritte("errore generico da ingnorare");
        			System.out.println("errore generico da ingnorare");
        		}
            }
        }

        /** <p>stampa dei punteggi con chi ha vinto</p>
         */
        if(vittorieClient>vittorieServer) {
        	//output.write("\nil giocatore 2 ha vinto la partita");
        	System.out.println("\nhai perso!");
        	aiutanteAzioniGioco.impostaScritte("hai vinto, complimenti!, hai fatto "+vittorieClient+" punti!");
        }
        else if(vittorieServer>vittorieClient) {
        	//output.write("\nil giocatore 1 ha vinto la partita");
        	System.out.println("\nhai vinto!");
        	aiutanteAzioniGioco.impostaScritte("hai perso, il giocatore 1 ha vinto la partita , con "+vittorieServer+" punti!");
        }
        else if(vittorieClient==vittorieServer) {
        	//output.write("\npareggio");
        	System.out.println("\npareggio");
        	aiutanteAzioniGioco.impostaScritte("pareggio");
        }
        else {
        	//output.write("\nerrore, altro giorno, altre roulette russe!");
        	System.out.println("\nerrore, altro giorno, altre roulette russe!");
        	aiutanteAzioniGioco.impostaScritte("errore, altro giorno, altre roulette russe!");
        }
        ricezioneDalClient.close();
        invioAlClient.close();

        connection.close();


    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("qualche errore è successo");
    }
		
	}
}
