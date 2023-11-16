package control;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import view.FinestraMenu;

public class CollegamentoFinestraMenu implements ActionListener{
	
	/**<p>questa controller è l'aiutante della finestra menu</p>*/
	private FinestraMenu menu;
	private String mossaAvversario;
	
	
	public CollegamentoFinestraMenu(FinestraMenu Menu) {
		menu.registraEvento(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getIniziaGioco()){
			menu.finestraMenuChiusa();
		}
	}
	public String getMossaAvversario() {
		return mossaAvversario;
	}
	
	public String indirizzoConnesione() {
		return menu.getIndirizzoIPCustom();
	}
	
	public int portaConnessione() {
		return Integer.parseInt(menu.getIndirizzoPortaCustom());
	}

}
