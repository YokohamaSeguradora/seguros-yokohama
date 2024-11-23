package br.com.yokohama.seguros;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.FaturaDAO;
import br.com.yokohama.seguros.model.Fatura;
import br.com.yokohama.seguros.model.Fatura.StatusFatura;

public class TesteFatura {

    public static void main(String[] args) {

        Connection connection = new ConnectionFactory().conectar();
        FaturaDAO daoFatura = new FaturaDAO(connection);

        // 1. Teste de inserção
        System.out.println("Inserindo faturas...");
        Fatura fatura1 = new Fatura();
        fatura1.setDataVencimentoFatura(Date.valueOf("2024-12-15"));
        fatura1.setStatusFatura(StatusFatura.PENDENTE);
        fatura1.setValorFatura(450.75);
        fatura1.setIdSeguro(82); // ID de seguro associado (ajustar conforme o banco de dados)
        daoFatura.insert(fatura1);
        System.out.println("Fatura inserida com sucesso.");

        // 2. Teste de consulta
        System.out.println("\nConsultando todas as faturas:");
        List<Fatura> lista = daoFatura.selectAll();
        for (Fatura fatura : lista) {
            System.out.println("Id: " + fatura.getIdFatura());
            System.out.println("Data de vencimento: " + fatura.getDataVencimentoFatura());
            System.out.println("Status: " + fatura.getStatusFatura());
            System.out.println("Valor: R$ " + fatura.getValorFatura());
            System.out.println("Id Seguro: " + fatura.getIdSeguro());
            System.out.println("----");
        }

        // 3. Teste de consulta por ID
        System.out.println("\nConsultando fatura por ID:");
        Fatura faturaPorId = daoFatura.selectById(1); // Ajuste o ID conforme necessário
        if (faturaPorId != null) {
            System.out.println("Fatura encontrada:");
            System.out.println("Id: " + faturaPorId.getIdFatura());
            System.out.println("Data de vencimento: " + faturaPorId.getDataVencimentoFatura());
            System.out.println("Status: " + faturaPorId.getStatusFatura());
            System.out.println("Valor: R$" + faturaPorId.getValorFatura());
            System.out.println("Id Seguro: " + faturaPorId.getIdSeguro());
        } else {
            System.out.println("Fatura com ID especificado não encontrada.");
        }

        // 4. Teste de atualização
        System.out.println("\nAtualizando fatura:");
        Fatura faturaToUpdate = daoFatura.selectById(1); // Ajuste o ID conforme necessário
        if (faturaToUpdate != null) {
            faturaToUpdate.setStatusFatura(StatusFatura.PAGO);
            faturaToUpdate.setValorFatura(500.00);
            daoFatura.update(faturaToUpdate);
            System.out.println("Fatura atualizada.");
        } else {
            System.out.println("Fatura com ID especificado não encontrada para atualização.");
        }

        // 5. Teste de exclusão
        System.out.println("\nExcluindo fatura:");
        daoFatura.delete(1); // Ajuste o ID conforme necessário
        System.out.println("Fatura excluída.");

        // 6. Consulta final para verificar exclusão
        System.out.println("\nConsultando todas as faturas após exclusão:");
        lista = daoFatura.selectAll();
        for (Fatura fatura : lista) {
            System.out.println("Id: " + fatura.getIdFatura());
            System.out.println("Data de vencimento: " + fatura.getDataVencimentoFatura());
            System.out.println("Status: " + fatura.getStatusFatura());
            System.out.println("Valor: R$" + fatura.getValorFatura());
            System.out.println("Id Seguro: " + fatura.getIdSeguro());
            System.out.println("----");
        }
    }
}
