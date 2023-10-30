package model;

import java.io.*; 
import java.net.*; 
import java.util.*;

import control.OttenitoreCose;
import view.FinestraClient;

public class TCPBasic_Server {
	
	private ServerSocket server;
	private Socket connection;
	private BufferedReader input;
	private BufferedWriter output;
	private FinestraClient interfaccia;
	private OttenitoreCose ricavitoreCose;
	
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
