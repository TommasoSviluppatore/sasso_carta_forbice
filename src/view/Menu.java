package view;

//da fare il passaggio in finestra da quesra a quella di gioco, da mettere
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import control.CollegamentoFinestraMenu;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnIniziaGioco;
	private JLabel lblTitolo,lblCaricamento,manoForbice,manoSasso, manoForbice_1;
	private JTextField portaIP, indirozzoIP;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Sasso/Carta/Forbice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIniziaGioco = new JButton("Inizia Partita");
		btnIniziaGioco.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnIniziaGioco.setBounds(141, 108, 221, 103);
		contentPane.add(btnIniziaGioco);
		
		lblTitolo = new JLabel("Sasso/Carta/Forbice");
		lblTitolo.setForeground(Color.BLUE);
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBounds(10, 264, 494, 36);
		contentPane.add(lblTitolo);
		
		lblCaricamento = new JLabel("Caricamento...");
		lblCaricamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCaricamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaricamento.setBounds(141, 114, 221, 99);
		contentPane.add(lblCaricamento);
		
		manoForbice = new JLabel("");
		manoForbice.setBounds(0, 126, 113, 127);
		contentPane.add(manoForbice);
		
		manoSasso = new JLabel("");
		manoSasso.setBounds(186, 0, 129, 88);
		contentPane.add(manoSasso);
		
		manoForbice_1 = new JLabel("");
		manoForbice_1.setBounds(401, 126, 113, 127);
		contentPane.add(manoForbice_1);
		
		portaIP = new JTextField();
		portaIP.setBounds(89, 28, 138, 36);
		contentPane.add(portaIP);
		portaIP.setColumns(10);
		
		indirozzoIP = new JTextField();
		indirozzoIP.setColumns(10);
		indirozzoIP.setBounds(237, 28, 138, 36);
		contentPane.add(indirozzoIP);
		
		JLabel ipIndirizzoScelta = new JLabel("Indirizzo ip");
		ipIndirizzoScelta.setBounds(130, 3, 72, 14);
		contentPane.add(ipIndirizzoScelta);
		
		JLabel PortaScelta = new JLabel("Porta");
		PortaScelta.setBounds(279, 3, 72, 14);
		contentPane.add(PortaScelta);
	}
	
	public void registraEvento(CollegamentoFinestraMenu ottenitoreCose) {
		this.btnIniziaGioco.addActionListener(ottenitoreCose);
	}
	
	public void cambiaTesto() {
		this.btnIniziaGioco.setVisible(false);
	}
	
	public void finestraMenuChiusa() {
		this.setVisible(false);
	}
	
	public void finestraMenuAperta() {
		this.setVisible(true);
	}
	
	public String getIndirizzoIPCUston() {
		return indirozzoIP.toString();
	}
	
	public String getIndirizzoPortaCustom() {
		return portaIP.toString();
	}
	
	public JButton getIniziaGioco() {
		return btnIniziaGioco;
	}
}