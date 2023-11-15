package control;

import view.FinestraClient;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import control.CollegamentoFinestraMenu;

public class CollegamentoFinestraGioco implements ActionListener {
	 

	private FinestraClient finestra;
	private CollegamentoFinestraMenu menuOpz;
	private String mossaAvversario;

	public CollegamentoFinestraGioco(FinestraClient frame) {
		finestra.registraEvento(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finestra.ritornaCarta()) {
			mossaAvversario = "carta";
		}
		if (e.getSource() == finestra.ritornaForbice()) {
			mossaAvversario = "forbice";
		}
		if (e.getSource() == finestra.ritornaSasso()) {
			mossaAvversario = "sasso";
		}
	}
	
	public void impostaScritte(String a) {
		finestra.setContenuto1(a);
	}
	
	public String getMossa() {
		return mossaAvversario;
	}

}
