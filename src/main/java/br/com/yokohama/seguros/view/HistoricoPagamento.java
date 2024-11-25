package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HistoricoPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabela;
	private JTextField procuraNome;
	private JButton botaoGeraPagamento;
	private JLabel labelGerar;
	private JLabel labelRelatorio;
	private JLabel iconeLupa;
	private JLabel yokohamaLogo;
	private JLabel lblYoko;
	private JButton yokoButton;

	public static void main(String[] args) {
		FlatLightLaf.setup();

		UIManager.put("Table.TableHeader.height", 1000);
		UIManager.put("Button.arc", 15);
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("TableHeader.background", new Color(246, 246, 246));
		UIManager.put("TableHeader.separatorColor", new Color(246, 246, 246));
		UIManager.put("TableHeader.bottomSeparatorColor", new Color(246, 246, 246));
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					HistoricoPagamento frame = new HistoricoPagamento();
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

	public HistoricoPagamento() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		iconeLupa = new JLabel("");
		iconeLupa.setIcon(new ImageIcon(carregaImagen("/images/SearchResize.png")));
		iconeLupa.setBounds(478, 114, 30, 24);
		contentPane.add(iconeLupa);

		labelRelatorio = new JLabel("Relatorio");
		labelRelatorio.setForeground(new Color(255, 255, 255));
		labelRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelRelatorio.setBackground(Color.BLACK);
		labelRelatorio.setBounds(953, 632, 83, 14);
		contentPane.add(labelRelatorio);

		labelGerar = new JLabel("Gerar");
		labelGerar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelGerar.setBackground(new Color(0, 0, 0));
		labelGerar.setForeground(new Color(255, 255, 255));
		labelGerar.setBounds(960, 618, 46, 14);
		contentPane.add(labelGerar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusTraversalPolicyProvider(true);
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setBounds(274, 160, 801, 345);
		contentPane.add(scrollPane);

		tabela = new JTable();
		tabela.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabela.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Status", "Seguro", "CNH" }) {
			boolean[] columnEditables = new boolean[] { true, false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.setBackground(new Color(246, 246, 246));
		scrollPane.setViewportView(tabela);

		procuraNome = new JTextField();
		procuraNome.setBackground(new Color(246, 246, 246));
		procuraNome.setBounds(127, 110, 375, 31);
		contentPane.add(procuraNome);
		procuraNome.setColumns(10);

		botaoGeraPagamento = new JButton("");
		botaoGeraPagamento.setForeground(Color.WHITE);
		botaoGeraPagamento.setBackground(new Color(127, 11, 11));
		botaoGeraPagamento.setBounds(898, 613, 157, 41);
		contentPane.add(botaoGeraPagamento);

		yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		contentPane.add(yokohamaLogo);

		lblYoko = new JLabel("");
		lblYoko.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
		lblYoko.setBounds(1150, 504, 126, 118);
		contentPane.add(lblYoko);

		yokoButton = new JButton("yoko");
		yokoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatBot chat = new ChatBot();
				chat.setVisible(true);
			}
		});
		yokoButton.setOpaque(false);
		yokoButton.setContentAreaFilled(false);
		yokoButton.setBorderPainted(false);
		yokoButton.setBounds(1150, 515, 101, 97);
		contentPane.add(yokoButton);

		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Obtendo o usuário logado da sessão
					Usuario usuario = SessaoUsuario.getInstancia().getUsuarioLogado();

					// Verificando o tipo do usuário para redirecionar para a tela correta
					if (usuario != null) {
						if (usuario.getTipoUsuario() == TipoUsuario.CORRETOR) {
							MenuCorretor menuCorretor = new MenuCorretor();
							menuCorretor.setVisible(true);
						} else if (usuario.getTipoUsuario() == TipoUsuario.SEGURADO) {
							MenuCliente menuCliente = new MenuCliente();
							menuCliente.setVisible(true);
						}
						dispose(); // Fecha a tela atual
					} else {
						JOptionPane.showMessageDialog(HistoricoPagamento.this, "Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(HistoricoPagamento.this, "Erro ao redirecionar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBack.png")));
		botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setBackground(new Color(127, 11, 11));
		botaoVoltar.setBounds(-5, 135, 35, 111);
		contentPane.add(botaoVoltar);
	}
}
