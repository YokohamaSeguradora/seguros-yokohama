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
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class AcionarSinistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loca;


	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 25);
		UIManager.put("CheckBox.background", Color.white);
		UIManager.put("TextComponent.arc", 10);
		UIManager.put("TitlePane.inactiveForeground", true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcionarSinistro frame = new AcionarSinistro();
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

	public AcionarSinistro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Bell Ringing 2.png"));
		lblNewLabel_1.setBounds(796, 176, 35, 40);
		contentPane.add(lblNewLabel_1);
		
		loca = new JTextField();
		loca.setBounds(314, 504, 118, 20);
		contentPane.add(loca);
		loca.setColumns(10);
		
		JButton fundoBtnLoc = new JButton("");
		fundoBtnLoc.setEnabled(false);
		fundoBtnLoc.setBackground(Color.WHITE);
		fundoBtnLoc.setBounds(268, 497, 208, 35);
		contentPane.add(fundoBtnLoc);
		
		JComboBox tpSevico = new JComboBox();
		tpSevico.setModel(new DefaultComboBoxModel(new String[] {"1 - Guincho", "2 - Policia", "3 - Samu", "4 - Bombeiros"}));
		tpSevico.setBounds(314, 452, 118, 21);
		contentPane.add(tpSevico);
		
		JButton fundoBtnTpSevico = new JButton("");
		fundoBtnTpSevico.setEnabled(false);
		fundoBtnTpSevico.setBackground(Color.WHITE);
		fundoBtnTpSevico.setBounds(268, 445, 208, 35);
		contentPane.add(fundoBtnTpSevico);
		
		JComboBox grauIntensidade = new JComboBox();
		grauIntensidade.setModel(new DefaultComboBoxModel(new String[] {"1 - Somente ajuda para rebocar veiculo", "2 - Ajuda para pessoas", "3 - Desvirar Carro", "4 - Apagar incendio"}));
		grauIntensidade.setBounds(314, 397, 118, 21);
		contentPane.add(grauIntensidade);
		
		JComboBox opcCusador = new JComboBox();
		opcCusador.setModel(new DefaultComboBoxModel(new String[] {"1 - Batida", "2 - Furto", "3 - Capotamento", "4 - Incendio"}));
		opcCusador.setBounds(314, 341, 118, 21);
		contentPane.add(opcCusador);
		
		JButton fundoBtnIntensidade = new JButton("");
		fundoBtnIntensidade.setEnabled(false);
		fundoBtnIntensidade.setBackground(Color.WHITE);
		fundoBtnIntensidade.setBounds(268, 390, 208, 35);
		contentPane.add(fundoBtnIntensidade);
		
		JButton fundoBtnCausador = new JButton("");
		fundoBtnCausador.setEnabled(false);
		fundoBtnCausador.setBackground(Color.WHITE);
		fundoBtnCausador.setBounds(268, 335, 208, 35);
		contentPane.add(fundoBtnCausador);
		
		JLabel lblLocalizao = new JLabel("Localização:");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLocalizao.setBounds(268, 477, 215, 23);
		contentPane.add(lblLocalizao);
		
		JLabel lblTipoDeSerivo = new JLabel("Tipo de serivço");
		lblTipoDeSerivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeSerivo.setBounds(268, 422, 215, 23);
		contentPane.add(lblTipoDeSerivo);
		
		JLabel loc = new JLabel("Grau de intensidade:");
		loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loc.setBounds(268, 366, 215, 23);
		contentPane.add(loc);
		
		JLabel causador = new JLabel("Evento Causador:");
		causador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		causador.setBounds(268, 314, 215, 23);
		contentPane.add(causador);
		
		JCheckBox não = new JCheckBox("Não");
		não.setBackground(Color.WHITE);
		não.setBounds(391, 284, 56, 23);
		contentPane.add(não);
		
		JCheckBox sim = new JCheckBox("Sim");
		sim.setBackground(new Color(255, 255, 255));
		sim.setBounds(314, 284, 56, 23);
		contentPane.add(sim);
		
		JButton fundoBtnAssociado = new JButton("");
		fundoBtnAssociado.setEnabled(false);
		fundoBtnAssociado.setBackground(new Color(255, 255, 255));
		fundoBtnAssociado.setBounds(268, 278, 208, 35);
		contentPane.add(fundoBtnAssociado);
		
		JLabel associado = new JLabel("O responsavel é um associado?");
		associado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		associado.setBounds(268, 254, 215, 23);
		contentPane.add(associado);
		
		JTextArea obsSinistro = new JTextArea();
		obsSinistro.setText("Observações:");
		obsSinistro.setBounds(667, 255, 408, 277);
		contentPane.add(obsSinistro);
		
		JLabel sinistro = new JLabel("Acionar sinistro");
		sinistro.setFont(new Font("Tahoma", Font.PLAIN, 35));
		sinistro.setBounds(556, 176, 238, 40);
		contentPane.add(sinistro);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		logo.setBounds(10, -13, 186, 120);
		contentPane.add(logo);
		
		JButton main = new JButton("");
		main.setEnabled(false);
		main.setBackground(new Color(255, 255, 255));
		main.setBounds(142, 227, 1066, 412);
		contentPane.add(main);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(carregaImagen("/images/Bell.png")));
		lblNewLabel.setBounds(793, 176, 35, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblAssit = new JLabel("Assitência 24Hrs");
		lblAssit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAssit.setBounds(142, 154, 140, 23);
		contentPane.add(lblAssit);
		
		JButton headerPage = new JButton("");
		headerPage.setBackground(new Color(255, 255, 255));
		headerPage.setEnabled(false);
		headerPage.setBounds(142, 176, 1066, 40);
		contentPane.add(headerPage);
	}
}
