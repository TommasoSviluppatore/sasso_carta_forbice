package control;

import view.FinestraClient;
import view.Menu;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CollegamentoDaFinestraACodice implements ActionListener{
	
	private FinestraClient finestra;
	private Menu menu;
	private String mossa_avversario;
	
	
	public CollegamentoDaFinestraACodice(FinestraClient frame) {
		finestra.registraEvento(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == finestra.ritornaCarta()){
			mossa_avversario="carta";
		}
		if(e.getSource() == finestra.ritornaForbice()){
			mossa_avversario="forbice";
		}
		if(e.getSource() == finestra.ritornaSasso()){
			mossa_avversario="sasso";
		}
		if(e.getSource()==menu.getIniziaGioco()) {
			menu.finestraMenuChiusa();
		}
	}
	public String getMossaAvversario() {
		return mossa_avversario;
	}
	
	
	public String indirizzoConnesione() {
		return "127.0.0.1";
	}
	
	public int portaConnessione() {
		return 20000;
	}

}
