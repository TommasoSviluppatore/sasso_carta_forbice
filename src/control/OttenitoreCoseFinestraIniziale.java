package control;

import java.io.*;
import java.net.*; 
import java.util.*;

import model.TCPBasic_Server;
import view.FinestraClient;

public class OttenitoreCoseFinestraIniziale {
	//da mettere che prende i dati dalla finestra di connessione
	
	public String indirizzoConnesione1() {
		return "127.0.0.1";
	}
	
	public int portaConnessione1() {
		return 20000;
	}

}
