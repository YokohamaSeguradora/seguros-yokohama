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

import br.com.yokohama.seguros.controller.UsuarioController;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class AtualizaUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoCelular;
    private JTextField campoEmail;
    private JTextField campoEndereco;

    private UsuarioController usuarioController;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 25);
        UIManager.put("Button.hoverBackground", new Color(218, 76, 76));
        UIManager.put("TextComponent.arc", 20);
        UIManager.put("Button.arc", 20);
        UIManager.put("Button.hoverBackground", new Color(105, 7, 7));
        EventQueue.invokeLater(() -> {
            try {
                AtualizaUsuario frame = new AtualizaUsuario();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Método para carregar imagens
    private BufferedImage carregaImagen(String str) {
        try {
            return ImageIO.read(AtualizaUsuario.class.getResource(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AtualizaUsuario() {
        String nomeUsuario = SessaoUsuario.getNomeUsuario();
        String telefone = SessaoUsuario.getTelefoneUsuario();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(80, 80, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        campoEndereco = new JTextField();
        campoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
        campoEndereco.setBounds(60, 335, 700, 41);
        contentPane.add(campoEndereco);

        JLabel labelNumeroUsuario = new JLabel("Telefone: " + telefone);
        labelNumeroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelNumeroUsuario.setBounds(135, 245, 229, 14);
        contentPane.add(labelNumeroUsuario);

        JLabel labelNomeUsuario = new JLabel(String.format("Olá, %s", nomeUsuario));
        labelNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelNomeUsuario.setBounds(135, 213, 317, 25);
        contentPane.add(labelNomeUsuario);

        JLabel labelPerfilImagem = new JLabel("");
        labelPerfilImagem.setIcon(new ImageIcon(carregaImagen("/images/perfil.png")));
        labelPerfilImagem.setBounds(60, 205, 73, 62);
        contentPane.add(labelPerfilImagem);

        campoEmail = new JTextField();
        campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        campoEmail.setBounds(56, 552, 700, 41);
        contentPane.add(campoEmail);

        campoCelular = new JTextField();
        campoCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
        campoCelular.setBounds(56, 447, 700, 41);
        contentPane.add(campoCelular);

        JLabel labelMeusDados = new JLabel("Meus dados");
        labelMeusDados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelMeusDados.setBounds(60, 132, 159, 46);
        contentPane.add(labelMeusDados);

        adicionarBotoes();

        JLabel labelEndereco = new JLabel("Endereço");
        labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelEndereco.setBounds(50, 278, 159, 46);
        contentPane.add(labelEndereco);

        JLabel labelCelular = new JLabel("Celular");
        labelCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelCelular.setBounds(50, 390, 159, 46);
        contentPane.add(labelCelular);

        JLabel labelEmail = new JLabel("E-mail");
        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelEmail.setBounds(50, 498, 159, 46);
        contentPane.add(labelEmail);

        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
        labelLogo.setBounds(10, -13, 186, 120);
        contentPane.add(labelLogo);

        JLabel yokoLabel = new JLabel("");
        yokoLabel.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
        yokoLabel.setBounds(1183, 496, 126, 118);
        contentPane.add(yokoLabel);

        JButton yokoButton = new JButton("yoko");
        yokoButton.addActionListener(e -> {
            ChatBot chat = new ChatBot();
            chat.setVisible(true);
        });
        yokoButton.setBounds(1208, 498, 101, 97);
        yokoButton.setOpaque(false);
        yokoButton.setContentAreaFilled(false);
        yokoButton.setBorderPainted(false);
        contentPane.add(yokoButton);
    }

    private void adicionarBotoes() {
        JButton botaoAlterarEndereco = criarBotaoAlterar(906, 340, "Alterar endereço");
        botaoAlterarEndereco.addActionListener(e -> atualizarEndereco());

        JButton botaoAlterarCelular = criarBotaoAlterar(906, 451, "Alterar celular");
        botaoAlterarCelular.addActionListener(e -> atualizarCelular());

        JButton botaoAlterarEmail = criarBotaoAlterar(906, 556, "Alterar e-mail");
        botaoAlterarEmail.addActionListener(e -> atualizarEmail());

        JButton alterarSenha = new JButton("Alterar senha");
        alterarSenha.setIcon(new ImageIcon(carregaImagen("/images/cadeado.png")));
        alterarSenha.setBounds(534, 640, 281, 52);
        alterarSenha.setForeground(Color.WHITE);
        alterarSenha.setBackground(new Color(127, 11, 11));
        alterarSenha.setBorderPainted(false);
        alterarSenha.addActionListener(e -> alterarSenha());
        contentPane.add(alterarSenha);

        JButton botaoVoltar = criarBotaoVoltar();
        botaoVoltar.addActionListener(e -> redirecionarMenu());
        contentPane.add(botaoVoltar);
    }

    private JButton criarBotaoAlterar(int x, int y, String texto) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, 200, 40);
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(127, 11, 11));
        botao.setBorderPainted(false);
        contentPane.add(botao);
        return botao;
    }

    private JButton criarBotaoVoltar() {
        JButton botaoVoltar = new JButton("");
        botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBack.png")));
        botaoVoltar.setBounds(-5, 135, 35, 111);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorderPainted(false);
        return botaoVoltar;
    }

    private void atualizarEndereco() {
        JOptionPane.showMessageDialog(this, "Endereço atualizado!");
    }

    private void atualizarCelular() {
        JOptionPane.showMessageDialog(this, "Celular atualizado!");
    }

    private void atualizarEmail() {
        JOptionPane.showMessageDialog(this, "E-mail atualizado!");
    }

    private void alterarSenha() {
        JOptionPane.showMessageDialog(this, "Senha alterada com sucesso!");
    }

    private void redirecionarMenu() {
        try {
            Usuario usuario = SessaoUsuario.getInstancia().getUsuarioLogado();
            if (usuario != null) {
                if (usuario.getTipoUsuario() == TipoUsuario.CORRETOR) {
                    MenuCorretor menuCorretor = new MenuCorretor();
                    menuCorretor.setVisible(true);
                } else if (usuario.getTipoUsuario() == TipoUsuario.SEGURADO) {
                    MenuCliente menuCliente = new MenuCliente();
                    menuCliente.setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum usuário logado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao redirecionar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
