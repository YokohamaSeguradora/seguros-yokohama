package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractCellEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Faturas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JPanel fotter;
    private JLabel yokohamaLogo;
    private JTextField digitaNome;
    private JLabel labelLupa;
    private JButton yokoButton;
    private JLabel yokoLabel;
    private JPanel fotter_1;
    private JTable table;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("TableHeader.background", new Color(246, 246, 246));
        UIManager.put("TableHeader.separatorColor", new Color(246, 246, 246));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(246, 246, 246));
        UIManager.put("Table.gridColor", Color.red);
        EventQueue.invokeLater(() -> {
            try {
                Faturas frame = new Faturas();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Método para carregar imagens
    public BufferedImage carregaImagen(String str) {
        try {
            return ImageIO.read(getClass().getResource(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Faturas() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        yokoLabel = new JLabel("");
        yokoLabel.setIcon(new ImageIcon(carregaImagen("/images/yoko.png")));
        yokoLabel.setBounds(1214, 557, 126, 118);
        contentPane.add(yokoLabel);

        labelLupa = new JLabel("");
        labelLupa.setIcon(new ImageIcon(carregaImagen("/images/searchResize.png")));
        labelLupa.setBounds(1269, 111, 32, 23);
        contentPane.add(labelLupa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(169, 146, 986, 536);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(246, 246, 246));
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"João", "Vida", "Janeiro", "R$ 120,00", null, "Pendente"},
                {"Maria", "Auto", "Fevereiro", "R$ 80,00", null, "Pago"}
            },
            new String[] {"Nome cliente", "Tipo seguro", "Mês", "Valor fatura", "Fatura", "Estado"}
        ));

        // Configurando o renderer e editor para o botão na coluna "Fatura"
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(table));

        scrollPane.setViewportView(table);

        lblNewLabel = new JLabel("Faturas");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBounds(123, 76, 134, 51);
        contentPane.add(lblNewLabel);

        fotter = new JPanel();
        fotter.setBackground(new Color(127, 11, 11));
        fotter.setBounds(123, 115, 81, 3);
        contentPane.add(fotter);

        yokohamaLogo = new JLabel();
        yokohamaLogo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
        yokohamaLogo.setBounds(10, -16, 186, 120);
        contentPane.add(yokohamaLogo);

        digitaNome = new JTextField();
        digitaNome.setBackground(new Color(246, 246, 246));
        digitaNome.setBounds(848, 108, 453, 27);
        contentPane.add(digitaNome);

        yokoButton = new JButton("yoko");
        yokoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChatBot chat = new ChatBot();
                chat.setVisible(true);
            }
        });
        yokoButton.setOpaque(false);
        yokoButton.setContentAreaFilled(false);
        yokoButton.setBorderPainted(false);
        yokoButton.setBounds(1228, 568, 101, 97);
        contentPane.add(yokoButton);

        fotter_1 = new JPanel();
        fotter_1.setBackground(new Color(0, 0, 0));
        fotter_1.setBounds(0, 83, 1366, 1);
        contentPane.add(fotter_1);

        JButton botaoVoltar = new JButton("");
        botaoVoltar.addActionListener(e -> {
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
        });
        botaoVoltar.setIcon(new ImageIcon(carregaImagen("/images/arrowBack.png")));
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setBackground(new Color(127, 11, 11));
        botaoVoltar.setBounds(-5, 135, 35, 111);
        contentPane.add(botaoVoltar);
    }
}

// Renderer para o botão
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setText("Gerar Fatura");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

// Editor para o botão
class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private int row;

    public ButtonEditor(JTable table) {
        button = new JButton("Gerar Fatura");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(table, "Gerando fatura para a linha: " + (row + 1));
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
