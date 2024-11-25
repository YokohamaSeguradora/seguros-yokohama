package br.com.yokohama.seguros.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;

public class ChatBot extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoDigita;
	private JButton botaoEnviar;
	private JPanel fotter;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("TextComponent.arc", 25);
		UIManager.put("TextComponent.focusedBackground", Color.black);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBot frame = new ChatBot();
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

	public ChatBot() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JTextArea txtrOlSou = new JTextArea();
		txtrOlSou.setForeground(new Color(127, 11, 11));
		txtrOlSou.setFont(new Font("Arial", Font.PLAIN, 18));
		txtrOlSou.setText("Olá !  sou yoko como posso te ajudar hoje ?");
		txtrOlSou.setBackground(new Color(240, 240, 240));
		txtrOlSou.setFocusable(false);
		txtrOlSou.setEditable(false);
		txtrOlSou.setLineWrap(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(txtrOlSou);
		scrollPane.setFocusable(false);
		scrollPane.setBounds(308, 129, 734, 491);
		contentPane.add(scrollPane);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		botaoEnviar = new JButton("");
		botaoEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrOlSou.setText(campoDigita.getText());
			}
		});
		botaoEnviar.setOpaque(false);
		botaoEnviar.setContentAreaFilled(false);
		botaoEnviar.setBorderPainted(false);
		botaoEnviar.setIcon(new ImageIcon(carregaImagen("/images/setaEnviar.png")));
		botaoEnviar.setBounds(987, 646, 42, 45);
		contentPane.add(botaoEnviar);

		campoDigita = new JTextField();
		campoDigita.setSelectionColor(new Color(0, 0, 0));
		campoDigita.setFont(new Font("Arial", Font.PLAIN, 16));
		campoDigita.setForeground(new Color(0, 0, 0));
		campoDigita.setBounds(308, 646, 734, 45);
		contentPane.add(campoDigita);
		campoDigita.setColumns(10);

		fotter = new JPanel();
		fotter.setBackground(new Color(0, 0, 0));
		fotter.setBounds(175, 98, 1000, 1);
		contentPane.add(fotter);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(carregaImagen("/images/yokoMedio.png")));
		lblNewLabel.setBounds(610, -4, 129, 111);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("A Yoko pode cometer erros. Por isso, é bom checar as respostas");
		lblNewLabel_1.setBounds(508, 694, 357, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(carregaImagen("/images/image3Nova.png")));
		lblNewLabel_2.setBounds(10, -13, 104, 88);
		contentPane.add(lblNewLabel_2);

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
		botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBack.png")));
		botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setBackground(new Color(127, 11, 11));
		botaoVoltar.setBounds(-5, 135, 35, 111);
		contentPane.add(botaoVoltar);

	}

}
