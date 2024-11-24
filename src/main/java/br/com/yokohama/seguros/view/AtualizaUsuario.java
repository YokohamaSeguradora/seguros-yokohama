package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.ImageIcon;

import br.com.yokohama.seguros.controller.UsuarioController;

public class AtualizaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCelular;
	private JTextField campoEmail;
	private JTextField campoEndereco;

	private UsuarioController usuarioController;
	

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 25);
		UIManager.put("Button.hoverBackground", new Color(218, 76, 76));
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Button.arc", 20);
		UIManager.put("Button.hoverBackground", new Color(105, 7, 7));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizaUsuario frame = new AtualizaUsuario();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Metodo para carregar imagens
	public BufferedImage carregaImagen(String str) {
		try {
			return ImageIO.read(AtualizaUsuario.class.getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public AtualizaUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoEndereco = new JTextField();
		campoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(60, 335, 387, 41);
		contentPane.add(campoEndereco);

		JLabel labelNumeroUsuario = new JLabel("128371240902-27");
		labelNumeroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelNumeroUsuario.setBounds(135, 245, 229, 14);
		contentPane.add(labelNumeroUsuario);

		JLabel labelNomeUsuario = new JLabel("Zé Ninguem da SIlva");
		labelNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNomeUsuario.setBounds(135, 213, 317, 25);
		contentPane.add(labelNomeUsuario);

		JLabel labelPerfilImagem = new JLabel("");
		labelPerfilImagem.setIcon(new ImageIcon(carregaImagen("/images/perfil.png")));
		labelPerfilImagem.setBounds(60, 205, 73, 62);
		contentPane.add(labelPerfilImagem);

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoEmail.setColumns(10);
		campoEmail.setBounds(56, 552, 387, 41);
		contentPane.add(campoEmail);

		campoCelular = new JTextField();
		campoCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCelular.setColumns(10);
		campoCelular.setBounds(56, 447, 387, 41);
		contentPane.add(campoCelular);

		JLabel labelMeusDados = new JLabel("Meus dados");
		labelMeusDados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMeusDados.setBounds(60, 132, 159, 46);
		contentPane.add(labelMeusDados);

		JButton botaoAlterar04 = new JButton("Alterar");
		botaoAlterar04.setForeground(Color.WHITE);
		botaoAlterar04.setBorderPainted(false);
		botaoAlterar04.setBackground(new Color(127, 11, 11));
		botaoAlterar04.setBounds(906, 556, 101, 32);
		contentPane.add(botaoAlterar04);

		JButton botaoAlterar02 = new JButton("Alterar");
		botaoAlterar02.setForeground(Color.WHITE);
		botaoAlterar02.setBorderPainted(false);
		botaoAlterar02.setBackground(new Color(127, 11, 11));
		botaoAlterar02.setBounds(906, 451, 101, 32);
		contentPane.add(botaoAlterar02);

		JButton botaoAlterar01 = new JButton("Alterar");
		botaoAlterar01.setForeground(Color.WHITE);
		botaoAlterar01.setBorderPainted(false);
		botaoAlterar01.setBackground(new Color(127, 11, 11));
		botaoAlterar01.setBounds(906, 340, 101, 32);
		contentPane.add(botaoAlterar01);

		JButton alterarSenha = new JButton("Alterar senha");
		alterarSenha.setIcon(new ImageIcon(this.carregaImagen("/images/cadeado.png")));
		alterarSenha.setSelectedIcon(new ImageIcon("C:\\Users\\thibas\\Downloads\\perfil.png"));
		alterarSenha.setBorderPainted(false);
		alterarSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alterarSenha.setForeground(new Color(255, 255, 255));
		alterarSenha.setBackground(new Color(127, 11, 11));
		alterarSenha.setBounds(534, 640, 281, 52);
		contentPane.add(alterarSenha);

		JButton fundo04 = new JButton("");
		fundo04.setEnabled(false);
		fundo04.setBounds(40, 426, 1000, 81);
		contentPane.add(fundo04);

		JButton fundo03 = new JButton("");
		fundo03.setEnabled(false);
		fundo03.setBounds(40, 314, 1000, 81);
		contentPane.add(fundo03);

		JButton fundo02 = new JButton("");
		fundo02.setEnabled(false);
		fundo02.setBounds(40, 195, 752, 81);
		contentPane.add(fundo02);

		JButton fundo01 = new JButton("");
		fundo01.setEnabled(false);
		fundo01.setBounds(40, 133, 500, 46);

		contentPane.add(fundo01);

		JButton fundo05 = new JButton("");
		fundo05.setEnabled(false);
		fundo05.setBounds(40, 533, 1000, 81);
		contentPane.add(fundo05);

		JLabel labelEndereco = new JLabel("Endereço");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelEndereco.setBounds(50, 278, 159, 46);
		contentPane.add(labelEndereco);

		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCelular.setBounds(50, 390, 159, 46);
		contentPane.add(labelCelular);

		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelEmail.setBounds(50, 498, 159, 46);
		contentPane.add(labelEmail);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 180, 159, 46);
		contentPane.add(lblNewLabel_1);

		JLabel yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		contentPane.add(yokohamaLogo);

		JLabel yokoLabel = new JLabel("");
		yokoLabel.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
		yokoLabel.setBounds(1183, 496, 126, 118);
		contentPane.add(yokoLabel);

		JButton yokoButton = new JButton("yoko");
		yokoButton.setBounds(1208, 498, 101, 97);
		yokoButton.setOpaque(false);
		yokoButton.setContentAreaFilled(false);
		yokoButton.setBorderPainted(false);
		contentPane.add(yokoButton);
	}
}
