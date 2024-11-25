package br.com.yokohama.seguros;

import java.sql.Connection;
import java.util.List;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.SeguroDAO;
import br.com.yokohama.seguros.model.Seguro;
import br.com.yokohama.seguros.model.Seguro.TipoSeguro;

public class TesteSeguro {

    public static void main(String[] args) {

        Connection connection = new ConnectionFactory().conectar();
        SeguroDAO daoSeguro = new SeguroDAO(connection);

        // 1. Teste de inserção
        System.out.println("Inserindo seguros...");
        Seguro seguro1 = new Seguro(TipoSeguro.CARRO, 582, 21);
        daoSeguro.insert(seguro1);

        // 2. Teste de Consulta
        System.out.println("Consultando todos os seguros:");
        List<Seguro> lista = daoSeguro.selectAll();
        for (Seguro seguro : lista) {
            System.out.println("Id: " + seguro.getIdSeguro());
            System.out.println("Id automóvel: " + seguro.getIdAutomovel());
            System.out.println("Id usuário" + seguro.getIdUsuario());
            System.out.println("----");
        }

        // Consulta por ID
        System.out.println("\nConsultando seguro por ID:");
        Seguro seguroPorId = daoSeguro.selectById(582);
        if (seguroPorId != null) {
            System.out.println("Seguro encontrado: " + seguroPorId.getIdSeguro());
        } else {
            System.out.println("Seguro com ID especificado não encontrado.");
        }

        // 3. Teste de Atualização 
        System.out.println("\nAtualizando seguro:");

        Seguro seguro1Updated = daoSeguro.selectById(2);
        seguro1Updated.setIdAutomovel(2);
        daoSeguro.update(seguro1Updated);
        System.out.println("Seguro atualizado.\n");

        // 4. Teste de Exclusão
        System.out.println("Excluindo usuário:");
        daoSeguro.delete(2);
        System.out.println("Usuário excluído.\n");

        // Consulta final para verificar exclusão
        System.out.println("Consultando todos os seguros após exclusão:");
        lista = daoSeguro.selectAll();
        for (Seguro seguro : lista) {
            System.out.println("Id: " + seguro.getIdSeguro());
            System.out.println("Id automóvel: " + seguro.getIdAutomovel());
            System.out.println("Id usuário" + seguro.getIdUsuario());
            System.out.println("----");
        }
    }
}
