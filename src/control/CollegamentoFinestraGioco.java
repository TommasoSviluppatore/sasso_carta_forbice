package control;

import view.FinestraGioco;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import control.CollegamentoFinestraMenu;

public class CollegamentoFinestraGioco implements ActionListener {
	 

	private FinestraGioco finestraGioco;
	private CollegamentoFinestraMenu aiutanteAzioniMenu;
	private String mossaAvversario;

	public CollegamentoFinestraGioco(FinestraGioco frame) {
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
