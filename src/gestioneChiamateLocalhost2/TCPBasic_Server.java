package gestioneChiamateLocalhost2;

import java.io.*; 
import java.net.*; 
import java.util.*;

public class TCPBasic_Server {
	
	private ServerSocket server;
	private Socket connection;
	private BufferedReader input;
	private BufferedWriter output;
	
	public int numeroContatto=0;
	
	public enum Elemento{
		SASSO, CARTA, FORBICE;
	}
	
	public TCPBasic_Server(){
		
		try {
		
		System.out.println("SERVER ATTIVO");
        server = new ServerSocket(8081);
        
        System.out.println("SERVER IN ATTESA CHE UN CLIENT SI CONNETTA.....");
        connection = server.accept();

        System.out.println(connection);

        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        
        String risposta, elemento_essere;
        
        output.write("\n Vuoi essere sasso, carta o forbice?  ");  risposta=input.readLine(); elemento_essere=risposta;

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
