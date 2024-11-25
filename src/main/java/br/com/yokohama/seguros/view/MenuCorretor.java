package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class MenuCorretor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 20);
		UIManager.put("Button.hoverForeground", Color.red);
		UIManager.put("Button.Button.pressedForeground", Color.white);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCorretor frame = new MenuCorretor();
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
			return ImageIO.read(AtualizaAuto.class.getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public MenuCorretor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel userIcone = new JLabel("New label");
		userIcone.setIcon(new ImageIcon(carregaImagen("/images/userLogo.png")));
		userIcone.setBounds(23, 38, 68, 64);
		contentPane.add(userIcone);

		JLabel labelNome = new JLabel("Olá, Corretor!");
		labelNome.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		labelNome.setBounds(97, 70, 242, 24);
		contentPane.add(labelNome);

		JLabel yohokamaLogo = new JLabel("");
		yohokamaLogo.setIcon(new ImageIcon(carregaImagen("/images/background.png")));
		yohokamaLogo.setBounds(480, 170, 520, 388);
		contentPane.add(yohokamaLogo);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(255, 255, 255));
		panelMenu.setBounds(23, 121, 249, 583);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		CarteiraCliente janelaCarteiraDeCLientes = new CarteiraCliente();
		JButton botaoCarteira = new JButton("Carteira de clientes");
		botaoCarteira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CarteiraCliente janelaCarteiraDeCLientes = new CarteiraCliente();
				janelaCarteiraDeCLientes.setVisible(true);
			}
		});
		botaoCarteira.setIcon(new ImageIcon(carregaImagen("/images/fatura.png")));
		botaoCarteira.setOpaque(false);
		botaoCarteira.setContentAreaFilled(false);
		botaoCarteira.setBorderPainted(false);
		botaoCarteira.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoCarteira.setHorizontalAlignment(SwingConstants.LEFT);
		botaoCarteira.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoCarteira.setBounds(54, 46, 185, 25);
		panelMenu.add(botaoCarteira);

		JLabel textOpções = new JLabel("Opções:");
		textOpções.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textOpções.setBounds(8, 9, 95, 26);
		panelMenu.add(textOpções);

		JButton botaoRelatorioSeguro = new JButton("Status das solicitações");
		botaoRelatorioSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StatusDeSolicitação statusDeSolicitação = new StatusDeSolicitação();
				statusDeSolicitação.setVisible(true);
			}
		});
		botaoRelatorioSeguro.setIcon(new ImageIcon(carregaImagen("/images/documento.png")));
		botaoRelatorioSeguro.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoRelatorioSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		botaoRelatorioSeguro.setOpaque(false);
		botaoRelatorioSeguro.setContentAreaFilled(false);
		botaoRelatorioSeguro.setBorderPainted(false);
		botaoRelatorioSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoRelatorioSeguro.setBounds(54, 90, 205, 25);
		panelMenu.add(botaoRelatorioSeguro);

		JButton botaoAcionarSeguro = new JButton("Simulações de seguros");
		botaoAcionarSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeguroPersonalizado seguroPersonalizado = new SeguroPersonalizado();
				seguroPersonalizado.setVisible(true);
			}
		});
		botaoAcionarSeguro.setIcon(new ImageIcon(carregaImagen("/images/simulacao.png")));
		botaoAcionarSeguro.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoAcionarSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		botaoAcionarSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoAcionarSeguro.setContentAreaFilled(false);
		botaoAcionarSeguro.setOpaque(false);
		botaoAcionarSeguro.setBorderPainted(false);
		botaoAcionarSeguro.setBounds(54, 134, 205, 25);
		panelMenu.add(botaoAcionarSeguro);

		JPanel icone = new JPanel();
		icone.setBounds(29, 40, 1, 107);
		panelMenu.add(icone);
		icone.setBackground(new Color(0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBounds(29, 60, 20, 1);
		panelMenu.add(panel);
		panel.setBackground(new Color(0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(29, 102, 20, 1);
		panelMenu.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(29, 147, 20, 1);
		panelMenu.add(panel_2);

		JButton menuLeft = new JButton("");
		menuLeft.setEnabled(false);
		menuLeft.setBounds(10, 11, 275, 707);
		contentPane.add(menuLeft);

		JButton Header = new JButton("");
		Header.setEnabled(false);
		Header.setBounds(295, 11, 1049, 48);
		contentPane.add(Header);

		JLabel iconeYoko = new JLabel("");
		iconeYoko.setBounds(1228, 624, 83, 68);
		contentPane.add(iconeYoko);
		iconeYoko.setIcon(new ImageIcon(carregaImagen("/images/yokoMenor.png")));

		JButton botaoYoko = new JButton("");
		botaoYoko.setBounds(1228, 624, 83, 68);
		contentPane.add(botaoYoko);
		botaoYoko.setOpaque(false);
		botaoYoko.setContentAreaFilled(false);
		botaoYoko.setBorderPainted(false);
	}
}
