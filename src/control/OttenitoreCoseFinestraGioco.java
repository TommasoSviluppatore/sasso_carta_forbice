package control;

import view.FinestraClient;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class OttenitoreCoseFinestraGioco implements ActionListener{
	
	private FinestraClient finestra;
	private String mossa_avversario;
	
	
	public OttenitoreCoseFinestraGioco(FinestraClient frame) {
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
	}
	public String getMossaAvversario() {
		return mossa_avversario;
	}
}
