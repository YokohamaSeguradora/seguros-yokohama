package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import org.w3c.dom.events.MouseEvent;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelEmail;
	private JLabel labelSenha;
	private JTextField campoEmail;
	private JPasswordField campoSenha;
	private JButton botaoLogar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        //UIManager.put("Button.arc", 99);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        //UIManager.put("Button.hoverForeground", Color.red);
        UIManager.put("Button.arc", 25);
        UIManager.put("Button.hoverBackground", new Color(218, 76, 76));
        UIManager.put("TextComponent.arc", 20);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 0, 0, 0));

		setContentPane(contentPane);
		
		JPanel fotter = new JPanel();
		fotter.setBounds(0, 624, 1350, 105);
		fotter.setBackground(new Color(127, 11, 11));
		contentPane.setLayout(null);
		contentPane.add(fotter);
		
		labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEmail.setBounds(399, 163, 42, 25);
		contentPane.add(labelEmail);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelSenha.setBounds(398, 255, 71, 25);
		contentPane.add(labelSenha);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(398, 199, 554, 37);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(398, 291, 553, 37);
		contentPane.add(campoSenha);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Arial", Font.ITALIC, 40));
		loginLabel.setBounds(617, 50, 115, 65);
		contentPane.add(loginLabel);
		
		JButton forgotButton = new JButton("Forgot Password?");
		forgotButton.addMouseListener(new MouseAdapter() {
			
			public void mouseExit(MouseEvent E) {
				forgotButton.setForeground(Color.red);
				UIManager.put("Button.hoverForeground", Color.red);

            }

            public void mousetExit(MouseEvent E) {
                forgotButton.setForeground(Color.white);
                UIManager.put("Button.hoverForeground", Color.white);

			}
			
		});
			
		
		forgotButton.setOpaque(false);
		forgotButton.setContentAreaFilled(false);
		forgotButton.setBorderPainted(false);
		forgotButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		forgotButton.setBounds(388, 395, 119, 23);
		contentPane.add(forgotButton);
		
		botaoLogar = new JButton("Entrar");
		botaoLogar.setForeground(new Color(255, 255, 255));
		botaoLogar.setBackground(new Color(127, 11, 11));
		botaoLogar.setBounds(398, 351, 554, 33);
		contentPane.add(botaoLogar);

        botaoLogar.addActionListener(e -> {
			String email = campoEmail.getText().trim();
			String senha = new String(campoSenha.getPassword());

			if (email.isEmpty() || senha.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(this,
						"Por favor, preencha os campos de Email e Senha.",
						"Erro de validação",
						javax.swing.JOptionPane.ERROR_MESSAGE);
			} else {
				// Conectar ao banco de dados
				Connection connection = new ConnectionFactory().conectar();
				UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
				Usuario usuario = usuarioDAO.autenticarUsuario(email, senha);

				if (usuario != null) {
					SessaoUsuario.getInstancia().setUsuario(usuario); // Usa o método getInstancia
					javax.swing.JOptionPane.showMessageDialog(this,
							"Login realizado com sucesso!",
							"Bem-vindo",
							javax.swing.JOptionPane.INFORMATION_MESSAGE
					);

					// Abrir a próxima página (MenuCliente ou MenuCorretor)
					if (usuario.getTipoUsuario() == TipoUsuario.CORRETOR) {
						MenuCorretor menuCorretor = new MenuCorretor();
						menuCorretor.setVisible(true);
					} else if (usuario.getTipoUsuario() == TipoUsuario.SEGURADO) {
						MenuCliente menuCliente = new MenuCliente();
						menuCliente.setVisible(true);
					}
					dispose(); // Fecha a tela atual
				} else {
					javax.swing.JOptionPane.showMessageDialog(this,
							"Email ou senha inválidos.",
							"Erro de autenticação",
							javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}