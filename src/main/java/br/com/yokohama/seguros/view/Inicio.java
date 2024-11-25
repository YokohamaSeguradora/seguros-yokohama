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
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel Yokohama = new JLabel("Yokohama Seguradoura");
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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

	public Inicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 1350, 46);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel inicio = new JLabel("Início");
		inicio.setBackground(new Color(255, 255, 255));
		inicio.setBounds(868, 0, 48, 46);
		panel.add(inicio);
		inicio.setForeground(new Color(255, 255, 255));
		inicio.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblQuemSomosNs = new JLabel("Quem somos nós");
		lblQuemSomosNs.setBounds(938, 0, 126, 46);
		panel.add(lblQuemSomosNs);
		lblQuemSomosNs.setForeground(new Color(255, 255, 255));
		lblQuemSomosNs.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel Documentacao = new JLabel("Documentação");
		Documentacao.setBounds(1074, 0, 98, 46);
		panel.add(Documentacao);
		Documentacao.setForeground(new Color(255, 255, 255));
		Documentacao.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(1186, 6, 110, 33);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login telaLogin = new Login();
				telaLogin.setVisible(true);
			}
		});
		btnLogin.setBorderPainted(false);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(127, 11, 11));
		Yokohama.setBounds(10, 0, 242, 46);
		panel.add(Yokohama);
		Yokohama.setBackground(new Color(255, 255, 255));
		Yokohama.setForeground(new Color(255, 255, 255));
		Yokohama.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel Slogan = new JLabel("<html>Yokohama Seguradoura:<br>Protegemos o que te move!</html>");
		Slogan.setForeground(new Color(255, 255, 255));
		Slogan.setFont(new Font("Tahoma", Font.BOLD, 30));
		Slogan.setBounds(118, 228, 422, 81);
		contentPane.add(Slogan);

		JLabel lblAlgumTextoAqui = new JLabel(
				"<html>A Yokohma Seguradora, ciente da importância da segurança e tranquilidade de seus clientes, oferece uma ampla gama de soluções em seguros para veículos. Com uma atuação sólida no mercado, a empresa se destaca por sua expertise em desenvolver produtos personalizados, que se adaptam às necessidades individuais de cada cliente.</html>");
		lblAlgumTextoAqui.setForeground(new Color(255, 255, 255));
		lblAlgumTextoAqui.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlgumTextoAqui.setBounds(118, 296, 422, 164);
		contentPane.add(lblAlgumTextoAqui);

		JButton seeMore = new JButton("Saiba Mais");
		seeMore.setBorderPainted(false);
		seeMore.setForeground(new Color(255, 255, 255));
		seeMore.setBackground(new Color(127, 11, 11));
		seeMore.setBounds(118, 447, 110, 29);
		contentPane.add(seeMore);

		JLabel logoFundo = new JLabel("");
		logoFundo.setBounds(0, 0, 1366, 768);
		logoFundo.setIcon(new ImageIcon(carregaImagen("/images/fundoInicio.png")));
		contentPane.add(logoFundo);
	}

}
