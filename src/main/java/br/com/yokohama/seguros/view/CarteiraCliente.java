package br.com.yokohama.seguros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

public class CarteiraCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 15);
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("TableHeader.background", new Color(246, 246, 246));
		UIManager.put("TableHeader.separatorColor", new Color(246, 246, 246));
		UIManager.put("TableHeader.bottomSeparatorColor", new Color(246, 246, 246));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarteiraCliente frame = new CarteiraCliente();
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
	
	public CarteiraCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel yokoLabel = new JLabel("");
		yokoLabel.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
		yokoLabel.setBounds(1129, 11, 126, 118);
		contentPane.add(yokoLabel);
		
		JButton yokoButton = new JButton("yoko");
		yokoButton.setOpaque(false);
		yokoButton.setContentAreaFilled(false);
		yokoButton.setBorderPainted(false);
		yokoButton.setBounds(1138, 23, 101, 97);
		contentPane.add(yokoButton);
		
		JLabel labelTexto = new JLabel("Carteira dos clientes");
		labelTexto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		labelTexto.setBounds(95, 127, 321, 50);
		contentPane.add(labelTexto);
		
		JButton botaoEstetico = new JButton("");
		botaoEstetico.setEnabled(false);
		botaoEstetico.setBounds(68, 127, 1214, 50);
		contentPane.add(botaoEstetico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(8, 2));
		scrollPane.setBounds(68, 202, 1214, 487);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(246, 246, 246));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Status", "Segurado", "CPF/CNPJ", "Tipo Seguro", "Veiculo"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		contentPane.add(yokohamaLogo);
	}

}
