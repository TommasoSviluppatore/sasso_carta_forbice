package gestioneChiamateLocalhost2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPBasic_Client {
	
	
	private Socket connection=null;
	private BufferedReader input;
	private BufferedWriter output;
	private Scanner kbReader;
	
	public TCPBasic_Client() {
		
		boolean connesso = false;
		while (!connesso) {
			try {
				connection = new Socket(InetAddress.getLocalHost(),8081);
				connesso=true;
			} catch (Exception e) {
				System.out.println("Connessione non riuscita, ritento....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			
		}
		
		try {
			//connection = new Socket(InetAddress.getLocalHost(),8081);
			System.out.println(connection);
	
	        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        output = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	        kbReader = new Scanner(System.in);
	        
	        while(true){
	            
	        	System.out.print("Scrivi la tua frase: ");
	            output.write(kbReader.nextLine()+"\n");
	            output.flush();

	            String letta = input.readLine();

	            if(letta.compareTo("CLOSE")==0){
	                System.out.println("chiusura del canale.");
	                break;
	            }

	            System.out.println("Il server mi ha risposto: "+ letta);
	        }
	        
	        kbReader.close();
	        input.close();
	        output.close();
	        connection.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TCPBasic_Client client=new TCPBasic_Client();

	}

}




