package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import control.CollegamentoFinestraMenu;
import view.FinestraClient;

//fare due finestre 
public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnIniziaGioco;
	private JLabel lblTitolo,lblCaricamento,manoForbice,manoSasso, manoForbice_1;
	private JTextField portaIP, indirozzoIP;
	private boolean continua=true;
	private FinestraClient giocoMora;
	
	public boolean getContinua() {return this.continua;}
	

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
		btnIniziaGioco.setBounds(110, 108, 269, 103);
		contentPane.add(btnIniziaGioco);
		
		btnIniziaGioco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				continua=false;
				giocoMora.main(null);
			}
		});
		
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
		
		portaIP = new JTextField("8081");
		portaIP.setBounds(241, 22, 138, 36);
		contentPane.add(portaIP);
		portaIP.setColumns(10);
		
		indirozzoIP = new JTextField("127.0.0.1");
		indirozzoIP.setColumns(10);
		indirozzoIP.setBounds(91, 22, 138, 36);
		contentPane.add(indirozzoIP);
		
		JLabel PortaScelta = new JLabel("Porta");
		PortaScelta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		PortaScelta.setBounds(290, 3, 51, 22);
		contentPane.add(PortaScelta);
		
		JLabel ipIndirizzoScelta = new JLabel("Indirizzo IP");
		ipIndirizzoScelta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		ipIndirizzoScelta.setBounds(122, 0, 95, 22);
		contentPane.add(ipIndirizzoScelta);
	}
	
	public void registraEvento(CollegamentoFinestraMenu ottenitoreCose) {
		this.btnIniziaGioco.addActionListener(ottenitoreCose);
	}
	
	public void cambiaTesto() {
		this.btnIniziaGioco.setVisible(false);
	}
	
	public void finestraMenuChiusa() {
		this.setVisible(false);
		//JFrame finestraMenu = (JFrame) SwingUtilities.getWindowAncestor(menu);
		this.dispose();
		view.FinestraClient.main(null);
		giocoMora.main(null);
		
		//new Thread((Runnable) new view.FinestraClient()).start();
	}
	
	public void finestraMenuAperta() {
		this.setVisible(true);
	}
	
	public String getIndirizzoIPCustom() {
		return indirozzoIP.toString();
	}
	
	public String getIndirizzoPortaCustom() {
		return portaIP.toString();
	}
	
	public JButton getIniziaGioco() {
		return btnIniziaGioco;
	}
}