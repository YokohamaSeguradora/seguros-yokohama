package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JSeparator;

public class SeguroPersonalizado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPalca;
	private JTextField txtVeiculo;
	private JTextField txtRenavam;
	private JTextField txtCnhPropietrio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 15);
		UIManager.put("TextComponent.arc", 15);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeguroPersonalizado frame = new SeguroPersonalizado();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeguroPersonalizado() {
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(503, 375, 51, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1.setBounds(503, 509, 51, 14);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("");
		lblNewLabel_4_1_1_2.setBounds(503, 578, 51, 14);
		contentPane.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setBounds(503, 439, 51, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1_1.setForeground(Color.BLACK);
		separator_2_1_1_1.setBackground(Color.BLACK);
		separator_2_1_1_1.setBounds(465, 567, 24, 38);
		contentPane.add(separator_2_1_1_1);
		
		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1_1_1.setBounds(599, 567, 24, 38);
		contentPane.add(separator_1_1_1_1_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setForeground(Color.BLACK);
		separator_2_1_1.setBackground(Color.BLACK);
		separator_2_1_1.setBounds(465, 498, 24, 38);
		contentPane.add(separator_2_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1_1.setBounds(599, 498, 24, 38);
		contentPane.add(separator_1_1_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBackground(Color.BLACK);
		separator_2_1.setBounds(465, 426, 24, 38);
		contentPane.add(separator_2_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1.setBounds(599, 426, 24, 38);
		contentPane.add(separator_1_1_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(599, 362, 24, 38);
		contentPane.add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(465, 362, 24, 38);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(599, 301, 24, 38);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(465, 301, 24, 38);
		contentPane.add(separator);
		
		JCheckBox chckbxPossuio_1_1 = new JCheckBox("Possui");
		chckbxPossuio_1_1.setForeground(new Color(127, 11, 11));
		chckbxPossuio_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPossuio_1_1.setBounds(723, 574, 97, 23);
		contentPane.add(chckbxPossuio_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2_1_1_1 = new JCheckBox("Não possui");
		chckbxNewCheckBox_1_2_1_1_1.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1_2_1_1_1.setBounds(853, 574, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2_1_1_1);
		
		JCheckBox chckbxPossuio_1 = new JCheckBox("Possui");
		chckbxPossuio_1.setForeground(new Color(127, 11, 11));
		chckbxPossuio_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPossuio_1.setBounds(723, 505, 97, 23);
		contentPane.add(chckbxPossuio_1);
		
		JCheckBox chckbxNewCheckBox_1_2_1_1 = new JCheckBox("Não possui");
		chckbxNewCheckBox_1_2_1_1.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1_2_1_1.setBounds(853, 505, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2_1_1);
		
		JCheckBox chckbxPossuio = new JCheckBox("Possui");
		chckbxPossuio.setForeground(new Color(127, 11, 11));
		chckbxPossuio.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPossuio.setBounds(723, 435, 97, 23);
		contentPane.add(chckbxPossuio);
		
		JCheckBox chckbxNewCheckBox_1_2_1 = new JCheckBox("Não possui");
		chckbxNewCheckBox_1_2_1.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1_2_1.setBounds(853, 435, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2_1);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Não possui");
		chckbxNewCheckBox_1_3.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1_3.setBounds(936, 371, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_3);
		
		JCheckBox chckbxBsico = new JCheckBox("Básico");
		chckbxBsico.setForeground(new Color(127, 11, 11));
		chckbxBsico.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBsico.setBounds(679, 371, 97, 23);
		contentPane.add(chckbxBsico);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Completo");
		chckbxNewCheckBox_1_2.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1_2.setBounds(809, 371, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(503, 318, 51, 14);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("800km");
		chckbxNewCheckBox_1_1.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1_1.setBounds(867, 309, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxIlimitado = new JCheckBox("Ilimitado");
		chckbxIlimitado.setForeground(new Color(127, 11, 11));
		chckbxIlimitado.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxIlimitado.setBounds(992, 309, 97, 23);
		contentPane.add(chckbxIlimitado);
		
		JCheckBox chckbxkm = new JCheckBox("300km");
		chckbxkm.setForeground(new Color(127, 11, 11));
		chckbxkm.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxkm.setBounds(737, 309, 97, 23);
		contentPane.add(chckbxkm);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("100km");
		chckbxNewCheckBox.setForeground(new Color(127, 11, 11));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(608, 309, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Escolha uma opção:");
		lblNewLabel_3_1_1_1.setBounds(481, 496, 108, 14);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Escolha uma opção:");
		lblNewLabel_3_1_1_1_1.setBounds(481, 565, 108, 14);
		contentPane.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Escolha uma opção:");
		lblNewLabel_3_1_1.setBounds(481, 426, 108, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Escolha uma opção:");
		lblNewLabel_3_1.setBounds(481, 362, 108, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Escolha uma opção:");
		lblNewLabel_3.setBounds(481, 301, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(608, 60, 134, 120);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\yoko.png"));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 120);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\logo.png"));
		lblNewLabel.setBounds(-12, 0, 184, 120);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Simule seu seguro personalizado!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(522, 176, 305, 30);
		contentPane.add(lblNewLabel_2);
		
		txtPalca = new JTextField();
		txtPalca.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalca.setText("Palca:");
		txtPalca.setBounds(228, 206, 175, 30);
		contentPane.add(txtPalca);
		txtPalca.setColumns(10);
		
		txtVeiculo = new JTextField();
		txtVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
		txtVeiculo.setText("Veiculo:");
		txtVeiculo.setColumns(10);
		txtVeiculo.setBounds(493, 206, 175, 30);
		contentPane.add(txtVeiculo);
		
		txtRenavam = new JTextField();
		txtRenavam.setHorizontalAlignment(SwingConstants.CENTER);
		txtRenavam.setText("Renavam:");
		txtRenavam.setColumns(10);
		txtRenavam.setBounds(775, 206, 175, 30);
		contentPane.add(txtRenavam);
		
		txtCnhPropietrio = new JTextField();
		txtCnhPropietrio.setHorizontalAlignment(SwingConstants.CENTER);
		txtCnhPropietrio.setText("CNH Propietário:");
		txtCnhPropietrio.setColumns(10);
		txtCnhPropietrio.setBounds(1050, 206, 175, 30);
		contentPane.add(txtCnhPropietrio);
		
		JLabel lblNewLabel_2_1 = new JLabel("Selecione as opções que deseja adicionar ao seu seugro:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(416, 247, 518, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("KM adicional de roboque");
		btnNewButton.setEnabled(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(312, 300, 800, 40);
		contentPane.add(btnNewButton);
		
		JButton btnVidros = new JButton("Vidros");
		btnVidros.setEnabled(false);
		btnVidros.setHorizontalAlignment(SwingConstants.LEFT);
		btnVidros.setBounds(312, 362, 800, 40);
		contentPane.add(btnVidros);
		
		JButton btnNewButton_1_1 = new JButton("Martelinho e para-choque");
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setBounds(312, 426, 800, 40);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Lataria e pintura");
		btnNewButton_1_1_1.setEnabled(false);
		btnNewButton_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1.setBounds(312, 496, 800, 40);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Roda, pneu e suspensão");
		btnNewButton_1_1_1_1.setEnabled(false);
		btnNewButton_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_1.setBounds(312, 565, 800, 40);
		contentPane.add(btnNewButton_1_1_1_1);
	}
}
