package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.OttenitoreCose;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIniziaGioco = new JButton("Inizia Partita");
		btnIniziaGioco.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnIniziaGioco.setBounds(95, 65, 239, 103);
		contentPane.add(btnIniziaGioco);
		
		lblTitolo = new JLabel("Sasso/Carta/Forbice");
		lblTitolo.setForeground(Color.BLUE);
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBounds(10, 214, 414, 36);
		contentPane.add(lblTitolo);
		
		lblCaricamento = new JLabel("Caricamento...");
		lblCaricamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCaricamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaricamento.setBounds(95, 65, 239, 103);
		contentPane.add(lblCaricamento);
	}
	
	public void registraEvento(OttenitoreCose ottenitoreCose) {
		this.btnIniziaGioco.addActionListener(ottenitoreCose);
	}
	
	public void cambiaTesto() {
		
	}
}
