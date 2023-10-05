package principale;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import gestioneChiamateLocalhost2.TCPBasic_Client;
import gestioneChiamateLocalhost2.TCPBasic_Server;

public class GestioneRubrica {
	
	//arraylist di voci
	ArrayList<Voce> prova=new ArrayList<Voce>();
	
	public GestioneRubrica(){
		
	}
	
	public void aggiungiNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output){
		TCPBasic_Server a= new TCPBasic_Server();
		aggiungiNumerooo b = new aggiungiNumerooo();
		try {  a.blocco();  } catch (InterruptedException e) { e.printStackTrace(); }
		b.semplicemente(server, connection, input, output, prova);
		a.rilascio();
	}

	
	public void rimuoviNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output) {
		TCPBasic_Server a= new TCPBasic_Server();
		rimuoviNumerooo b = new rimuoviNumerooo();
		try {  a.blocco();  } catch (InterruptedException e) { e.printStackTrace(); }
		output.write("\nVuoi rimuovere il contatto per numero, per nome o per posizione?  ");
		String stringa;
		while(stringa!="numero" || stringa!="nome" || stringa!="posizione" || stringa!="0" || stringa!="uscita") {
			stringa=input.readLine();
			if(stringa=="numero") {
				b.perNumero(server, connection, input, output, prova);
			}else if(stringa=="nome") {
				b.perNome(server, connection, input, output, prova);
			}else if(stringa=="posizione") {
				b.perPosizione(server, connection, input, output, prova);
			}
		}
		a.rilascio();
	}
	
	public void stampaNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output) {

		TCPBasic_Server a= new TCPBasic_Server();
		stampaNumerooo b = new stampaNumerooo();
		try {  a.blocco();  } catch (InterruptedException e) { e.printStackTrace(); }
		output.write("\nVuoi stampare un contatto per numero, per nome o per posizione?  ");
		String stringa;
		while(stringa!="numero" || stringa!="nome" || stringa!="posizione" || stringa!="0" || stringa!="uscita") {
			stringa=input.readLine();
			if(stringa=="numero") {
				b.perNumero(server, connection, input, output, prova);
			}else if(stringa=="nome") {
				b.perNome(server, connection, input, output, prova);
			}else if(stringa=="posizione") {
				b.perPosizione(server, connection, input, output, prova);
			}
		}
		a.rilascio();
	}
	
	public void RicercaNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output) {

		TCPBasic_Server a= new TCPBasic_Server();
		ricercaNumerooo b = new ricercaNumerooo();
		try {  a.blocco();  } catch (InterruptedException e) { e.printStackTrace(); }
		output.write("\nVuoi cercare un  contatto per numero, per nome o per posizione?  ");
		String stringa;
		while(stringa!="numero" || stringa!="nome" || stringa!="posizione" || stringa!="0" || stringa!="uscita") {
			stringa=input.readLine();
			if(stringa=="numero") {
				b.perNumero(server, connection, input, output, prova);
			}else if(stringa=="nome") {
				b.perNome(server, connection, input, output, prova);
			}else if(stringa=="posizione") {
				//b.perPosizione(server, connection, input, output, prova);
			}
		}
		a.rilascio();
	}
	
}


//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------


class aggiungiNumerooo{
	public void semplicemente(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		for(int i=0; i<3;i++) {
			output.write("\ninserisci numero:  ");
			String telnum=input.readLine();
			output.write("\ninserisci nome:  ");
			String nme=input.readLine();
			if(telnum!="" && nme!="" && telnum=="[0-9]+" && nme=="[a-zA-Z]+") {
				prova.add(new Voce(nme, telnum));
				output.write("\nnumero inserito correttamente\n\n-------------------\n");
				break;
			}else {
				output.write("\ninserimento valori errati\n");
			}
		}
	}
}

class rimuoviNumerooo{
	public void perNome(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\nInserisci il nome che vuoi eliminare:  ");
		String nome=input.readLine();
		if(nome=="") {
			output.write("\nnome non valido");
			nome=input.readLine();
			if(nome=="") {
				output.write("\nnome non valido");
				return;
			}
		}
		String riposta=""; int i=0;
		Iterator<prova> iterator = prova.iterator();
	    while (iterator.hasNext()) {
	    	prova prova1= iterator.next();
	    	if (prova.getNome().equals(nome)) {
	        	iterator.remove(); // Rimuovi l'elemento
	            riposta+=("\nHo rimosso alla posizione: "+i+" il nome "+nome+" con numero "+iterator.getNome());
	            break;
	        }
	        i++;
	    }
	    if(risposta=="") {
	    	output.write("\nil nome che hai immesso non è stato trovato");
	    }else {
	    	output.write(risposta);
	    }
	}
	
	public void perNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\nInserisci il numero che vuoi eliminare:  ");
		String numero=input.readLine();
		if(numero=="") {
			output.write("\nnumero non valido");
			numero=input.readLine();
			if(numero=="") {
				output.write("\nnumero non valido");
				return;
			}
		}
		String risposta=""; int i=0;
		Iterator<prova> iterator = prova.iterator();
	    while (iterator.hasNext()) {
	    	prova prova1= iterator.next();
	    	if (prova.getNumero().equals(numero)) {
	        	iterator.remove(); // Rimuovi l'elemento
	            risposta+=("\nHo rimosso alla posizione: "+i+" il nome "+nome+" con numero "+iterator.getNome());
	            break;
	        }
	        i++;
	    }
	    if(risposta=="") {
	    	output.write("\nil nome che hai immesso non è stato trovato");
	    }else {
	    	output.write(risposta);
	    }
	}
	
	public void perPosizione(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\nInserisci la posizione che vuoi eliminare:  ");
		String posizione=input.readLine();
		if(posizione=="") {
			output.write("\nnumero non valido");
			posizione=input.readLine();
			if(posizione=="") {
				output.write("\nnumero non valido");
				return;
			}
		}
		if(posizione<=0&&posizione>prova.getlenght()) {
			output.write("\nla posizione che vuoi non esiste");
			return;
		}
		prova.removeIf(voce -> voce.getNumero() == posizione);
		output.printf("\nLa voce che hai scelto è stata eliminata con successo");
}



class stampaNumerooo{
	public void perNome(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\ninserisci il nome del contatto:  ");
		String nome=input.readLine();
		if(nome=="") {
			output.write("\nnome non valido");
			nome=input.readLine();
			if(nome=="") {
				output.write("\nnome non valido");
				return;
			}
		}
		
		int i=0;
		
		String risposta;
		for(String  variabile : prova) {
			if(variabile.contains(nome)) {
				risposta+="\nHo trovato "+nome+" alla posizione "+i;
				break;
			}
			i++;
		}
		if(risposta=="") {
			output.write("\nnessuno numero trovato per il nome che cercavi");
		}else {
			output.write(risposta);
		}
	}
	
	public void perNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\ninserisci il numero del contatto:  ");
		String numero=input.readLine();
		if(numero=="") {
			output.write("\nnome non valido");
			numero=input.readLine();
			if(numero=="") {
				output.write("\nnome non valido");
				return;
			}
		}
		
		int i=0;
		
		String risposta;
		for(String  variabile : prova) {
			if(variabile.contains(numero)) {
				risposta+="\nHo trovato "+numero+" alla posizione "+i;
				break;
			}
			i++;
		}
		if(risposta=="") {
			output.write("\nnessuno numero trovato per il numero che cercavi");
		}else {
			output.write(risposta);
		}
	}
	
	public void perPosizione(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\nNumero posizione da stampare: ");
		int pos=((int)input.readLine()).intValue();
		if(pos>=0 && pos pos<500) {
			output.write("Posizione "+pos+":   nome -> "+prova.get[pos].getNome()+ " |||  numero -> "+prova.get[pos].getNumero());
		}else {
			output.write("\nposizione non valida");
		}
	}
	
}




class ricercaNumerooo{
	public void perNome(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\ninserisci il nome del contatto:  ");
		String nome=input.readLine();
		if(nome=="") {
			output.write("\nnome non valido");
			nome=input.readLine();
			if(nome=="") {
				output.write("\nnome non valido");
				return;
			}
		}
		
		int i=0;
		
		String risposta;
		for(String  variabile : prova) {
			if(variabile.contains(nome)) {
				risposta+="\nHo trovato il nome che cercavi nella posizione"+i;
				break;
			}
			i++;
		}
		if(risposta=="") {
			output.write("\nnessuno numero trovato per il nome che cercavi");
		}else {
			output.write(risposta);
		}
	}
	
	public void perNumero(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
		output.write("\ninserisci il numero del contatto:  ");
		String numero=input.readLine();
		if(numero=="") {
			output.write("\nnome non valido");
			numero=input.readLine();
			if(numero=="") {
				output.write("\nnome non valido");
				return;
			}
		}
		
		int i=0;
		
		String risposta;
		for(String  variabile : prova) {
			if(variabile.contains(numero)) {
				risposta+="\nHo trovato il tuo numero alla posizione"+i;
				break;
			}
			i++;
		}
		if(risposta=="") {
			output.write("\nnessuno numero trovato per il numero che cercavi");
		}else {
			output.write(risposta);
		}
	}
	
	public void perPosizione(ServerSocket server, Socket connection, BufferedReader input ,BufferedWriter output, ArrayList<prova> arrayList) {
	}
	
	
}
