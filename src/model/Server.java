package model;

import java.io.*;
import java.net.*; 
import java.util.*;

import model.TCPBasic_Server;
import view.FinestraClient;
import control.OttenitoreCoseFinestraIniziale;

public class Server {
	private ServerSocket server;
	private Socket connection1;
	private Socket connection2;

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
			server = new ServerSocket(42000,2); 
			System.out.println("Server attivo");
			System.out.println(server.getInetAddress());
			this.connection1 = server.accept();
			this.connection2 = server.accept();
			new Thread().start();
		} catch (IOException e) {e.printStackTrace();}
		
		
	}
	
}
