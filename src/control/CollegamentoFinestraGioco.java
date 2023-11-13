package control;

import view.FinestraClient;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import control.CollegamentoFinestraMenu;

public class CollegamentoFinestraGioco implements ActionListener {

	private FinestraClient finestra;
	private CollegamentoFinestraMenu menuOpz;
	private String mossa_avversario;

	public CollegamentoFinestraGioco(FinestraClient frame) {
		finestra.registraEvento(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finestra.ritornaCarta()) {
			mossa_avversario = "carta";
		}
		if (e.getSource() == finestra.ritornaForbice()) {
			mossa_avversario = "forbice";
		}
		if (e.getSource() == finestra.ritornaSasso()) {
			mossa_avversario = "sasso";
		}
	}

	public String getMossaAvversario() {
		return mossa_avversario;
	}

	public String indirizzoConnesione() {
		return menuOpz.indirizzoConnesione();
	}

	public int portaConnessione() {
		return menuOpz.portaConnessione();
	}

}
