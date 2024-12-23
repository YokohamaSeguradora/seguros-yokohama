package br.com.yokohama.seguros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VisualizarCorretores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 15);
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("TableHeader.background", new Color(246, 246, 246));
		UIManager.put("TableHeader.separatorColor", new Color(246, 246, 246));
		UIManager.put("TableHeader.bottomSeparatorColor", new Color(246, 246, 246));
		UIManager.put("Table.gridColor", Color.red);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarCorretores frame = new VisualizarCorretores();
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
			return ImageIO.read(VisualizarCorretores.class.getResource(str));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public VisualizarCorretores() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
		lblLogo.setBounds(1188, 592, 121, 103);
		contentPane.add(lblLogo);

		// Labels
		JLabel lblCorretoresProximosA = new JLabel("Corretores proximos a sua região:");
		lblCorretoresProximosA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCorretoresProximosA.setForeground(Color.BLACK);
		lblCorretoresProximosA.setBounds(73, 266, 249, 23);
		contentPane.add(lblCorretoresProximosA);

		JLabel lblNewLabel = new JLabel("Selecione o corretor perfeito para você");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(576, 165, 249, 14);
		contentPane.add(lblNewLabel);

		JLabel labelCorretores = new JLabel("Corretores");
		labelCorretores.setForeground(new Color(37, 37, 37));
		labelCorretores.setFont(new Font("Tahoma", Font.PLAIN, 34));
		labelCorretores.setBounds(592, 86, 165, 40);
		contentPane.add(labelCorretores);

		// Estetico Buttons (botões apenas visuais)
		JButton botaoEstetico1 = new JButton("");
		botaoEstetico1.setBackground(new Color(255, 255, 255));
		botaoEstetico1.setForeground(new Color(0, 0, 0));
		botaoEstetico1.setEnabled(false);
		botaoEstetico1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		botaoEstetico1.setBounds(396, 73, 557, 62);
		contentPane.add(botaoEstetico1);

		JButton botaoEstetico2 = new JButton("");
		botaoEstetico2.setEnabled(false);
		botaoEstetico2.setBounds(489, 156, 374, 30);
		contentPane.add(botaoEstetico2);

		JButton botaoEstetico3 = new JButton("");
		botaoEstetico3.setEnabled(false);
		botaoEstetico3.setBounds(61, 263, 235, 30);
		contentPane.add(botaoEstetico3);

		// Scroll Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 314, 840, 350);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(246, 246, 246));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Avaliação" }));
		scrollPane.setViewportView(table);

		// Logo do Yokohama
		JLabel yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		contentPane.add(yokohamaLogo);

		// Yoko Button
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
		yokoButton.setBounds(1194, 588, 101, 97);
		contentPane.add(yokoButton);

		// Botão de Voltar
		JButton botaoVoltar = new JButton("");
		botaoVoltar.addActionListener(e -> {
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
                    JOptionPane.showMessageDialog(this, "Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao redirecionar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
		botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBackMenor.png")));
		botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setBackground(new Color(127, 11, 11));
		botaoVoltar.setBounds(-9, 135, 35, 111);
		contentPane.add(botaoVoltar);
	}
}
