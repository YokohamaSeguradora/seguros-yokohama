package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoEmail;
    private JButton botaoProximo;
    private JTextField campoSenha, campoCpf, campoTelefone, campoNome, campoEndereco, campoNomeSocial, campoCNH;
    private JCheckBox checkCorretor, checkSocial;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Button.arc", 20);
        EventQueue.invokeLater(() -> {
            try {
                Register frame = new Register();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BufferedImage carregaImagem(String str) {
        try {
            return ImageIO.read(Register.class.getResource(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        JPanel backgroundAll = new JPanel();
        backgroundAll.setBackground(new Color(255, 255, 255));
        backgroundAll.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(backgroundAll);
        backgroundAll.setLayout(null);

        JLabel lblCadastro = new JLabel("Cadastro");
        lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblCadastro.setBounds(578, 53, 250, 61);
        backgroundAll.add(lblCadastro);

        // Componentes de entrada
        campoEmail = criaCampoTexto(backgroundAll, "Email", 154, 175);
        campoSenha = criaCampoTexto(backgroundAll, "Senha", 154, 251);
        campoCpf = criaCampoTexto(backgroundAll, "CPF", 154, 327);
        campoTelefone = criaCampoTexto(backgroundAll, "Telefone", 154, 399);
        campoNome = criaCampoTexto(backgroundAll, "Nome completo", 702, 175);
        campoEndereco = criaCampoTexto(backgroundAll, "Endereço completo", 702, 399);
        campoNomeSocial = criaCampoTexto(backgroundAll, "Nome social", 702, 251);
        campoCNH = criaCampoTexto(backgroundAll, "CNH", 702, 327);

        campoNomeSocial.setEnabled(false);

        // Checkboxes
        checkSocial = new JCheckBox("Nome social?");
        checkSocial.setBounds(1130, 292, 150, 23);
        checkSocial.addActionListener(e -> {
            campoNomeSocial.setEnabled(checkSocial.isSelected());
            if (!checkSocial.isSelected()) {
                campoNomeSocial.setText("");
            }
        });
        backgroundAll.add(checkSocial);

        checkCorretor = new JCheckBox("Sou corretor");
        checkCorretor.setBounds(1130, 368, 150, 23);
        checkCorretor.addActionListener(e -> {
            campoCNH.setEnabled(!checkCorretor.isSelected());
            if (checkCorretor.isSelected()) {
                campoCNH.setText("");
            }
        });
        backgroundAll.add(checkCorretor);

        // Botão de continuar
        botaoProximo = new JButton("Continuar");
        botaoProximo.setBounds(563, 554, 223, 40);
        botaoProximo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoProximo.setForeground(Color.WHITE);
        botaoProximo.setBackground(new Color(127, 11, 11));
        botaoProximo.addActionListener(e -> {
            if (!validaCamposObrigatorios()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha todos os campos obrigatórios.",
                        "Erro de validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Abrir a próxima página (SimulaSeguroCliente)
            SimulaSeguroCliente simulaSeguro = new SimulaSeguroCliente();
            simulaSeguro.setVisible(true);
            dispose(); // Fecha a tela atual
        });
        backgroundAll.add(botaoProximo);

        // Logo
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(carregaImagem("/images/image3.png")));
        logo.setBounds(10, -13, 186, 120);
        backgroundAll.add(logo);
    }

    private JTextField criaCampoTexto(JPanel panel, String label, int x, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(x, y - 15, 150, 14);
        panel.add(lbl);

        JTextField textField = new JTextField();
        textField.setBounds(x, y, 522, 40);
        panel.add(textField);

        return textField;
    }

    private boolean validaCamposObrigatorios() {
        return !campoEmail.getText().trim().isEmpty()
                && !campoSenha.getText().trim().isEmpty()
                && !campoCpf.getText().trim().isEmpty()
                && !campoTelefone.getText().trim().isEmpty()
                && !campoNome.getText().trim().isEmpty()
                && !campoEndereco.getText().trim().isEmpty()
                && (!checkSocial.isSelected() || !campoNomeSocial.getText().trim().isEmpty())
                && (!checkCorretor.isSelected() || !campoCNH.getText().trim().isEmpty());
    }
}
