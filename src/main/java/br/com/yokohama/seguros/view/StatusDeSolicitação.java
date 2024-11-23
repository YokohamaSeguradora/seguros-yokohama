package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JCalendar;

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
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Calendar.png"));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JCalendar calendario = new JCalendar();
				JFrame janelaCalendario = new JFrame("Calendário");
				janelaCalendario.getContentPane().add(calendario);
				janelaCalendario.setVisible(true);
				janelaCalendario.setSize(300, 400);
			}
		});
		
		lblNewLabel_3.setBounds(1175, 168, 25, 35);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "6"}));
		comboBox.setEditable(true);
		comboBox.setBounds(55, 434, 60, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 480, 1042, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(49, 467, 1252, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\search.png"));
		lblNewLabel_9.setBounds(1173, 332, 27, 27);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(739, 327, 464, 37);
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
		lblNewLabel_6.setBounds(224, 320, 25, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Alert Square.png"));
		lblNewLabel_5.setBounds(65, 320, 25, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("<html><center><span style='line-heigth: 1.0;'>0</center><br>Fechado</html>");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1.setBounds(604, 305, 60, 37);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("");
		btnNewButton_3_1_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1_1_1.setEnabled(false);
		btnNewButton_3_1_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1_1.setBounds(558, 288, 125, 76);
		contentPane.add(btnNewButton_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("<html><center><span style='line-heigth: 1.0;'>2</center><br>Concluída</html>");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(422, 305, 60, 37);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\logo.png"));
		lblNewLabel.setBounds(-13, 0, 187, 107);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4_1 = new JLabel("<html><center><span style='line-heigth: 1.0;'>3</center><br>Análaise</html>");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(252, 305, 60, 37);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setForeground(Color.BLACK);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1.setEnabled(false);
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(212, 288, 125, 76);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("");
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1_1.setEnabled(false);
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setBounds(378, 288, 125, 76);
		contentPane.add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("<html><center><span style='line-heigth: 1.0;'>1</center><br>Pendentes</html>");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(88, 305, 60, 37);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(49, 288, 125, 76);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("<html><center><span style='line-heigth: 1.0;'>Gerar</center><br>Relatorio</html>");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(127, 11, 11));
		btnNewButton_2.setBounds(1206, 252, 89, 37);
		
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Resumos da solicitações");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(39, 242, 221, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Calendário");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(1206, 168, 95, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Status de Solicitação");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(39, 168, 185, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(228, 227, 227));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(27, 168, 1295, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFocusCycleRoot(true);
		btnNewButton_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(27, 242, 1295, 415);
		contentPane.add(btnNewButton_1);
	}
}