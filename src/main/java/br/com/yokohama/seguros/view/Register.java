package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Telefone;
	private JTextField CPF;
	private JTextField Password;
	private JTextField email;
	private JButton Logar;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("TextComponent.arc", 15);
		UIManager.put( "Button.arc", 20 );
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1512,982);
		JPanel BackgroundAll = new JPanel();
		BackgroundAll.setBackground(new Color(255, 255, 255));
		BackgroundAll.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(BackgroundAll);
		
		JPanel Footer = new JPanel();
		Footer.setBounds(0, 641, 1370, 108);
		Footer.setAlignmentY(0.0f);
		Footer.setAlignmentX(0.0f);
		Footer.setBackground(new Color(127, 11, 11));
		
		Telefone = new JTextField();
		Telefone.setBounds(308, 386, 753, 40);
		Telefone.setColumns(10);
		
		CPF = new JTextField();
		CPF.setBounds(308, 315, 753, 40);
		CPF.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(308, 245, 753, 40);
		Password.setColumns(10);
		
		email = new JTextField();
		email.setBounds(308, 180, 753, 40);
		email.setColumns(10);
		
		Logar = new JButton("Cadastrar-se");
		Logar.setBounds(308, 457, 753, 40);
		Logar.setBorderPainted(false);
		Logar.setFont(new Font("Arial", Font.PLAIN, 20));
		Logar.setForeground(new Color(255, 255, 255));
		Logar.setBackground(new Color(127, 11, 11));
		
		JLabel logo = new JLabel("");
		logo.setBounds(-15, 0, 273, 174);
		logo.setBackground(new Color(255, 255, 255));
		logo.setIcon(new ImageIcon("C:\\Users\\labsfiap\\seguros-yokohama\\src\\main\\resources\\images\\image.png"));
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(308, 160, 44, 14);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setBounds(306, 231, 62, 14);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(308, 296, 24, 14);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(308, 366, 60, 14);
		
		lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setBounds(588, 46, 194, 61);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		BackgroundAll.setLayout(null);
		BackgroundAll.add(Footer);
		BackgroundAll.add(lblCpf);
		BackgroundAll.add(lblPassword);
		BackgroundAll.add(lblTelefone);
		BackgroundAll.add(lblNewLabel);
		BackgroundAll.add(logo);
		BackgroundAll.add(lblNewLabel_1);
		BackgroundAll.add(Logar);
		BackgroundAll.add(Password);
		BackgroundAll.add(CPF);
		BackgroundAll.add(Telefone);
		BackgroundAll.add(email);
	}
}
