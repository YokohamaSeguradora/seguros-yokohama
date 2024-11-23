package br.com.yokohama.seguros;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.yokohama.seguros.model.Fatura;
import br.com.yokohama.seguros.model.Fatura.StatusFatura;
import br.com.yokohama.seguros.model.Seguro;
import br.com.yokohama.seguros.model.SeguroCarro;
import br.com.yokohama.seguros.model.SeguroMoto;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.utils.FaturaPdf;
import br.com.yokohama.seguros.utils.SegurosPdf;

public class TesteGerarPDF {

    public static void main(String[] args) {

        //                  PDF da Fatura 
        // Criação da Fatura (Só para testes)
        Fatura fatura = new Fatura();
        fatura.setIdFatura(12345);
        fatura.setDataVencimentoFatura(Date.valueOf("2024-12-01"));
        fatura.setStatusFatura(StatusFatura.PENDENTE);
        fatura.setValorFatura(150.75);
        fatura.setIdSeguro(67890);

        // Gerar o PDF
        String caminhoArquivoFatura = "fatura12345.pdf";
        FaturaPdf.gerarPdf(fatura, caminhoArquivoFatura);

        System.out.println("PDF gerado: " + caminhoArquivoFatura);

        //                  PDF do Seguro do Usuário X

        // Criação do Usuário (Só para teste)
        Usuario cliente = new Usuario(Usuario.TipoUsuario.SEGURADO);
        cliente.setIdUsuario(1);
        cliente.setNomeCompletoUsuario("Rodrigo Bettio Penha Junior");

        // Criação de seguros (Só para teste)
        List<Seguro> seguros = new ArrayList<>();
        Seguro seguro1 = new SeguroCarro();
        seguro1.setIdSeguro(101);
        seguro1.setIdAutomovel(1001);

        Seguro seguro2 = new SeguroMoto();
        seguro2.setIdSeguro(102);
        seguro2.setIdAutomovel(1002);

        seguros.add(seguro1);
        seguros.add(seguro2);

        String nomeArquivoCliente = "Relatorio_Seguros_" + cliente.getNomeCompletoUsuario().replace(" ", "_") + ".pdf";
        SegurosPdf.gerarPdf(cliente, seguros, nomeArquivoCliente);

        System.out.println("PDF gerado: " + nomeArquivoCliente);
    }
}
