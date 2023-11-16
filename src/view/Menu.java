package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import control.CollegamentoFinestraMenu;
import view.FinestraClient;
import model.Client;
import model.Server;

//fare due finestre 
public class Menu extends JFrame {
	/**<p>questa finestra è il menu, ottiene
	 * l'indirizzo ip e la porta</p>*/

	private JPanel contentPane;
	private JButton btnIniziaGioco;
	private JLabel lblTitolo,lblCaricamento,manoForbice,manoSasso, manoForbice_1;
	private JTextField portaIP, indirozzoIP;
	private boolean continua=true;
	private FinestraClient giocoMora;
	private Client proseguigioco;
	private Server gestoreGioco;
	private JLabel lblManoSasso;
	private JLabel lblManoCarta;
	private JLabel lblManoForbice;
	
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
		setBounds(100, 100, 680, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIniziaGioco = new JButton("Inizia Partita");
		btnIniziaGioco.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnIniziaGioco.setBounds(175, 115, 310, 146);
		contentPane.add(btnIniziaGioco);
		
		btnIniziaGioco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*continua=false;*/
				proseguigioco.puoiProseguire(true);
				gestoreGioco.puoiProseguire(true);
				giocoMora.main(null);
			}
		});
		
		lblTitolo = new JLabel("Sasso/Carta/Forbice");
		lblTitolo.setForeground(Color.BLUE);
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBounds(10, 464, 644, 36);
		contentPane.add(lblTitolo);
		
		lblCaricamento = new JLabel("Caricamento...");
		lblCaricamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCaricamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaricamento.setBounds(208, 143, 221, 99);
		contentPane.add(lblCaricamento);
		
		portaIP = new JTextField("8081");
		portaIP.setBounds(362, 22, 138, 36);
		contentPane.add(portaIP);
		portaIP.setColumns(10);
		
		indirozzoIP = new JTextField("127.0.0.1");
		indirozzoIP.setColumns(10);
		indirozzoIP.setBounds(150, 22, 138, 36);
		contentPane.add(indirozzoIP);
		
		JLabel PortaScelta = new JLabel("Porta");
		PortaScelta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		PortaScelta.setBounds(409, 0, 51, 22);
		contentPane.add(PortaScelta);
		
		JLabel ipIndirizzoScelta = new JLabel("Indirizzo IP");
		ipIndirizzoScelta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		ipIndirizzoScelta.setBounds(175, 0, 95, 22);
		contentPane.add(ipIndirizzoScelta);
		
		lblManoSasso = new JLabel("");
		lblManoSasso.setBounds(0, 143, 104, 164);
		ImageIcon imagManoSasso=new ImageIcon(FinestraClient.class.getResource("/immagineManoSasso.jpg"));
		this.lblManoSasso.setIcon(imagManoSasso);
		contentPane.add(lblManoSasso);
		
		lblManoCarta = new JLabel("");
		lblManoCarta.setBounds(542, 130, 122, 198);
		ImageIcon imagManoCarta=new ImageIcon(FinestraClient.class.getResource("/immagineManoCarta.jpg"));
		this.lblManoCarta.setIcon(imagManoCarta);
		contentPane.add(lblManoCarta);
		
		lblManoForbice = new JLabel("");
		lblManoForbice.setBounds(275, 295, 104, 216);
		ImageIcon imagManoForbice=new ImageIcon(FinestraClient.class.getResource("/immagineManoForbice.jpg"));
		this.lblManoForbice.setIcon(imagManoForbice);
		contentPane.add(lblManoForbice);
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