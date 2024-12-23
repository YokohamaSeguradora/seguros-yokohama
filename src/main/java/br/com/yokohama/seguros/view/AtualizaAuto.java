package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class AtualizaAuto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoPerNoite;
	private JPanel contentPane;
	private JTextField campoAnoFab;
	private JTextField campoPlaca;
	private JTextField textField;
	private JTextField campoModelo;


	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 25);
		UIManager.put("Button.hoverBackground", new Color(218, 76, 76));
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Button.hoverBackground", new Color(105, 7, 7));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizaAuto frame = new AtualizaAuto();
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

	public AtualizaAuto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton botaoAlteraPlaca = new JButton("Alterar");
		botaoAlteraPlaca.setForeground(Color.WHITE);
		botaoAlteraPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAlteraPlaca.setBorderPainted(false);
		botaoAlteraPlaca.setBackground(new Color(127, 11, 11));
		botaoAlteraPlaca.setBounds(639, 401, 101, 32);
		contentPane.add(botaoAlteraPlaca);

		JButton botaoAlteraModelo = new JButton("Alterar");
		botaoAlteraModelo.setForeground(Color.WHITE);
		botaoAlteraModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAlteraModelo.setBorderPainted(false);
		botaoAlteraModelo.setBackground(new Color(127, 11, 11));
		botaoAlteraModelo.setBounds(639, 288, 101, 32);
		contentPane.add(botaoAlteraModelo);

		JButton botaoAlteraAno = new JButton("Alterar");
		botaoAlteraAno.setForeground(Color.WHITE);
		botaoAlteraAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAlteraAno.setBorderPainted(false);
		botaoAlteraAno.setBackground(new Color(127, 11, 11));
		botaoAlteraAno.setBounds(639, 517, 101, 32);
		contentPane.add(botaoAlteraAno);

		JLabel labelEscudo = new JLabel("");
		labelEscudo.setIcon(new ImageIcon(carregaImagen("/images/escudo.png")));
		labelEscudo.setBounds(324, 200, 27, 21);
		contentPane.add(labelEscudo);

		JLabel labelMiniCarro = new JLabel("");
		labelMiniCarro.setIcon(new ImageIcon(carregaImagen("/images/car.png")));
		labelMiniCarro.setBounds(63, 170, 53, 46);
		contentPane.add(labelMiniCarro);

		campoModelo = new JTextField();
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoModelo.setColumns(10);
		campoModelo.setBounds(60, 284, 387, 41);
		contentPane.add(campoModelo);

		JLabel labelProtegido = new JLabel("ABC1234");
		labelProtegido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelProtegido.setBounds(253, 198, 112, 21);
		contentPane.add(labelProtegido);

		JLabel labelTituloPlac = new JLabel("ABC1234");
		labelTituloPlac.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloPlac.setBounds(145, 198, 112, 21);
		contentPane.add(labelTituloPlac);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(131, 158, 2, 70);
		contentPane.add(textField);
		textField.setColumns(10);

		campoPlaca = new JTextField();
		campoPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoPlaca.setColumns(10);
		campoPlaca.setBounds(60, 397, 387, 41);
		contentPane.add(campoPlaca);

		campoAnoFab = new JTextField();
		campoAnoFab.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoAnoFab.setColumns(10);
		campoAnoFab.setBounds(60, 513, 387, 41);
		contentPane.add(campoAnoFab);

		JLabel labelModeloAuto = new JLabel("KA 1.0 SE/SE PLUS TIVCT");
		labelModeloAuto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelModeloAuto.setBounds(145, 172, 431, 14);
		contentPane.add(labelModeloAuto);

		campoPerNoite = new JTextField();
		campoPerNoite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoPerNoite.setColumns(10);
		campoPerNoite.setBounds(60, 627, 387, 41);
		contentPane.add(campoPerNoite);

		JLabel labelAuto = new JLabel("Meu veiculo");
		labelAuto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAuto.setBounds(60, 92, 159, 46);
		contentPane.add(labelAuto);

		JButton botaoAlteraCEP = new JButton("Alterar");
		botaoAlteraCEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAlteraCEP.setForeground(Color.WHITE);
		botaoAlteraCEP.setBorderPainted(false);
		botaoAlteraCEP.setBackground(new Color(127, 11, 11));
		botaoAlteraCEP.setBounds(639, 631, 101, 32);
		contentPane.add(botaoAlteraCEP);

		JButton protegido = new JButton("");
		protegido.setEnabled(false);
		protegido.setBounds(40, 152, 563, 81);
		contentPane.add(protegido);

		JButton fundo01 = new JButton("");
		fundo01.setEnabled(false);
		fundo01.setBounds(40, 92, 179, 46);

		contentPane.add(fundo01);

		JButton fundo05 = new JButton("");
		fundo05.setEnabled(false);
		fundo05.setBounds(40, 605, 721, 81);
		contentPane.add(fundo05);

		JLabel labelPerNoi = new JLabel("CEP pernoite:");
		labelPerNoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPerNoi.setBounds(50, 565, 159, 46);
		contentPane.add(labelPerNoi);

		JLabel yokohamaLogo = new JLabel();
		yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		yokohamaLogo.setBounds(10, -13, 186, 120);
		contentPane.add(yokohamaLogo);

		JLabel yokoLabel = new JLabel("");
		yokoLabel.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
		yokoLabel.setBounds(1183, 496, 126, 118);
		contentPane.add(yokoLabel);

		JButton fundo05_1 = new JButton("");
		fundo05_1.setEnabled(false);
		fundo05_1.setBounds(40, 492, 721, 81);
		contentPane.add(fundo05_1);

		JLabel labelFabric = new JLabel("Ano mod/fab:");
		labelFabric.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelFabric.setBounds(50, 449, 169, 46);
		contentPane.add(labelFabric);

		JButton fundo05_1_1 = new JButton("");
		fundo05_1_1.setEnabled(false);
		fundo05_1_1.setBounds(40, 376, 721, 81);
		contentPane.add(fundo05_1_1);

		JLabel labelPlaca = new JLabel("Placa:");
		labelPlaca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPlaca.setBounds(50, 336, 169, 46);
		contentPane.add(labelPlaca);

		JButton fundo05_1_1_1 = new JButton("");
		fundo05_1_1_1.setEnabled(false);
		fundo05_1_1_1.setBounds(40, 262, 721, 81);
		contentPane.add(fundo05_1_1_1);

		JLabel labelModel = new JLabel("Modelo:");
		labelModel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelModel.setBounds(49, 223, 169, 46);
		contentPane.add(labelModel);

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
		
				JButton yokoButton = new JButton("");
				yokoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ChatBot chat = new ChatBot();
						chat.setVisible(true);
					}
				});
				yokoButton.setBounds(1208, 498, 101, 97);
				yokoButton.setOpaque(false);
				yokoButton.setContentAreaFilled(false);
				yokoButton.setBorderPainted(false);
				contentPane.add(yokoButton);
				
				JButton botaoEscondido = new JButton("yoko");
				botaoEscondido.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						campoModelo.setText("Skyline GT-R R34");
						campoPlaca.setText("878-8787");
						campoAnoFab.setText("1988");
						campoPerNoite.setText("04004-902");
					}
				});
				botaoEscondido.setOpaque(false);
				botaoEscondido.setContentAreaFilled(false);
				botaoEscondido.setBorderPainted(false);
				botaoEscondido.setBounds(32, 10, 101, 97);
				contentPane.add(botaoEscondido);
	}
}
