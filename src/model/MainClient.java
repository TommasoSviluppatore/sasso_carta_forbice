package model;

import java.io.*; 
import java.net.*; 
import java.util.*;

import model.Client;
import view.Menu;


/** <p>lanciatore della sezione giocatore 1 (ospite) </p>
 	<p>Questa sezione inizia a fare funzionare solo il sever </p>
	* @param niente
	* @return se ritorna significa che il tuo computer non funziona
	* @see niente
	* @since adesso
 * */
public class MainClient{
	public static void main(String[] args) {
		Client client = new Client();
		client.conversazione();
		//new Thread((Runnable) new view.Menu()).start();
		//new Thread((Runnable) new Client()).start();
	}

}
