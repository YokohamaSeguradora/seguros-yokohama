package br.com.yokohama.seguros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MenuCliente extends JFrame {

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
					MenuCliente frame = new MenuCliente();
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
	
	public MenuCliente() {
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
		
		JLabel labelNome = new JLabel("Olá, Usuario!");
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
		
		JButton botaoFaturas = new JButton("Faturas");
		botaoFaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Faturas telaFaturas = new Faturas();
				telaFaturas.setVisible(true);
			}
		});
		botaoFaturas.setIcon(new ImageIcon(carregaImagen("/images/fatura.png")));
		botaoFaturas.setOpaque(false);
		botaoFaturas.setContentAreaFilled(false);
		botaoFaturas.setBorderPainted(false);
		botaoFaturas.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoFaturas.setHorizontalAlignment(SwingConstants.LEFT);
		botaoFaturas.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoFaturas.setBounds(54, 46, 101, 25);
		panelMenu.add(botaoFaturas);
		
		JLabel textOpções = new JLabel("Opções:");
		textOpções.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textOpções.setBounds(8, 9, 95, 26);
		panelMenu.add(textOpções);
		
		JButton botaoRelatorioSeguro = new JButton("Relatorio Seguro");
		botaoRelatorioSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botaoRelatorioSeguro.setIcon(new ImageIcon(carregaImagen("/images/documento.png")));
		botaoRelatorioSeguro.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoRelatorioSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		botaoRelatorioSeguro.setOpaque(false);
		botaoRelatorioSeguro.setContentAreaFilled(false);
		botaoRelatorioSeguro.setBorderPainted(false);
		botaoRelatorioSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoRelatorioSeguro.setBounds(54, 90, 165, 25);
		panelMenu.add(botaoRelatorioSeguro);
		
		JButton botaoAcionarSeguro = new JButton("Acionar seguro");
		botaoAcionarSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AcionarSinistro acionarSinistro = new AcionarSinistro();
				acionarSinistro.setVisible(true);
			}
		});
		botaoAcionarSeguro.setIcon(new ImageIcon(carregaImagen("/images/central.png")));
		botaoAcionarSeguro.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoAcionarSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		botaoAcionarSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoAcionarSeguro.setContentAreaFilled(false);
		botaoAcionarSeguro.setOpaque(false);
		botaoAcionarSeguro.setBorderPainted(false);
		botaoAcionarSeguro.setBounds(54, 134, 165, 25);
		panelMenu.add(botaoAcionarSeguro);
		
		JButton botaoEditarDadosDo = new JButton("Atualizar dados do auto");
		botaoEditarDadosDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AtualizaAuto atualizaAuto = new AtualizaAuto();
				atualizaAuto.setVisible(true);
			}
		});
		botaoEditarDadosDo.setIcon(new ImageIcon(carregaImagen("/images/refrescar.png")));
		botaoEditarDadosDo.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoEditarDadosDo.setHorizontalAlignment(SwingConstants.LEFT);
		botaoEditarDadosDo.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoEditarDadosDo.setOpaque(false);
		botaoEditarDadosDo.setContentAreaFilled(false);
		botaoEditarDadosDo.setBorderPainted(false);
		botaoEditarDadosDo.setBounds(54, 178, 216, 25);
		panelMenu.add(botaoEditarDadosDo);
		
		JButton botaoAtualizarMeusDados = new JButton("Meus dados");
		botaoAtualizarMeusDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AtualizaUsuario atualizaUsuario = new AtualizaUsuario();
				atualizaUsuario.setVisible(true);
			}
		});
		botaoAtualizarMeusDados.setIcon(new ImageIcon(carregaImagen("/images/utilizador.png")));
		botaoAtualizarMeusDados.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoAtualizarMeusDados.setHorizontalAlignment(SwingConstants.LEFT);
		botaoAtualizarMeusDados.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoAtualizarMeusDados.setOpaque(false);
		botaoAtualizarMeusDados.setContentAreaFilled(false);
		botaoAtualizarMeusDados.setBorderPainted(false);
		botaoAtualizarMeusDados.setBounds(54, 222, 246, 25);
		panelMenu.add(botaoAtualizarMeusDados);
		
		JButton botaooAtualizarInformaes = new JButton("Simular custo");
		botaooAtualizarInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SimulaSeguroCliente simulaSeguroCliente = new SimulaSeguroCliente();
				simulaSeguroCliente.setVisible(true);
			}
		});
		botaooAtualizarInformaes.setIcon(new ImageIcon(carregaImagen("/images/etiqueta.png")));
		botaooAtualizarInformaes.setVerticalAlignment(SwingConstants.BOTTOM);
		botaooAtualizarInformaes.setHorizontalAlignment(SwingConstants.LEFT);
		botaooAtualizarInformaes.setFont(new Font("Arial", Font.PLAIN, 14));
		botaooAtualizarInformaes.setOpaque(false);
		botaooAtualizarInformaes.setContentAreaFilled(false);
		botaooAtualizarInformaes.setBorderPainted(false);
		botaooAtualizarInformaes.setBounds(54, 266, 216, 25);
		panelMenu.add(botaooAtualizarInformaes);
		
		JButton botaoOpesDeSeguro = new JButton("Opções de seguro");
		botaoOpesDeSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpcoesSeguros opcoesSeguros = new OpcoesSeguros();
				opcoesSeguros.setVisible(true);
			}
		});
		botaoOpesDeSeguro.setIcon(new ImageIcon(carregaImagen("/images/lista.png")));
		botaoOpesDeSeguro.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoOpesDeSeguro.setHorizontalAlignment(SwingConstants.LEFT);
		botaoOpesDeSeguro.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoOpesDeSeguro.setOpaque(false);
		botaoOpesDeSeguro.setContentAreaFilled(false);
		botaoOpesDeSeguro.setBorderPainted(false);
		botaoOpesDeSeguro.setBounds(54, 310, 216, 25);
		panelMenu.add(botaoOpesDeSeguro);
		
		JButton botaoAtualizarMeusDados_1 = new JButton("Corretores proximos");
		botaoAtualizarMeusDados_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
				 VisualizarCorretores visualizarCorretores = new VisualizarCorretores();
				 visualizarCorretores.setVisible(true);
			}
		});
		botaoAtualizarMeusDados_1.setIcon(new ImageIcon(carregaImagen("/images/corretor.png")));
		botaoAtualizarMeusDados_1.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoAtualizarMeusDados_1.setHorizontalAlignment(SwingConstants.LEFT);
		botaoAtualizarMeusDados_1.setFont(new Font("Arial", Font.PLAIN, 14));
		botaoAtualizarMeusDados_1.setOpaque(false);
		botaoAtualizarMeusDados_1.setContentAreaFilled(false);
		botaoAtualizarMeusDados_1.setBorderPainted(false);
		botaoAtualizarMeusDados_1.setBounds(54, 354, 246, 25);
		panelMenu.add(botaoAtualizarMeusDados_1);
		
		JPanel icone = new JPanel();
		icone.setBounds(29, 40, 1, 330);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(29, 190, 20, 1);
		panelMenu.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(29, 235, 20, 1);
		panelMenu.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(29, 279, 20, 1);
		panelMenu.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(29, 322, 20, 1);
		panelMenu.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(29, 369, 20, 1);
		panelMenu.add(panel_7);
		
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
