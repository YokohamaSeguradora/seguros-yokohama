package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class SimulaSeguroCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoNomeCompleto;
    private JPanel contentPane;
    private JTextField campoEmail;
    private JTextField campoCelular;
    private JTextField campoCPF;
    private JTextField campoPerNoite;
    private JTextField campoNomeSocial;
    private JLabel labelNomeSocial;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        configurarUIManager();
        EventQueue.invokeLater(() -> {
            try {
                SimulaSeguroCliente frame = new SimulaSeguroCliente();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void configurarUIManager() {
        UIManager.put("Button.arc", 25);
        UIManager.put("Button.hoverBackground", new Color(218, 76, 76));
        UIManager.put("Button.arc", 15);
        UIManager.put("TextComponent.arc", 20);
        UIManager.put("Button.hoverBackground", new Color(105, 7, 7));
    }

    // Método para carregar imagens
    private BufferedImage carregaImagem(String caminho) {
        try {
            return ImageIO.read(SimulaSeguroCliente.class.getResource(caminho));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SimulaSeguroCliente() {
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    private void inicializarComponentes() {
        adicionarLogos();
        adicionarCamposTexto();
        adicionarLabels();
        adicionarBotoes();
    }

    private void adicionarLogos() {
        JLabel yokohamaLogo = new JLabel();
        yokohamaLogo.setIcon(new ImageIcon(carregaImagem("/images/image3.png")));
        yokohamaLogo.setBounds(10, -13, 186, 120);
        contentPane.add(yokohamaLogo);

        JLabel iconeYoku = new JLabel("");
        iconeYoku.setIcon(new ImageIcon(carregaImagem("/images/yoko.png")));
        iconeYoku.setBounds(607, 4, 135, 103);
        contentPane.add(iconeYoku);
    }

    private void adicionarCamposTexto() {
        campoNomeCompleto = criarCampoTexto(179, 253, "Tahoma", 14);
        campoEmail = criarCampoTexto(544, 253, "Tahoma", 14);
        campoCelular = criarCampoTexto(911, 253, "Tahoma", 14);
        campoCPF = criarCampoTexto(360, 407, "Tahoma", 14);
        campoPerNoite = criarCampoTexto(730, 407, "Tahoma", 14);
        campoNomeSocial = criarCampoTexto(248, 310, "Tahoma", 14);
        campoNomeSocial.setVisible(false);
        labelNomeSocial = new JLabel("Insira o Nome Social:");
        labelNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNomeSocial.setBounds(200, 285, 200, 20);
        labelNomeSocial.setVisible(false); // Iniciar invisível
        contentPane.add(labelNomeSocial);
    }

    private JTextField criarCampoTexto(int x, int y, String fonte, int tamanho) {
        JTextField campo = new JTextField();
        campo.setFont(new Font(fonte, Font.PLAIN, tamanho));
        campo.setOpaque(false);
        campo.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        campo.setBounds(x, y, 189, 20);
        contentPane.add(campo);
        return campo;
    }

    private void adicionarLabels() {
        adicionarLabel("Nome Completo:", 179, 231);
        adicionarLabel("E-MAIL:", 544, 231);
        adicionarLabel("Celular:", 911, 231);
        adicionarLabel("CPF:", 360, 386);
        adicionarLabel("CEP pernoite do veículo:", 730, 386);
        JLabel labelMensagem = new JLabel("Insira seus dados para iniciar a cotação!");
        labelMensagem.setFont(new Font("Tahoma", Font.PLAIN, 25));
        labelMensagem.setBounds(445, 147, 459, 29);
        contentPane.add(labelMensagem);
    }

    private void adicionarLabel(String texto, int x, int y) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(x, y, 200, 20);
        contentPane.add(label);
    }

    private void adicionarBotoes() {
        JButton botaoNomeSocial = criarBotaoIcone("/images/mais.png", 314, 280, e -> {
            campoNomeSocial.setVisible(true);
            labelNomeSocial.setVisible(true);
        });

        JButton botaoRemoverNomeSocial = criarBotaoIcone("/images/menos.png", 314, 280, e -> {
            campoNomeSocial.setVisible(false);
            campoNomeSocial.setText("");
            labelNomeSocial.setVisible(false);
        });
        botaoRemoverNomeSocial.setVisible(false);

        botaoNomeSocial.addActionListener(e -> {
            botaoNomeSocial.setVisible(false);
            botaoRemoverNomeSocial.setVisible(true);
        });

        botaoRemoverNomeSocial.addActionListener(e -> {
            botaoRemoverNomeSocial.setVisible(false);
            botaoNomeSocial.setVisible(true);
        });

        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBounds(607, 507, 135, 35);
        botaoContinuar.setBackground(new Color(127, 11, 11));
        botaoContinuar.setForeground(Color.WHITE);
        botaoContinuar.setBorderPainted(false);
        botaoContinuar.addActionListener(e -> validarCamposObrigatorios());
        contentPane.add(botaoContinuar);

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
        botaoVoltar.setIcon(new ImageIcon(carregaImagem("/images/arrowBackMenor.png"))); // Usando método carregaImagem
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setBackground(new Color(127, 11, 11));
        botaoVoltar.setBounds(-9, 135, 35, 111);
        contentPane.add(botaoVoltar); // Adiciona o botão ao painel
    }

private JButton criarBotaoIcone(String caminhoIcone, int x, int y, ActionListener acao) {
        JButton botao = new JButton();
        botao.setIcon(new ImageIcon(carregaImagem(caminhoIcone)));
        botao.setOpaque(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setBounds(x, y, 135, 20);
        botao.addActionListener(acao);
        contentPane.add(botao);
        return botao;
    }

    private void validarCamposObrigatorios() {
        if (campoNomeCompleto.getText().isEmpty() || campoEmail.getText().isEmpty()
                || campoCelular.getText().isEmpty() || campoCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!",
                    "Erro de validação", JOptionPane.ERROR_MESSAGE);
        }
    }
}
