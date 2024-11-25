package br.com.yokohama.seguros.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;
import br.com.yokohama.seguros.utils.SessaoUsuario;

public class AcionarSeguro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField loca;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 20);
        UIManager.put("CheckBox.background", Color.white);
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("TitlePane.inactiveForeground", true);
        UIManager.put("Button.hoverBackground", new Color(105, 7, 7));
        UIManager.put("TextComponent.arc", 20);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AcionarSeguro frame = new AcionarSeguro();
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

    public AcionarSeguro() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnValidar = new JButton("Acionar");
        btnValidar.setBackground(new Color(127, 11, 11));
        btnValidar.setBounds(314, 563, 118, 35);
        contentPane.add(btnValidar);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kouto\\Downloads\\Bell Ringing 2.png"));
        lblNewLabel_1.setBounds(796, 176, 35, 40);
        contentPane.add(lblNewLabel_1);

        loca = new JTextField();
        loca.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        loca.setBackground(new Color(240, 240, 240));
        loca.setBounds(314, 504, 118, 20);
        contentPane.add(loca);
        loca.setColumns(10);

        JButton fundoBtnLoc = new JButton("");
        fundoBtnLoc.setEnabled(false);
        fundoBtnLoc.setBackground(Color.WHITE);
        fundoBtnLoc.setBounds(268, 497, 208, 35);
        contentPane.add(fundoBtnLoc);

        JComboBox<String> tpServico = new JComboBox<>();
        tpServico.setModel(new DefaultComboBoxModel<>(new String[]{"1 - Guincho", "2 - Policia", "3 - Samu", "4 - Bombeiros"}));
        tpServico.setBounds(314, 452, 118, 21);
        contentPane.add(tpServico);

        JButton fundoBtnTpServico = new JButton("");
        fundoBtnTpServico.setEnabled(false);
        fundoBtnTpServico.setBackground(Color.WHITE);
        fundoBtnTpServico.setBounds(268, 445, 208, 35);
        contentPane.add(fundoBtnTpServico);

        JComboBox<String> grauIntensidade = new JComboBox<>();
        grauIntensidade.setModel(new DefaultComboBoxModel<>(new String[]{"1 - Somente ajuda para rebocar veiculo", "2 - Ajuda para pessoas", "3 - Desvirar Carro", "4 - Apagar incendio"}));
        grauIntensidade.setBounds(314, 397, 118, 21);
        contentPane.add(grauIntensidade);

        JComboBox<String> opcCausador = new JComboBox<>();
        opcCausador.setModel(new DefaultComboBoxModel<>(new String[]{"1 - Batida", "2 - Furto", "3 - Capotamento", "4 - Incendio"}));
        opcCausador.setBounds(314, 341, 118, 21);
        contentPane.add(opcCausador);

        JButton fundoBtnIntensidade = new JButton("");
        fundoBtnIntensidade.setEnabled(false);
        fundoBtnIntensidade.setBackground(Color.WHITE);
        fundoBtnIntensidade.setBounds(268, 390, 208, 35);
        contentPane.add(fundoBtnIntensidade);

        JButton fundoBtnCausador = new JButton("");
        fundoBtnCausador.setEnabled(false);
        fundoBtnCausador.setBackground(Color.WHITE);
        fundoBtnCausador.setBounds(268, 335, 208, 35);
        contentPane.add(fundoBtnCausador);

        JLabel lblLocalizao = new JLabel("Localização:");
        lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLocalizao.setBounds(268, 477, 215, 23);
        contentPane.add(lblLocalizao);

        JLabel lblTipoDeSerivo = new JLabel("Tipo de serivço");
        lblTipoDeSerivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTipoDeSerivo.setBounds(268, 422, 215, 23);
        contentPane.add(lblTipoDeSerivo);

        JLabel lblTipoDeServico = new JLabel("Tipo de serviço");
        lblTipoDeServico.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTipoDeServico.setBounds(268, 422, 215, 23);
        contentPane.add(lblTipoDeServico);

        JLabel loc = new JLabel("Grau de intensidade:");
        loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        loc.setBounds(268, 366, 215, 23);
        contentPane.add(loc);

        JLabel causador = new JLabel("Evento Causador:");
        causador.setFont(new Font("Tahoma", Font.PLAIN, 15));
        causador.setBounds(268, 314, 215, 23);
        contentPane.add(causador);

        JCheckBox não = new JCheckBox("Não");
        não.setBackground(Color.WHITE);
        não.setBounds(391, 284, 56, 23);
        contentPane.add(não);

        JCheckBox sim = new JCheckBox("Sim");
        sim.setBackground(new Color(255, 255, 255));
        sim.setBounds(314, 284, 56, 23);
        contentPane.add(sim);

        JButton fundoBtnAssociado = new JButton("");
        fundoBtnAssociado.setEnabled(false);
        fundoBtnAssociado.setBackground(new Color(255, 255, 255));
        fundoBtnAssociado.setBounds(268, 278, 208, 35);
        contentPane.add(fundoBtnAssociado);

        JLabel associado = new JLabel("O responsavel é um associado?");
        associado.setFont(new Font("Tahoma", Font.PLAIN, 15));
        associado.setBounds(268, 254, 215, 23);
        contentPane.add(associado);

        JTextArea obsSinistro = new JTextArea();
        obsSinistro.setLineWrap(true);
        obsSinistro.setText("Observações:");
        obsSinistro.setBounds(667, 255, 408, 277);
        contentPane.add(obsSinistro);
        JLabel sinistro = new JLabel("Acionar Seguro");
        sinistro.setFont(new Font("Tahoma", Font.PLAIN, 35));
        sinistro.setBounds(556, 176, 238, 40);
        contentPane.add(sinistro);

        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon(carregaImagen("/images/image3.png")));
        logo.setBounds(10, -13, 186, 120);
        contentPane.add(logo);

        JButton main = new JButton("");
        main.setEnabled(false);
        main.setBackground(new Color(255, 255, 255));
        main.setBounds(142, 227, 1066, 412);
        contentPane.add(main);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(carregaImagen("/images/Bell.png")));
        lblNewLabel.setBounds(793, 176, 35, 40);
        contentPane.add(lblNewLabel);
        JLabel lblAssit = new JLabel("Assistência 24Hrs");
        lblAssit.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblAssit.setBounds(142, 154, 160, 23);
        contentPane.add(lblAssit);

        JButton headerPage = new JButton("");
        headerPage.setBackground(new Color(255, 255, 255));
        headerPage.setEnabled(false);
        headerPage.setBounds(142, 176, 1066, 40);
        contentPane.add(headerPage);

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

        // Botão para validar
        btnValidar.addActionListener(e -> {
            // Verificando se algum campo obrigatório não foi preenchido ou selecionado
            if (tpServico.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione o tipo de serviço.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (grauIntensidade.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione o grau de intensidade.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (opcCausador.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione o evento causador.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (loca.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira a localização.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (!sim.isSelected() && !não.isSelected()) {
                JOptionPane.showMessageDialog(null, "Por favor, indique se o responsável é um associado.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {

                //Tudo o que acontece após a validação correta
                JOptionPane.showMessageDialog(null, "Validação concluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
}
