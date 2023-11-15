package control;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import view.Menu;

public class CollegamentoFinestraMenu implements ActionListener{
	
	/**<p>questa controller è l'aiutante della finestra menu*/
	private Menu menu;
	private String mossa_avversario;
	
	
	public CollegamentoFinestraMenu(Menu Menu) {
		menu.registraEvento(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getIniziaGioco()){
			menu.finestraMenuChiusa();
		}
	}
	public String getMossaAvversario() {
		return mossa_avversario;
	}
	
	public String indirizzoConnesione() {
		return menu.getIndirizzoIPCustom();
	}
	
	public int portaConnessione() {
		return Integer.parseInt(menu.getIndirizzoPortaCustom());
	}

}
