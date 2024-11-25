package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.controller.ListaClientesController;
import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class CarteiraCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private final ListaClientesController controller;

    public CarteiraCliente() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        adicionarComponentes();

        // Configurações de conexão e controlador
        UsuarioDAO usuarioDAO = new UsuarioDAO(new ConnectionFactory().conectar());
        controller = new ListaClientesController(this, usuarioDAO);
        inicia();
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("TableHeader.background", new Color(246, 246, 246));
        EventQueue.invokeLater(() -> {
            try {
                CarteiraCliente frame = new CarteiraCliente();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void adicionarComponentes() {
        JLabel yokoLabel = new JLabel(new ImageIcon(carregaImagen("/images/yoko.png")));
        yokoLabel.setBounds(1129, 11, 126, 118);
        contentPane.add(yokoLabel);

        JButton yokoButton = criarBotaoYoko();
        contentPane.add(yokoButton);

        JLabel labelTexto = new JLabel("Carteira dos clientes");
        labelTexto.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelTexto.setBounds(95, 127, 321, 50);
        contentPane.add(labelTexto);

        JButton botaoEstetico = new JButton();
        botaoEstetico.setEnabled(false);
        botaoEstetico.setBounds(68, 127, 1214, 50);
        contentPane.add(botaoEstetico);

        JScrollPane scrollPane = criarScrollPaneTabela();
        contentPane.add(scrollPane);

        JLabel yokohamaLogo = new JLabel(new ImageIcon(carregaImagen("/images/image3.png")));
        yokohamaLogo.setBounds(10, -13, 186, 120);
        contentPane.add(yokohamaLogo);

        JButton botaoVoltar = criarBotaoVoltar();
        contentPane.add(botaoVoltar);
    }

    private JButton criarBotaoYoko() {
        JButton yokoButton = new JButton("yoko");
        yokoButton.setOpaque(false);
        yokoButton.setContentAreaFilled(false);
        yokoButton.setBorderPainted(false);
        yokoButton.setBounds(1138, 23, 101, 97);
        yokoButton.addActionListener(e -> {
            ChatBot chat = new ChatBot();
            chat.setVisible(true);
        });
        return yokoButton;
    }

    private JScrollPane criarScrollPaneTabela() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(8, 2));
        scrollPane.setBounds(68, 202, 1214, 487);

        table = new JTable();
        table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(246, 246, 246));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "NOME COMPLETO", "CPF/CNPJ", "E-MAIL", "TELEFONE", "ENDEREÇO", "CNH"}
        ));
        scrollPane.setViewportView(table);
        return scrollPane;
    }

    private JButton criarBotaoVoltar() {
        JButton botaoVoltar = new JButton(new ImageIcon(carregaImagen("/images/arrowBack.png")));
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setBounds(-5, 135, 35, 111);
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
        return botaoVoltar;
    }

    public BufferedImage carregaImagen(String str) {
        try {
            return ImageIO.read(CarteiraCliente.class.getResource(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void centralizarColunas() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    private void inicia() {
        controller.atualizaTabela();
        centralizarColunas();
    }

    public JTable getTable() {
        return table;
    }

}
