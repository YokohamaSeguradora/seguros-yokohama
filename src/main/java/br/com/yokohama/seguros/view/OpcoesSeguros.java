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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class OpcoesSeguros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 15);
		UIManager.put("Button.arc", 15);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcoesSeguros frame = new OpcoesSeguros();
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
			return ImageIO.read(AtualizaUsuario.class.getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public OpcoesSeguros() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelMoto = new JLabel("Moto");
		labelMoto.setIcon(new ImageIcon(carregaImagen("/images/transfer.png")));
		labelMoto.setForeground(new Color(123, 11, 11));
		labelMoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelMoto.setBackground(new Color(246, 246, 246));
		labelMoto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		labelMoto.setBounds(342, 377, 275, 54);
		contentPane.add(labelMoto);

		JLabel labelCaminhao = new JLabel("Caminhão");
		labelCaminhao.setIcon(new ImageIcon(carregaImagen("/images/truck.png")));
		labelCaminhao.setHorizontalAlignment(SwingConstants.CENTER);
		labelCaminhao.setForeground(new Color(127, 11, 11));
		labelCaminhao.setFont(new Font("Tahoma", Font.PLAIN, 35));
		labelCaminhao.setBounds(378, 442, 275, 54);
		contentPane.add(labelCaminhao);

		JLabel labelBicicleta = new JLabel("Bicicleta");
		labelBicicleta.setIcon(new ImageIcon(carregaImagen("/images/Bicycle.png")));
		labelBicicleta.setHorizontalAlignment(SwingConstants.CENTER);
		labelBicicleta.setForeground(new Color(127, 11, 11));
		labelBicicleta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		labelBicicleta.setBounds(370, 504, 275, 54);
		contentPane.add(labelBicicleta);

		JLabel labelCarro = new JLabel("Carro");
		labelCarro.setIcon(new ImageIcon(carregaImagen("/images/car2.png")));
		labelCarro.setHorizontalAlignment(SwingConstants.CENTER);
		labelCarro.setForeground(new Color(127, 11, 11));
		labelCarro.setFont(new Font("Tahoma", Font.PLAIN, 35));
		labelCarro.setBounds(342, 312, 275, 54);
		contentPane.add(labelCarro);

		JLabel lblNewLabel = new JLabel("Seguros");
		lblNewLabel.setForeground(new Color(127, 11, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(537, 180, 275, 54);
		contentPane.add(lblNewLabel);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
		logo.setBounds(10, -13, 186, 120);
		contentPane.add(logo);

		JButton botaoSeguros = new JButton("");
		botaoSeguros.setEnabled(false);
		botaoSeguros.setForeground(new Color(123, 11, 11));
		botaoSeguros.setBackground(new Color(246, 246, 246));
		botaoSeguros.setFont(new Font("Tahoma", Font.PLAIN, 35));
		botaoSeguros.setBounds(316, 180, 718, 54);
		contentPane.add(botaoSeguros);

		JButton botaoCarro = new JButton("");
		botaoCarro.setBorderPainted(false);
		botaoCarro.setForeground(new Color(127, 11, 11));
		botaoCarro.setFont(new Font("Tahoma", Font.PLAIN, 35));
		botaoCarro.setBackground(new Color(246, 246, 246));
		botaoCarro.setBounds(316, 312, 718, 54);
		contentPane.add(botaoCarro);

		JButton botaoMoto = new JButton("");
		botaoMoto.setBorderPainted(false);
		botaoMoto.setBackground(new Color(246, 246, 246));
		botaoMoto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		botaoMoto.setBounds(316, 377, 718, 54);
		contentPane.add(botaoMoto);

		JButton botaoCaminhao = new JButton("");
		botaoCaminhao.setBorderPainted(false);
		botaoCaminhao.setHorizontalAlignment(SwingConstants.LEFT);
		botaoCaminhao.setForeground(new Color(127, 11, 11));
		botaoCaminhao.setFont(new Font("Tahoma", Font.PLAIN, 35));
		botaoCaminhao.setBackground(new Color(246, 246, 246));
		botaoCaminhao.setBounds(316, 442, 718, 54);
		contentPane.add(botaoCaminhao);

		JButton botaoBicicleta = new JButton("");
		botaoBicicleta.setBorderPainted(false);
		botaoBicicleta.setForeground(new Color(127, 11, 11));
		botaoBicicleta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		botaoBicicleta.setBackground(new Color(246, 246, 246));
		botaoBicicleta.setBounds(316, 507, 718, 54);
		contentPane.add(botaoBicicleta);

		JButton novoBotton = new JButton("Selecione o seguro desejado");
		novoBotton.setDefaultCapable(false);
		novoBotton.setForeground(new Color(255, 255, 255));
		novoBotton.setFocusable(false);
		novoBotton.setVerifyInputWhenFocusTarget(false);
		novoBotton.setOpaque(false);
		novoBotton.setRequestFocusEnabled(false);
		novoBotton.setRolloverEnabled(false);
		novoBotton.setFocusTraversalKeysEnabled(false);
		novoBotton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		novoBotton.setBackground(new Color(127, 11, 11));
		novoBotton.setBorderPainted(false);
		novoBotton.setFocusPainted(false);
		novoBotton.setBorderPainted(false);
		novoBotton.setBounds(409, 262, 531, 28);
		contentPane.add(novoBotton);

		JPanel fotter = new JPanel();
		fotter.setBackground(new Color(127, 11, 11));
		fotter.setBounds(0, 624, 1350, 105);
		contentPane.add(fotter);

		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(0, 90, 1366, 2);
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
		botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBack.png")));
		botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.setBackground(new Color(127, 11, 11));
		botaoVoltar.setBounds(-5, 135, 35, 111);
		contentPane.add(botaoVoltar);
	}
}
