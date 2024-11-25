package br.com.yokohama.seguros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class SimulaSeguroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeCompleto;
	private JPanel contentPane;
	private JTextField campoEmail;
	private JTextField campoCelular;
	private JTextField campoCPF;
	private JTextField campoPerNoite;
	private JTextField campoNomeSocial;

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 25);
		UIManager.put("Button.hoverBackground", new Color(218, 76, 76));
		UIManager.put("Button.arc", 15);
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Button.hoverBackground", new Color(105, 7, 7));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulaSeguroCliente frame = new SimulaSeguroCliente();
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

	public SimulaSeguroCliente() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton botaoEscondido = new JButton("");
		botaoEscondido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNomeCompleto.setText("Carlos andrade");
				campoEmail.setText("grupoyokohama@email.com");
				campoCPF.setText("660.059.980-48");
				campoCelular.setText("11-7878878778");
				campoPerNoite.setText("04004-902");

			}
		});

		JButton botaoNomeSocial = new JButton("Nome Social?");
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setVisible(false);

		botaoNomeSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNomeSocial.setVisible(true);
				botaoRemover.setVisible(true);
				botaoNomeSocial.setVisible(false);
			}
		});

		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNomeSocial.setVisible(false);
				botaoNomeSocial.setVisible(true);
				botaoRemover.setVisible(false);
				campoNomeSocial.setText("");

			}
		});
		botaoRemover.setIcon(new ImageIcon(carregaImagen("/images/menos.png")));
		botaoRemover.setOpaque(false);
		botaoRemover.setContentAreaFilled(false);
		botaoRemover.setBorderPainted(false);
		botaoRemover.setBounds(314, 280, 135, 20);
		botaoRemover.setVisible(false);
		contentPane.add(botaoRemover);
		botaoNomeSocial.setIcon(new ImageIcon(carregaImagen("/images/mais.png")));
		botaoNomeSocial.setOpaque(false);
		botaoNomeSocial.setContentAreaFilled(false);
		botaoNomeSocial.setBorderPainted(false);
		botaoNomeSocial.setBounds(314, 280, 135, 20);
		contentPane.add(botaoNomeSocial);
		botaoEscondido.setOpaque(false);
		botaoEscondido.setContentAreaFilled(false);
		botaoEscondido.setBorderPainted(false);
		botaoEscondido.setBounds(41, 4, 101, 97);
		contentPane.add(botaoEscondido);

		JLabel yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		contentPane.add(yokohamaLogo);

		JLabel iconeYoku = new JLabel("");
		iconeYoku.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
		iconeYoku.setBounds(607, 4, 135, 103);
		contentPane.add(iconeYoku);

		campoPerNoite = new JTextField();
		campoPerNoite.setOpaque(false);
		campoPerNoite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoPerNoite.setColumns(10);
		campoPerNoite.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		campoPerNoite.setBounds(730, 407, 189, 20);
		contentPane.add(campoPerNoite);

		campoCPF = new JTextField();
		campoCPF.setOpaque(false);
		campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCPF.setColumns(10);
		campoCPF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		campoCPF.setBounds(360, 407, 189, 20);
		contentPane.add(campoCPF);

		campoCelular = new JTextField();
		campoCelular.setOpaque(false);
		campoCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCelular.setColumns(10);
		campoCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		campoCelular.setBounds(911, 253, 189, 20);
		contentPane.add(campoCelular);

		campoEmail = new JTextField();
		campoEmail.setOpaque(false);
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEmail.setColumns(10);
		campoEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		campoEmail.setBounds(544, 253, 189, 20);
		contentPane.add(campoEmail);

		campoNomeCompleto = new JTextField();
		campoNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNomeCompleto.setOpaque(false);
		campoNomeCompleto.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		campoNomeCompleto.setBounds(179, 253, 189, 20);
		contentPane.add(campoNomeCompleto);
		campoNomeCompleto.setColumns(10);

		JLabel lblCepPernoiteDo = new JLabel("CEP pernoite do veículo:");
		lblCepPernoiteDo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCepPernoiteDo.setBounds(730, 386, 210, 20);
		contentPane.add(lblCepPernoiteDo);

		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCelular.setBounds(911, 231, 147, 20);
		contentPane.add(labelCelular);

		JLabel labelEmail = new JLabel("E-MAIL:");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelEmail.setBounds(544, 231, 147, 20);
		contentPane.add(labelEmail);

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCPF.setBounds(360, 386, 147, 20);
		contentPane.add(labelCPF);

		JLabel labelNome = new JLabel("Nome Completo:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNome.setBounds(179, 231, 147, 20);
		contentPane.add(labelNome);

		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(534, 224, 282, 79);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(167, 224, 282, 79);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(901, 224, 282, 79);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(350, 378, 282, 79);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_5_1 = new JButton("");
		btnNewButton_5_1.setEnabled(false);
		btnNewButton_5_1.setBounds(718, 378, 282, 79);
		contentPane.add(btnNewButton_5_1);

		JButton botaoContinuar = new JButton("Continuar");
		botaoContinuar.setBorderPainted(false);
		botaoContinuar.setBackground(new Color(127, 11, 11));
		botaoContinuar.setForeground(Color.white);
		botaoContinuar.setBounds(607, 507, 135, 35);
		contentPane.add(botaoContinuar);

		JCheckBox checkBoxAceito = new JCheckBox("Aceito que a Yokohama seguros me envie mensagem!");
		checkBoxAceito.setBounds(524, 474, 327, 23);
		contentPane.add(checkBoxAceito);

		JPanel fotter = new JPanel();
		fotter.setBackground(new Color(127, 11, 11));
		fotter.setBounds(152, 137, 1045, 3);
		contentPane.add(fotter);

		JLabel labelInsiraDados = new JLabel("Insira seus dados para inciar a cotação!");
		labelInsiraDados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelInsiraDados.setBounds(445, 147, 459, 29);
		contentPane.add(labelInsiraDados);

		JLabel labelSouYoku = new JLabel("Olá, Eu sou a Yoko e vou te ajudar na cotação do seu seguro!");
		labelSouYoku.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelSouYoku.setBounds(325, 100, 700, 29);
		contentPane.add(labelSouYoku);

		JButton yokoButton = new JButton("yoko");
		yokoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatBot chat = new ChatBot();
				chat.setVisible(true);
			}
		});
		yokoButton.setOpaque(false);
		yokoButton.setContentAreaFilled(false);
		yokoButton.setBorderPainted(false);
		yokoButton.setBounds(624, 4, 101, 97);
		contentPane.add(yokoButton);

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNomeSocial.setVisible(true);
			}
		});
		botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBack.png")));
		botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setBackground(new Color(127, 11, 11));
		botaoVoltar.setBounds(-5, 135, 35, 111);
		contentPane.add(botaoVoltar);

		campoNomeSocial = new JTextField();
		campoNomeSocial.setBackground(new Color(240, 240, 240));
		campoNomeSocial.setBounds(248, 310, 201, 20);
		campoNomeSocial.setVisible(false);
		contentPane.add(campoNomeSocial);
		campoNomeSocial.setColumns(10);

	}
}
