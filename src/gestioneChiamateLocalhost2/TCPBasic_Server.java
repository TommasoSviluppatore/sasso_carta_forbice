package gestioneChiamateLocalhost2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

import principale.GestioneRubrica;

public class TCPBasic_Server {
	
	private ServerSocket server;
	private Socket connection;
	private BufferedReader input;
	private BufferedWriter output;
	

	static Semaphore semaforo=new Semaphore(2);
	public static void blocco() throws InterruptedException { semaforo.acquire();}
	public static void rilascio() throws InterruptedException {semaforo.release();}
	
	public TCPBasic_Server(){
		
		try {
		
		System.out.println("SERVER ATTIVO");
        server = new ServerSocket(8081);
        
        System.out.println("SERVER IN ATTESA CHE UN CLIENT SI CONNETTA.....");
        connection = server.accept();

        System.out.println(connection);

        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        
        //collegamento al gestionale
        GestioneRubrica elencotelefono= new GestioneRubrica();

        while (true) {
        	
        	//INIZIO PROGRAMMA
            String letta = input.readLine();

            if (letta.compareTo("EXIT") == 0) {
                output.write("CLOSE");
                output.flush();
                System.out.println("Chiusura del canale");
                break;
            }

            output.write(letta.toUpperCase() + "\n");
            output.flush();
            
            //schermata opzioni
            
            output.write("\nCosa vuoi fare?");
            output.write("\n|-> 1) aggiungi contatto");
            output.write("\n|-> 2) elimina contatto");
            output.write("\n|-> 3) visualizza contatto");
            output.write("\n|-> 4) ricerca contatto ");
            
            letta = input.readLine();
            output.write("\n----------------------------\n\n");
            
            //cambio in base al contesto
            switch(letta) {
            
            	case "1":
            		elencotelefono.aggiungiNumero(server,connection, input, output);
            		//semaforo di attesa con controllo di un secondo
            		while(semaforo.availablePermits() < 2) {
            			try { 
            				Thread.sleep(1000);
						} catch (InterruptedException e) { e.printStackTrace();}
            		}
            		break;
            		
            	case "2":
            		elencotelefono.rimuoviNumero(server,connection, input, output);
            		while(semaforo.availablePermits() < 2) {
            			try {
            				Thread.sleep(1000);
            			} catch (InterruptedException e) {e.printStackTrace();}
            		}
            		break;
            		
            	case "3":
            		elencotelefono.stampaNumero(server,connection, input, output);
            		while(semaforo.availablePermits() < 2) {
            			try {
							Thread.sleep(1000);
						} catch (InterruptedException e) { e.printStackTrace();  }
            		}
            		break;
            		
            	case "4":
            		elencotelefono.RicercaNumero(server,connection, input, output);
                	while(semaforo.availablePermits() < 2) {
                		try {
							Thread.sleep(1000);
						} catch (InterruptedException e) { e.printStackTrace(); }
                	}
                	break;
                	
            	default:
            	try {
					Thread.sleep(5000);
				} catch (InterruptedException e) { e.printStackTrace(); }
            	break;
            }
            
        }

        input.close();
        output.close();

        connection.close();


    } catch (IOException e) {
        e.printStackTrace();
    }
}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TCPBasic_Server server=new TCPBasic_Server();

	}
}
