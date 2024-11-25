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
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel yokoLabel = new JLabel("");
        yokoLabel.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
        yokoLabel.setBounds(1129, 11, 126, 118);
        contentPane.add(yokoLabel);

        JButton yokoButton = new JButton("yoko");
        yokoButton.setOpaque(false);
        yokoButton.setContentAreaFilled(false);
        yokoButton.setBorderPainted(false);
        yokoButton.setBounds(1138, 23, 101, 97);
        yokoButton.addActionListener(e -> {
            // Add action logic here
            System.out.println("Yoko button clicked!");
        });
        contentPane.add(yokoButton);

        JLabel labelTexto = new JLabel("Carteira dos clientes");
        labelTexto.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelTexto.setBounds(95, 127, 321, 50);
        contentPane.add(labelTexto);

        JButton botaoEstetico = new JButton("");
        botaoEstetico.setEnabled(false);
        botaoEstetico.setBounds(68, 127, 1214, 50);
        contentPane.add(botaoEstetico);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(8, 2));
        scrollPane.setBounds(68, 202, 1214, 487);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        table.setForeground(new Color(0, 0, 0));
        table.setBackground(new Color(246, 246, 246));
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "NOME COMPLETO", "CPF/CNPJ", "E-MAIL", "TELEFONE", "ENDEREÇO", "CNH"}
        ));
        scrollPane.setViewportView(table);

        JLabel yokohamaLogo = new JLabel();
        yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
        yokohamaLogo.setBounds(10, -13, 186, 120);
        contentPane.add(yokohamaLogo);

        // Criando a instância de UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO(new ConnectionFactory().conectar());

        // Passando a instância de UsuarioDAO para o controller
        controller = new ListaClientesController(this, usuarioDAO);
        inicia();
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("TableHeader.background", new Color(246, 246, 246));
        UIManager.put("TableHeader.separatorColor", new Color(246, 246, 246));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(246, 246, 246));
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

    public BufferedImage carregaImagen(String str) {
        try {
            return ImageIO.read(AtualizaAuto.class.getResource(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void centralizarColunas() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Aplica o renderer centralizado a todas as colunas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
    }

    private void inicia() {
        this.controller.atualizaTabela();
        centralizarColunas();
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
