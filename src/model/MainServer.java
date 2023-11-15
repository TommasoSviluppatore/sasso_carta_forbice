package model;

import java.io.*; 
import java.net.*; 
import java.util.*;

import model.Server;

public class MainServer {
	/**
	 * <p>Questa sezione inizia a fare funzionare solo il sever </p>
	 * @param niente
	 * @return se ritorna significa che il tuo computer non funziona
	 * @see niente
	 * @since adesso
	 */
	public static void main(String[] args) {
		Server server = new Server();
		server.conversazione();
	}
}
