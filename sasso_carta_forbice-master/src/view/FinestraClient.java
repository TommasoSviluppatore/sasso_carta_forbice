package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.io.*;
import javax.imageio.*;
import control.OttenitoreCose;

public class FinestraClient extends JFrame {

	private JPanel contentPane, pannelloInput, pannelloOutput;
	private JLabel labelMessaggio;
	private JButton btnForbice, btnSasso, btnCarta;
	
	private String contenuto1, contenuto2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraClient frame = new FinestraClient();
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
	public FinestraClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pannelloInput = new JPanel();
		pannelloInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannelloInput.setBounds(12, 146, 412, 115);
		contentPane.add(pannelloInput);
		pannelloInput.setLayout(null);
		
		btnForbice = new JButton("Forbice");
		btnForbice.setBounds(10, 12, 110, 90);
		ImageIcon imagForbice=new ImageIcon(FinestraClient.class.getResource("/forbice.jpg"));
		this.btnForbice.setIcon(imagForbice);
		pannelloInput.add(btnForbice);
		
		btnSasso = new JButton("Sasso");
		btnSasso.setBounds(152, 12, 110, 90);
		ImageIcon imagSasso=new ImageIcon(FinestraClient.class.getResource("/sasso.jpg"));
		this.btnSasso.setIcon(imagSasso);
		pannelloInput.add(btnSasso);
		
		btnCarta = new JButton("Carta");
		btnCarta.setBounds(292, 12, 110, 90);
		ImageIcon imagCarta=new ImageIcon(FinestraClient.class.getResource("/carta.jpg"));
		this.btnCarta.setIcon(imagCarta);
		pannelloInput.add(btnCarta);
		
		pannelloOutput = new JPanel();
		pannelloOutput.setBounds(12, 12, 412, 122);
		contentPane.add(pannelloOutput);
		pannelloOutput.setLayout(null);
		
		labelMessaggio = new JLabel("Benvenuto! Seleziona la mossa da giocare");
		labelMessaggio.setHorizontalAlignment(SwingConstants.CENTER);
		labelMessaggio.setBounds(12, 53, 400, 15);
		pannelloOutput.add(labelMessaggio);
	}
	
	public JButton ritornaCarta(){return btnCarta;}
	public JButton ritornaSasso(){return btnSasso;}
	public JButton ritornaForbice(){return btnForbice;}
	
	public void registraEvento(OttenitoreCose controller) {
		// TODO Auto-generated method stub
		this.btnCarta.addActionListener(controller);
		this.btnSasso.addActionListener(controller);
		this.btnForbice.addActionListener(controller);
	}
	
	public void setContenuto1(String a) { this.labelMessaggio.setText(a); }
	public void setContenuto2(String a) { this.contenuto1=a; }
	public String getContenuto1() { return labelMessaggio.getText(); }
	public String getContenuto2() { return contenuto1; }
	
	
	
}
