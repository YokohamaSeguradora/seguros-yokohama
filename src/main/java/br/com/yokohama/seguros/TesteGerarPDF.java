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
import br.com.yokohama.seguros.utils.CorretorPdf;
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


         //                  PDF do Corretor e seus Clientes

        // Criação de um corretor (Somente para teste)
        Usuario corretor = new Usuario(Usuario.TipoUsuario.CORRETOR);
        corretor.setIdUsuario(10);
        corretor.setNomeCompletoUsuario("Emerson Colosseti Java Super");

        // Criação de uma lista de clientes (somente para teste)
        List<Usuario> clientes = new ArrayList<>();
        Usuario cliente1 = new Usuario(Usuario.TipoUsuario.SEGURADO);
        cliente1.setIdUsuario(1);
        cliente1.setNomeCompletoUsuario("Rodrigo Bettio Penha Junior");

        Usuario cliente2 = new Usuario(Usuario.TipoUsuario.SEGURADO);
        cliente2.setIdUsuario(2);
        cliente2.setNomeCompletoUsuario("Maria Souza Silva");

        clientes.add(cliente1);
        clientes.add(cliente2);

        // Gerar PDF do Relatório do Corretor
        String caminhoArquivoCorretor = "Relatorio_Corretor_" + corretor.getNomeCompletoUsuario().replace(" ", "_") + ".pdf";
        CorretorPdf.gerarRelatorioCorretor(corretor, clientes, caminhoArquivoCorretor);
        System.out.println("PDF do Corretor gerado: " + caminhoArquivoCorretor);
    }
    
}
