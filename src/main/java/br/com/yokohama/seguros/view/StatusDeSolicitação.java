package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JCalendar;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

import javax.swing.table.DefaultTableModel;

public class StatusDeSolicitação extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		UIManager.put("Button.arc", 15);
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("TableHeader.separatorColor", new Color(255, 255, 255));
		UIManager.put("TableHeader.bottomSeparatorColor", new Color(255, 255, 255));

		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusDeSolicitação frame = new StatusDeSolicitação();
					frame.setVisible(true);
					frame.setSize(1366, 768);
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
			return ImageIO.read(AtualizaUsuario.class.getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public StatusDeSolicitação() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);

		setBackground(new Color(255, 255, 255));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(UIManager.getBorder("OptionPane.buttonAreaBorder"));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel calendar = new JLabel(new ImageIcon(carregaImagen("/images/Calendar.png")));
		calendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JCalendar calendario = new JCalendar();
				JFrame janelaCalendario = new JFrame("Calendário");
				janelaCalendario.getContentPane().add(calendario);
				janelaCalendario.setVisible(true);
				janelaCalendario.setSize(300, 400);
				janelaCalendario.setLocationRelativeTo(null);
			}
		});

		JLabel nomeIcon = new JLabel("");
		nomeIcon.setIcon(new ImageIcon(carregaImagen("/images/TagUser.png")));
		nomeIcon.setBounds(545, 373, 33, 28);
		contentPane.add(nomeIcon);

		JLabel seguroIcon = new JLabel("");
		seguroIcon.setIcon(new ImageIcon(carregaImagen("/images/Security.png")));
		seguroIcon.setBounds(373, 373, 33, 28);
		contentPane.add(seguroIcon);

		JLabel statusIcon = new JLabel("");
		statusIcon.setIcon(new ImageIcon(carregaImagen("/images/Status.png")));
		statusIcon.setBounds(220, 373, 33, 28);
		contentPane.add(statusIcon);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setForeground(Color.BLACK);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBackground(UIManager.getColor("Button.background"));
		labelNome.setBounds(575, 368, 81, 35);
		contentPane.add(labelNome);

		JLabel labelSeguro = new JLabel("Seguro");
		labelSeguro.setForeground(Color.BLACK);
		labelSeguro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSeguro.setBackground(UIManager.getColor("Button.background"));
		labelSeguro.setBounds(406, 368, 81, 35);
		contentPane.add(labelSeguro);

		JLabel labelStatus = new JLabel("Status");
		labelStatus.setForeground(Color.BLACK);
		labelStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelStatus.setBackground(UIManager.getColor("Button.background"));
		labelStatus.setBounds(251, 368, 81, 35);
		contentPane.add(labelStatus);

		JLabel labelTicket = new JLabel("Ticket#");
		labelTicket.setForeground(Color.BLACK);
		labelTicket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTicket.setBackground(UIManager.getColor("Button.background"));
		labelTicket.setBounds(80, 371, 81, 35);
		contentPane.add(labelTicket);

		JLabel labelFechado = new JLabel("");
		labelFechado.setIcon(new ImageIcon("C:\\Users\\thibas\\Downloads\\Close Circle.png"));
		labelFechado.setBounds(545, 274, 33, 28);
		contentPane.add(labelFechado);

		JLabel labelConcluida = new JLabel("");
		labelConcluida.setIcon(new ImageIcon(carregaImagen("/images/Verify.png")));
		labelConcluida.setBounds(378, 274, 33, 28);
		contentPane.add(labelConcluida);

		JLabel labelAnalise = new JLabel("");
		labelAnalise.setIcon(new ImageIcon(carregaImagen("/images/alert.png")));
		labelAnalise.setBounds(220, 274, 33, 28);
		contentPane.add(labelAnalise);

		JLabel labelPendente = new JLabel("");
		labelPendente.setIcon(new ImageIcon(carregaImagen("/images/alert2.png")));
		labelPendente.setBounds(53, 274, 33, 28);
		contentPane.add(labelPendente);

		calendar.setBounds(1156, 122, 25, 35);
		contentPane.add(calendar);

		JLabel lblNewLabel_2 = new JLabel("Calendário");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(1184, 122, 95, 35);
		contentPane.add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(UIManager.getColor("Button.shadow"));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(42, 414, 1252, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel_4_1_2_1 = new JLabel(
				"<html><center><span style='line-heigth: 1.0;'>0</center><br>Fechado</html>");
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_2_1.setBounds(575, 260, 81, 37);
		contentPane.add(lblNewLabel_4_1_2_1);

		JLabel lblNewLabel_4_1_2 = new JLabel(
				"<html><center><span style='line-heigth: 1.0;'>3</center><br>Concluída</html>");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_2.setBounds(406, 260, 81, 37);
		contentPane.add(lblNewLabel_4_1_2);

		JLabel lblNewLabel_4_1 = new JLabel(
				"<html><center><span style='line-heigth: 1.0;'>2</center><br>Analise</html>");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(251, 260, 81, 37);
		contentPane.add(lblNewLabel_4_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "3", "5", "6" }));
		comboBox.setEditable(true);
		comboBox.setBounds(59, 320, 60, 22);
		contentPane.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 423, 623, 187);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(126);
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setPreferredWidth(126);
		table.getColumnModel().getColumn(3).setPreferredWidth(136);
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("");
		scrollPane.setColumnHeaderView(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFocusCycleRoot(true);
		btnNewButton_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_1.setBorderPainted(false);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(42, 358, 1252, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\search.png"));
		lblNewLabel_9.setBounds(1173, 332, 27, 27);
		contentPane.add(lblNewLabel_9);

		textField = new JTextField();
		textField.setBounds(700, 260, 464, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Close Circle.png"));
		lblNewLabel_8.setBounds(571, 320, 27, 27);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Verify.png"));
		lblNewLabel_7.setBounds(392, 320, 27, 27);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Alert Triangle.png"));
		lblNewLabel_6.setBounds(228, 288, 25, 27);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Alert Square.png"));
		lblNewLabel_5.setBounds(65, 320, 25, 27);
		contentPane.add(lblNewLabel_5);

		JButton meio4 = new JButton("");
		meio4.setForeground(Color.BLACK);
		meio4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		meio4.setEnabled(false);
		meio4.setBackground(Color.WHITE);
		meio4.setBounds(539, 236, 125, 76);
		contentPane.add(meio4);

		JLabel labelYokohoma = new JLabel("");
		labelYokohoma.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		labelYokohoma.setBounds(10, -13, 186, 120);
		contentPane.add(labelYokohoma);

		JButton meio2 = new JButton("");
		meio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		meio2.setForeground(Color.BLACK);
		meio2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		meio2.setEnabled(false);
		meio2.setBackground(Color.WHITE);
		meio2.setBounds(212, 236, 125, 76);
		contentPane.add(meio2);

		JButton meio3 = new JButton("");
		meio3.setForeground(Color.BLACK);
		meio3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		meio3.setEnabled(false);
		meio3.setBackground(Color.WHITE);
		meio3.setBounds(373, 236, 125, 76);
		contentPane.add(meio3);

		JLabel lblNewLabel_4 = new JLabel(
				"<html><center><span style='line-heigth: 1.0;'>1</center><br>Pendentes</html>");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(80, 260, 81, 37);
		contentPane.add(lblNewLabel_4);

		JButton meio1 = new JButton("");
		meio1.setEnabled(false);
		meio1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		meio1.setBackground(new Color(255, 255, 255));
		meio1.setBounds(49, 236, 125, 76);
		contentPane.add(meio1);

		JButton btnNewButton_2 = new JButton(
				"<html><center><span style='line-heigth: 1.0;'>Gerar</center><br>Relatorio</html>");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(127, 11, 11));
		btnNewButton_2.setBounds(1190, 259, 89, 37);

		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_1_1 = new JLabel("Resumos da solicitações");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(67, 189, 221, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Status de Solicitação");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(68, 122, 185, 35);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBounds(27, 168, 1284, 519);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(27, 120, 1284, 37);
		contentPane.add(btnNewButton);

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