package br.com.yokohama.seguros;

import java.sql.Connection;
import java.util.List;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.FaturaDAO;
import br.com.yokohama.seguros.dao.SeguroDAO;
import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.model.Fatura;
import br.com.yokohama.seguros.model.Seguro;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.utils.CorretorPdf;
import br.com.yokohama.seguros.utils.FaturaPdf;
import br.com.yokohama.seguros.utils.SegurosPdf;

public class TesteGerarPDF {

    public static void main(String[] args) {
        Connection connection = new ConnectionFactory().conectar();
        try {
            // ================= PDF da Fatura =================
            long idFatura = 12345; // Tem que ser fornecido pelo usuário
            FaturaDAO faturaDAO = new FaturaDAO(connection);
            Fatura fatura = faturaDAO.selectById(idFatura);

            if (fatura != null) {
                String caminhoArquivoFatura = "fatura_" + fatura.getIdFatura() + ".pdf";
                FaturaPdf.gerarPdf(fatura, caminhoArquivoFatura);
                System.out.println("PDF gerado: " + caminhoArquivoFatura);
            } else {
                System.out.println("Fatura não encontrada.");
            }

            // ================= PDF do Seguro do Usuário =================
            long idUsuario = 582; // Tem que ser fornecido pelo usuário
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario cliente = usuarioDAO.selectById(idUsuario);

            if (cliente != null) {
                SeguroDAO seguroDAO = new SeguroDAO(connection);
                List<Seguro> seguros = seguroDAO.buscarPorUsuario(idUsuario);

                if (!seguros.isEmpty()) {
                    String nomeArquivoCliente = "Relatorio_Seguros_" + cliente.getNomeCompletoUsuario().replace(" ", "_") + ".pdf";
                    SegurosPdf.gerarPdf(cliente, seguros, nomeArquivoCliente);
                    System.out.println("PDF gerado: " + nomeArquivoCliente);
                } else {
                    System.out.println("Nenhum seguro encontrado para o usuário.");
                }
            } else {
                System.out.println("Usuário não encontrado.");
            }

            // ================= PDF do Corretor e seus Clientes =================
            long idCorretor = 10; //Id fornecido pelo usuário
            UsuarioDAO usuarioDAO2 = new UsuarioDAO(connection);
            Usuario corretor = usuarioDAO2.selectById(idCorretor);

            if (corretor != null) {
                List<Usuario> clientes = usuarioDAO2.buscarClientesPorCorretor(idCorretor);

                if (!clientes.isEmpty()) {
                    String caminhoArquivoCorretor = "Relatorio_Corretor_" + corretor.getNomeCompletoUsuario().replace(" ", "_") + ".pdf";
                    CorretorPdf.gerarRelatorioCorretor(corretor, clientes, caminhoArquivoCorretor);
                    System.out.println("PDF do Corretor gerado: " + caminhoArquivoCorretor);
                } else {
                    System.out.println("Nenhum cliente encontrado para o corretor.");
                }
            } else {
                System.out.println("Corretor não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar os PDFs.");
        }
    }
}
