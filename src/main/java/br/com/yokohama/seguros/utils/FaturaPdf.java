package br.com.yokohama.seguros.utils;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.yokohama.seguros.model.Fatura;

public class FaturaPdf {

    public static void gerarPdf(Fatura fatura, String caminhoArquivo) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            //               Cabeçalho 
            Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Fatura do Seguro", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            //              Informações Gerais 
            Font fontNormal = new Font(Font.HELVETICA, 12, Font.NORMAL);
            PdfPTable tabela = new PdfPTable(2);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10);

            //             Colocando os dados em tabela
            tabela.addCell("ID da Fatura:");
            tabela.addCell(String.valueOf(fatura.getIdFatura()));

            tabela.addCell("Data de Vencimento:");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            tabela.addCell(sdf.format(fatura.getDataVencimentoFatura()));

            tabela.addCell("Status:");
            tabela.addCell(fatura.getStatusFatura().toString());

            tabela.addCell("Valor:");
            tabela.addCell(String.format("R$ %.2f", fatura.getValorFatura()));

            tabela.addCell("ID do Seguro:");
            tabela.addCell(String.valueOf(fatura.getIdSeguro()));

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
}
