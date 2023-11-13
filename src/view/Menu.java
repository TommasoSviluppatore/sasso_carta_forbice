package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.OttenitoreCose;
import control.OttenitoreCoseFinestraIniziale;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnIniziaGioco;
	private JLabel lblTitolo;
	private JLabel lblCaricamento;
	private JLabel manoForbice;
	private JLabel manoSasso;
	private JLabel manoForbice_1;

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
		btnIniziaGioco.setBounds(148, 93, 221, 103);
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
		lblCaricamento.setBounds(148, 99, 221, 99);
		contentPane.add(lblCaricamento);
		
		manoForbice = new JLabel("");
		manoForbice.setBounds(0, 126, 113, 127);
		contentPane.add(manoForbice);
		
		manoSasso = new JLabel("");
		manoSasso.setBounds(185, 0, 129, 88);
		contentPane.add(manoSasso);
		
		manoForbice_1 = new JLabel("");
		manoForbice_1.setBounds(401, 126, 113, 127);
		contentPane.add(manoForbice_1);
	}
	
	public void registraEvento(OttenitoreCoseFinestraIniziale ottenitoreCose) {
		this.btnIniziaGioco.addActionListener(ottenitoreCose);
	}
	
	public void mostraCaricamento() {
		this.btnIniziaGioco.setVisible(false);
	}
	
	public void finestraMenuChiusa() {
		this.setVisible(false);
	}
	
	public void finestraMenuAperta() {
		this.setVisible(true);
	}
}
