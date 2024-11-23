package br.com.yokohama.seguros.utils;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.AutomovelDAO;
import br.com.yokohama.seguros.model.Automovel;
import br.com.yokohama.seguros.model.Seguro;
import br.com.yokohama.seguros.model.Usuario;

public class SegurosPdf {

    public static void gerarPdf(Usuario cliente, List<Seguro> seguros, String caminhoArquivo) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Cabeçalho do Relatório
            String nomeCompleto = cliente.getNomeCompletoUsuario();
            String[] nomeSeparado = nomeCompleto.split(" ");
            String nomeSobrenome = nomeSeparado[0] + " " + nomeSeparado[1]; // Nome + Sobrenome

            Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
            String tituloTexto = String.format("Relatório de Seguros - %s", nomeSobrenome);
            Paragraph titulo = new Paragraph(tituloTexto, fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            // Informações do Cliente
            Font fontNormal = new Font(Font.HELVETICA, 12, Font.NORMAL);
            Paragraph clienteInfo = new Paragraph(
                    String.format("Cliente: %s\nID do Usuário: %d", cliente.getNomeCompletoUsuario(), cliente.getIdUsuario()),
                    fontNormal
            );
            clienteInfo.setSpacingAfter(20);
            document.add(clienteInfo);

            // Tabela de Seguros
            PdfPTable tabela = new PdfPTable(4);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10);

            // Cabeçalhos da Tabela
            tabela.addCell("ID Seguro");
            tabela.addCell("Tipo de Seguro");
            tabela.addCell("Modelo do Automóvel");
            tabela.addCell("Placa do Automóvel");

            // Adicionando dados dos seguros
            for (Seguro seguro : seguros) {
                tabela.addCell(String.valueOf(seguro.getIdSeguro()));
                tabela.addCell(seguro.getTipoSeguro().toString());

                Automovel automovel = buscarAutomovelPorId(seguro.getIdAutomovel());
                tabela.addCell(automovel.getModeloAutomovel());
                tabela.addCell(automovel.getPlacaAutomovel());
            }

            document.add(tabela);

            //                      Rodapé
            Paragraph rodape = new Paragraph("Obrigado por escolher nossos Serviços", fontNormal);
            Paragraph rodape2 = new Paragraph("Yokohama Seguros. Protegendo o que te move", fontNormal);

            rodape.setAlignment(Element.ALIGN_CENTER);
            rodape.setSpacingBefore(20);

            rodape2.setAlignment(Element.ALIGN_CENTER);
            rodape2.setSpacingBefore(20);
            document.add(rodape);
            document.add(rodape2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    private static Automovel buscarAutomovelPorId(long idAutomovel) {
        Connection connection = null;
        Automovel automovel = null;

        try {
            // Obtém a conexão com o banco de dados
            connection = new ConnectionFactory().conectar();
            AutomovelDAO automovelDAO = new AutomovelDAO(connection);

            automovel = automovelDAO.selectById(idAutomovel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // Fecha a conexão
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return automovel;
    }
}
