package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoEmail;
	private JButton BotaoProximo;
	private JLabel labelEmail;
	private JLabel lblPassword;
	private JLabel lblCpf;
	private JLabel labelTelefone;
	private JLabel lblNewLabel_1;
	private JTextField campoSenha;
	private JTextField campoCpf;
	private JTextField campoTelefone;
	private JTextField campoNome;
	private JTextField campoEndereco;
	private JTextField campoNomeSocial;
	private JLabel lableNomeSocial;
	private JTextField campoCNH;
	private JLabel lableCNH;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		//UIManager.put("CheckBox.background", Color.darkGray);)
		UIManager.put("TextComponent.arc", 15);
		UIManager.put( "Button.arc", 20 );
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Metodo para carregar imagens
	public BufferedImage carregaImagen(String str) {
		try {
			return ImageIO.read(Register.class.getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366,768);
		JPanel BackgroundAll = new JPanel();
		BackgroundAll.setBackground(new Color(255, 255, 255));
		BackgroundAll.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(BackgroundAll);
		
		JPanel Footer = new JPanel();
		Footer.setBounds(0, 641, 1370, 108);
		Footer.setAlignmentY(0.0f);
		Footer.setAlignmentX(0.0f);
		Footer.putClientProperty("JPanel.arc", 20);
		Footer.setBackground(new Color(127, 11, 11));
		
		campoEmail = new JTextField();
		campoEmail.setBounds(154, 175, 522, 40);
		campoEmail.setColumns(10);
		
		BotaoProximo = new JButton("Continuar");
		BotaoProximo.setBounds(563, 554, 223, 40);
		BotaoProximo.setBorderPainted(false);
		BotaoProximo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotaoProximo.setForeground(new Color(255, 255, 255));
		BotaoProximo.setBackground(new Color(127, 11, 11));
		
		labelEmail = new JLabel("Email");
		labelEmail.setBounds(154, 160, 44, 14);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setBounds(154, 236, 62, 14); 
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(154, 310, 24, 14);
		
		labelTelefone = new JLabel("Telefone");
		labelTelefone.setBounds(702, 236, 60, 14);
		
		lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setBounds(577, 53, 194, 61);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		BackgroundAll.setLayout(null);
		
		lableNomeSocial = new JLabel("Nome social");
		lableNomeSocial.setBounds(702, 236, 130, 14);
		BackgroundAll.add(lableNomeSocial);
		
		campoNomeSocial = new JTextField();
		campoNomeSocial.setColumns(10);
		campoNomeSocial.setBounds(702, 251, 522, 40);
		BackgroundAll.add(campoNomeSocial);
		BackgroundAll.add(Footer);
		BackgroundAll.add(lblCpf);
		BackgroundAll.add(lblPassword);
		BackgroundAll.add(labelTelefone);
		BackgroundAll.add(labelEmail);
		BackgroundAll.add(lblNewLabel_1);
		BackgroundAll.add(BotaoProximo);
		BackgroundAll.add(campoEmail);
		
		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(154, 251, 522, 40);
		BackgroundAll.add(campoSenha);
		
		campoCpf = new JTextField();
		campoCpf.setColumns(10);
		campoCpf.setBounds(154, 327, 522, 40);
		BackgroundAll.add(campoCpf);
		
		campoTelefone = new JTextField();
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(702, 251, 522, 40);
		BackgroundAll.add(campoTelefone);
		
		JLabel yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		BackgroundAll.add(yokohamaLogo);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(702, 175, 522, 40);
		BackgroundAll.add(campoNome);
		
		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(702, 327, 522, 40);
		BackgroundAll.add(campoEndereco);
		
		JLabel labelNomeCompleto = new JLabel("Nome completo");
		labelNomeCompleto.setBounds(702, 160, 130, 14);
		BackgroundAll.add(labelNomeCompleto);
		
		JLabel labelEndereco = new JLabel("Endereço completo ");
		labelEndereco.setBounds(702, 310, 130, 14);
		BackgroundAll.add(labelEndereco);
		
		JCheckBox checkSocial = new JCheckBox("Nome social?");
		checkSocial.setBounds(702, 214, 150, 23);
		BackgroundAll.add(checkSocial);
		campoNomeSocial.setVisible(false);
		lableNomeSocial.setVisible(false);
		
		campoCNH = new JTextField();
		campoCNH.setColumns(10);
		campoCNH.setBounds(702, 465, 522, 40);
		BackgroundAll.add(campoCNH);
		
		lableCNH = new JLabel("CNH");
		lableCNH.setBounds(702, 450, 150, 14);
		BackgroundAll.add(lableCNH);
		lableCNH.setVisible(false);
    	campoCNH.setVisible(false);
    	
		checkSocial.addActionListener(e -> {
		    if (checkSocial.isSelected()) {
		    	
		    	campoTelefone.setBounds(702, 327, 522, 40);
				campoEndereco.setBounds(702, 399, 522, 40);
				labelEndereco.setBounds(702, 383, 130, 14);
		    	labelTelefone.setBounds(702, 310, 60, 14);
		    	campoNomeSocial.setVisible(checkSocial.isSelected());
		    	lableNomeSocial.setVisible(checkSocial.isSelected());
		    	lableCNH.setVisible(checkSocial.isSelected());
		    	campoCNH.setVisible(checkSocial.isSelected());
		
		    } else {
		    	labelTelefone.setBounds(702, 236, 60, 14);
		    	labelEndereco.setBounds(702, 310, 130, 14);
				campoTelefone.setBounds(702, 251, 522, 40);
				campoEndereco.setBounds(702, 327, 522, 40);
				lableNomeSocial.setVisible(checkSocial.isSelected());
				campoNomeSocial.setVisible(checkSocial.isSelected());
				lableCNH.setVisible(false);
		    	campoCNH.setVisible(false);
		    	campoCNH.setText("");
		    	campoNomeSocial.setText("");
		    }
		});
		

	
	}
}