package control;

import view.FinestraGioco;
import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.*;
import javax.swing.*;

import view.FinestraMenu;

public class CollegamentoFinestraGioco implements ActionListener{
	 

	private FinestraGioco finestraGioco;
	private CollegamentoFinestraMenu ottieniInformazioni;
	//private String mossaAvversario;
	private Socket connessione;//=new Socket(ottieniInformazioni.indirizzoConnesione(), ottieniInformazioni.portaConnessione());
	private Object mossaAvversario = new ObjectOutputStream(connessione.getOutputStream());


	public CollegamentoFinestraGioco(FinestraGioco frame) {
		finestraGioco.registraEvento(this);
	}


	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finestraGioco.ritornaCarta()) {
			//mossaAvversario = "carta";
			mossaAvversario.writeObject("carta");
		}
		if (e.getSource() == finestraGioco.ritornaForbice()) {
			//mossaAvversario = "forbice";
			mossaAvversario.writeObject("forbice");
		}
		if (e.getSource() == finestraGioco.ritornaSasso()) {
			//mossaAvversario = "sasso";
			mossaAvversario.writeObject("sasso");
		}
	}
	
	public void impostaScritte(String a) {
		finestraGioco.setContenuto1(a);
	}
	
	public String getMossa() {
		return mossaAvversario;
	}

}
