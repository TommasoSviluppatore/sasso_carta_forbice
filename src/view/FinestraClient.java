package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.io.*;
import javax.imageio.*;

public class FinestraClient extends JFrame {

	private JPanel contentPane;
	private JPanel pannelloInput;
	private JPanel pannelloOutput;
	private JLabel labelMessaggio;
	private JButton btnForbice;
	private JButton btnSasso;
	private JButton btnCarta;
	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pannelloInput = new JPanel();
		pannelloInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannelloInput.setBounds(12, 146, 424, 114);
		contentPane.add(pannelloInput);
		pannelloInput.setLayout(null);
		
		btnForbice = new JButton("Forbice");
		btnForbice.setBounds(22, 12, 110, 90);
		ImageIcon imagForbice=new ImageIcon(FinestraClient.class.getResource("/forbice.jpg"));
		this.btnForbice.setIcon(imagForbice);
		pannelloInput.add(btnForbice);
		
		btnSasso = new JButton("Sasso");
		btnSasso.setBounds(154, 12, 110, 90);
		ImageIcon imagSasso=new ImageIcon(FinestraClient.class.getResource("/sasso.jpg"));
		this.btnSasso.setIcon(imagSasso);
		pannelloInput.add(btnSasso);
		
		btnCarta = new JButton("Carta");
		btnCarta.setBounds(288, 12, 110, 90);
		ImageIcon imagCarta=new ImageIcon(FinestraClient.class.getResource("/carta.jpg"));
		this.btnCarta.setIcon(imagCarta);
		pannelloInput.add(btnCarta);
		
		pannelloOutput = new JPanel();
		pannelloOutput.setBounds(12, 12, 424, 122);
		contentPane.add(pannelloOutput);
		pannelloOutput.setLayout(null);
		
		labelMessaggio = new JLabel("Benvenuto! Seleziona la mossa da giocare");
		labelMessaggio.setHorizontalAlignment(SwingConstants.CENTER);
		labelMessaggio.setBounds(12, 53, 400, 15);
		pannelloOutput.add(labelMessaggio);
	}
	
	
}
