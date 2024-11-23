package br.com.yokohama.seguros;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.AutomovelDAO;
import br.com.yokohama.seguros.model.Automovel;
import br.com.yokohama.seguros.model.Automovel.TipoAutomovel;

public class TesteAutomovel {

    public static void main(String[] args) {

        Connection connection = new ConnectionFactory().conectar();
        AutomovelDAO daoAutomovel = new AutomovelDAO(connection);

        // 1. Teste de inserção
        System.out.println("Inserindo automóveis...");
        Automovel automovel1 = new Automovel(
                TipoAutomovel.CARRO, // enum ou classe similar
                "ABC1234", // placaAutomovel
                "98765432101", // renavamAutomovel
                "Honda Civic", // modeloAutomovel
                new Date(2020, 1, 1), // dataModeloAutomovel (15/06/2022)
                new Date(2020, 1, 1), // dataFabricacaoAutomovel (10/11/2021)
                "01001000" // cepPernoiteAutomovel
        );
        daoAutomovel.insert(automovel1);
        System.out.println("Automóvel inserido com sucesso.");

        // 2. Teste de consulta
        System.out.println("\nConsultando todos os automóveis:");
        List<Automovel> lista = daoAutomovel.selectAll();
        for (Automovel automovel : lista) {
            System.out.println("Id: " + automovel.getIdAutomovel());
            System.out.println("Tipo: " + automovel.getTipoAutomovel());
            System.out.println("Modelo: " + automovel.getModeloAutomovel());
            System.out.println("Placa: " + automovel.getPlacaAutomovel());
            System.out.println("CEP pernoite: " + automovel.getCepPernoiteAutomovel());
            System.out.println("----");
        }

        // 3. Teste de consulta por ID
        System.out.println("\nConsultando automóvel por ID:");
        Automovel automovelPorId = daoAutomovel.selectById(1); // troque o ID conforme necessário
        if (automovelPorId != null) {
            System.out.println("Automóvel encontrado: " + automovelPorId.getModeloAutomovel());
        } else {
            System.out.println("Automóvel com ID especificado não encontrado.");
        }

        // 4. Teste de atualização
        System.out.println("\nAtualizando automóvel:");
        Automovel automovelToUpdate = daoAutomovel.selectById(1); // troque o ID conforme necessário
        if (automovelToUpdate != null) {
            automovelToUpdate.setModeloAutomovel("Toyota Corolla");
            automovelToUpdate.setCepPernoiteAutomovel("02020200");
            daoAutomovel.update(automovelToUpdate);
            System.out.println("Automóvel atualizado.");
        } else {
            System.out.println("Automóvel com ID especificado não encontrado para atualização.");
        }

        // 5. Teste de exclusão
//        System.out.println("\nExcluindo automóvel:");
//        daoAutomovel.delete(1); // troque o ID conforme necessário
//        System.out.println("Automóvel excluído.");
        // 6. Consulta final para verificar exclusão
        System.out.println("\nConsultando todos os automóveis após exclusão:");
        lista = daoAutomovel.selectAll();
        for (Automovel automovel : lista) {
            System.out.println("Id: " + automovel.getIdAutomovel());
            System.out.println("Modelo: " + automovel.getModeloAutomovel());
            System.out.println("Placa: " + automovel.getPlacaAutomovel());
            System.out.println("----");
        }
    }
}
