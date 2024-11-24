package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import com.formdev.flatlaf.FlatLightLaf;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField campoEmail;
	private JPasswordField campoSenha;
	private JButton myButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		//UIManager.put("Button.arc", 99);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366,768);		
		//UIManager.put("Button.hoverForeground", Color.red);
		UIManager.put("Button.arc", 25 );
		UIManager.put("Button.hoverBackground", new Color(218, 76,76));
		UIManager.put("TextComponent.arc", 20);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 0, 0, 0));

		setContentPane(contentPane);
		
		JPanel fotter = new JPanel();
		fotter.setBounds(0, 624, 1350, 105);
		fotter.setBackground(new Color(127, 11, 11));
		contentPane.setLayout(null);
		contentPane.add(fotter);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(399, 163, 42, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(398, 255, 71, 25);
		contentPane.add(lblNewLabel);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(398, 199, 554, 37);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(398, 291, 553, 37);
		contentPane.add(campoSenha);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Arial", Font.ITALIC, 40));
		loginLabel.setBounds(617, 50, 115, 65);
		contentPane.add(loginLabel);
		
		JButton forgotButton = new JButton("Forgot Password?");
		forgotButton.addMouseListener(new MouseAdapter() {
			
			public void mouseExit(MouseEvent E) {
				forgotButton.setForeground(Color.red);
				UIManager.put("Button.hoverForeground", Color.red);

			}
			
			public void mousetExit(MouseEvent E) {
				forgotButton.setForeground(Color.white);
				UIManager.put("Button.hoverForeground", Color.white);

			}
			
		});
			
		
		forgotButton.setOpaque(false);
		forgotButton.setContentAreaFilled(false);
		forgotButton.setBorderPainted(false);
		forgotButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		forgotButton.setBounds(388, 395, 119, 23);
		contentPane.add(forgotButton);
		
		JButton signInButton = new JButton("Sign In");
		signInButton.setForeground(new Color(255, 255, 255));
		signInButton.setBackground(new Color(127, 11, 11));
		signInButton.setBounds(398, 351, 554, 33);
		contentPane.add(signInButton);

		signInButton.addActionListener(e -> {
			if (campoEmail.getText().trim().isEmpty() || campoSenha.getPassword().length == 0) {
				javax.swing.JOptionPane.showMessageDialog(this,
					"Por favor, preencha os campos de Email e Senha.",
					"Erro de validação",
					javax.swing.JOptionPane.ERROR_MESSAGE);
			} else {
				// Se os campos estão preenchidos, prossegue para a próxima tela
				SimulaSeguroCliente simulaSeguro = new SimulaSeguroCliente();
				simulaSeguro.setVisible(true);
				dispose(); // Fecha a tela de login
			}
		});
		
		
		myButton = new JButton("");
		myButton.setEnabled(false);
		myButton.setBackground(Color.WHITE);
		myButton.setBounds(356, 151, 637, 336);
		contentPane.add(myButton);
	}
}
