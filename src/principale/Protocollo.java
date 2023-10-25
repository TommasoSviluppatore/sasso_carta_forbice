package principale;

import java.io.*; 
import java.net.*; 
import java.util.*;

public class Protocollo implements Serializable{

	public static enum Operazione_t{
		Aggiungi,
//Il client invia l'operazione e la persona da aggiungere, il server ritorna Op_ACK o Op_NACK
		Elimina,
//Il client invia l'operazione e la persona da eliminare, il server ritorna Op_ACK o Op_NACK
		Ricerca,
//Il client invia l'operazione e la persona da cercare, il server ritorna la persona trovata
		Modifica,
//Il client invia l'operazione, la persona da cercare e la persona con i nuovi dati, il server ritorna Op_ACK o Op_NACK
		Op_ACK,
		Op_NACK,
//Il client deve notificare al server quando intende chiudere la connessione
		Op_END
	}
	
}