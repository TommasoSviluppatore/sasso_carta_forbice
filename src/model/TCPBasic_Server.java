package model;

import java.io.*; 
import java.net.*; 
import java.util.*;
import view.FinestraGioco;

/**<p>funzionalità di aiuto al server</p>*/

public class TCPBasic_Server {
	
	private ServerSocket server;
	private Socket connection;
	private BufferedReader input;
	private BufferedWriter output;
	public TCPBasic_Server(){
		
		try {

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
