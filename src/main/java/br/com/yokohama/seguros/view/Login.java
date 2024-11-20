package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.ui.FlatButtonUI;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 1512, 982);
		UIManager.put("Button.hoverForeground", Color.RED);
		UIManager.put("Button.arc", 25 );
		UIManager.put("Button.hoverBackground", new Color(218, 76,76));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 0, 0, 0));

		setContentPane(contentPane);
		
		JPanel fotter = new JPanel();
		fotter.setBounds(0, 765, 1496, 178);
		fotter.setBackground(new Color(127, 11, 11));
		contentPane.setLayout(null);
		contentPane.add(fotter);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(464, 293, 42, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(464, 520, 71, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(464, 329, 553, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(464, 428, 553, 37);
		contentPane.add(textField_1);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Arial", Font.ITALIC, 40));
		loginLabel.setBounds(690, 114, 115, 65);
		contentPane.add(loginLabel);
		
		JButton forgotPassword = new JButton("Forgot Password?");
		forgotPassword.putClientProperty("JButton.hoverForeground", Color.red);
		forgotPassword.setOpaque(false);
		forgotPassword.setContentAreaFilled(false);
		forgotPassword.setBorderPainted(false);
		forgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		forgotPassword.setBounds(449, 400, 119, 23);
		contentPane.add(forgotPassword);
		
		JButton myButton = new JButton("");
		myButton.setEnabled(false);
		myButton.setBackground(Color.WHITE);
		myButton.setBounds(429, 224, 637, 336);
		contentPane.add(myButton);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(662, 476, 89, 23);
		contentPane.add(btnNewButton);
	}
}
