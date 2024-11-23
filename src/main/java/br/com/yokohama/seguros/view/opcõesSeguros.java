package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class opcõesSeguros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 15);
		UIManager.put("Button.arc", 15);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opcõesSeguros frame = new opcõesSeguros();
					frame.setLocationRelativeTo(null);
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
	public opcõesSeguros() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("");
		lblNewLabel_2_3_1.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\icon.png"));
		lblNewLabel_2_3_1.setBounds(515, 513, 68, 42);
		contentPane.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Truck.png"));
		lblNewLabel_2_3.setBounds(505, 448, 68, 42);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Transfer Motorcycle.png"));
		lblNewLabel_2_2.setBounds(548, 377, 61, 54);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Car.png"));
		lblNewLabel_2.setBounds(548, 318, 61, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Moto");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(127, 11, 11));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_1.setBounds(515, 377, 275, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Caminhão");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(new Color(127, 11, 11));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_1_1.setBounds(515, 442, 275, 54);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Bicicleta");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setForeground(new Color(127, 11, 11));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_1_1_1.setBounds(515, 507, 275, 54);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblCarro = new JLabel("Carro");
		lblCarro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarro.setForeground(new Color(127, 11, 11));
		lblCarro.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCarro.setBounds(515, 312, 275, 54);
		contentPane.add(lblCarro);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione o seguro desejado:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(574, 278, 195, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Seguros");
		lblNewLabel.setForeground(new Color(127, 11, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(527, 213, 275, 54);
		contentPane.add(lblNewLabel);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\logo.png"));
		logo.setBounds(-23, 0, 202, 107);
		contentPane.add(logo);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(255, 255, 255));
		header.setBounds(0, 0, 1366, 107);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel sino = new JLabel("");
		sino.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Bell Ringing 01.png"));
		sino.setBounds(1284, 35, 35, 35);
		header.add(sino);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setForeground(new Color(127, 11, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(306, 213, 718, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(527, 278, 295, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(new Color(127, 11, 11));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(306, 312, 718, 54);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setForeground(new Color(127, 11, 11));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(306, 377, 718, 54);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setForeground(new Color(127, 11, 11));
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(306, 442, 718, 54);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("");
		btnNewButton_3_1_1.setForeground(new Color(127, 11, 11));
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setBounds(306, 507, 718, 54);
		contentPane.add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\yoko.png"));
		lblNewLabel_3.setBounds(1214, 389, 126, 107);
		contentPane.add(lblNewLabel_3);
	}
}
