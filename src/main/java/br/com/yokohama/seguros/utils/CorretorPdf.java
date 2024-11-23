package br.com.yokohama.seguros.utils;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.SeguroDAO;
import br.com.yokohama.seguros.model.Seguro;
import br.com.yokohama.seguros.model.Usuario;

public class CorretorPdf {

    public static void gerarRelatorioCorretor(Usuario corretor, List<Usuario> clientes, String caminhoArquivo) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Cabeçalho do Relatório
            String nomeCompleto = corretor.getNomeCompletoUsuario();
            String[] nomeSeparado = nomeCompleto.split(" ");
            String nomeSobrenome = nomeSeparado[0] + " " + nomeSeparado[1]; // Nome + Sobrenome

            Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
            String tituloTexto = String.format("Relatório de Clientes - Corretor: %s", nomeSobrenome);
            Paragraph titulo = new Paragraph(tituloTexto, fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            // Informações do Corretor
            Font fontNormal = new Font(Font.HELVETICA, 12, Font.NORMAL);
            Paragraph corretorInfo = new Paragraph(
                    String.format("Corretor: %s\nID do Corretor: %d", corretor.getNomeCompletoUsuario(), corretor.getIdUsuario()),
                    fontNormal
            );
            corretorInfo.setSpacingAfter(20);
            document.add(corretorInfo);

            // Tabela de Clientes
            PdfPTable tabela = new PdfPTable(3);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10);

            tabela.addCell("Nome do Cliente");
            tabela.addCell("ID do Cliente");
            tabela.addCell("Tipos de Seguro");

            // Adicionando os clientes na tabela
            for (Usuario cliente : clientes) {
                if (cliente.getTipoUsuario() == Usuario.TipoUsuario.SEGURADO) {
                    tabela.addCell(cliente.getNomeCompletoUsuario());
                    tabela.addCell(String.valueOf(cliente.getIdUsuario()));

                    String tiposSeguros = obterTiposDeSeguros(cliente);
                    tabela.addCell(tiposSeguros);
                }
            }

            document.add(tabela);

            Paragraph rodape = new Paragraph("Relatório gerado pelo sistema Yokohama Seguros", fontNormal);
            rodape.setAlignment(Element.ALIGN_CENTER);
            rodape.setSpacingBefore(20);
            document.add(rodape);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    // Método que obtém todos os tipos de seguros do cliente
    private static String obterTiposDeSeguros(Usuario cliente) {

        if (cliente == null) {
            return "Cliente inválido";
        }

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();

        if (connection == null) {
            return "Erro de conexão com o banco de dados.";
        }
        SeguroDAO seguroDAO = new SeguroDAO(connection);

        List<Seguro> seguros = seguroDAO.selectByUser(cliente.getIdUsuario());
        if (seguros == null || seguros.isEmpty()) {
            return "Nenhum seguro encontrado para este cliente.";
        }

        return seguros.stream()
                .map(seguro -> seguro.getTipoSeguro().name())
                .sorted() // Ordena alfabeticamente os tipos
                .reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("Nenhum tipo disponível.");
    }

}
