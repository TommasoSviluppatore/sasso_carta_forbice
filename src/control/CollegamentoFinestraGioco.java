package control;

import view.FinestraClient;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import control.CollegamentoFinestraMenu;

public class CollegamentoFinestraGioco implements ActionListener {
	 

	private FinestraClient finestraGioco;
	private CollegamentoFinestraMenu aiutanteAzioniMenu;
	private String mossaAvversario;

	public CollegamentoFinestraGioco(FinestraClient frame) {
		finestraGioco.registraEvento(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finestraGioco.ritornaCarta()) {
			mossaAvversario = "carta";
		}
		if (e.getSource() == finestraGioco.ritornaForbice()) {
			mossaAvversario = "forbice";
		}
		if (e.getSource() == finestraGioco.ritornaSasso()) {
			mossaAvversario = "sasso";
		}
	}
	
	public void impostaScritte(String a) {
		finestraGioco.setContenuto1(a);
	}
	
	public String getMossa() {
		return mossaAvversario;
	}

}
