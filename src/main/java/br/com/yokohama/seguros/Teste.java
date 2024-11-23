package br.com.yokohama.seguros;

import java.sql.Connection;
import java.util.List;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;

public class Teste {

	public static void main(String[] args) {

		Connection connection = new ConnectionFactory().conectar();
		UsuarioDAO daoUsuario = new UsuarioDAO(connection);

		// 1. Teste de Inserção
		System.out.println("Inserindo usuários...");
		Usuario usuario1 = new Usuario(TipoUsuario.SEGURADO, "João da Silva", "12345678900", "joao.silva@example.com", "11987654321", "senhaSegura123", "Rua Exemplo, 123, Bairro Central", null);
		//Usuario usuario2 = new Usuario(TipoUsuario.CORRETOR, "Maria Oliveira", "98765432100", "maria.oliveira@example.com", "21998765432", "senhaForte456", "Av. Principal, 456, Centro", "98765210");
		Usuario usuario2 = new Usuario(TipoUsuario.CORRETOR, "Rodrigo", "98765432100", "maria.oliveira@example.com", "21998765432", "senhaForte456", "Av. Principal, 456, Centro", "98765210");
		daoUsuario.insert(usuario1);
		daoUsuario.insert(usuario2);
		System.out.println("Inserção concluída.\n");

		// 2. Teste de Consulta
		System.out.println("Consultando todos os usuarios:");
		List<Usuario> lista = daoUsuario.selectAll();
		for (Usuario usuario : lista) {
			System.out.println("Id: " + usuario.getIdUsuario());
			System.out.println("Nome: " + usuario.getNomeCompletoUsuario());
			System.out.println("Email: " + usuario.getEmailUsuario());
			System.out.println("----");
		}

		// Consulta por ID
		System.out.println("\nConsultando usuário por ID:");
		Usuario usuarioPorId = daoUsuario.selectById(2);
		if (usuarioPorId != null) {
			System.out.println("Usuário encontrado: " + usuarioPorId.getNomeCompletoUsuario());
		} else {
			System.out.println("Usuário com ID especificado não encontrado.");
		}
		
		// 3. Teste de Atualização 
		System.out.println("\nAtualizando usuário:");
		
		Usuario usuario2Updated = daoUsuario.selectById(2);
		usuario2Updated.setNomeCompletoUsuario("Emerson Silva");
		usuario2Updated.setEmailUsuario("emerson.silva@gmail.com");
		daoUsuario.update(usuario2Updated);
		System.out.println("Usuário atualizado.\n");
		

		// 4. Teste de Exclusão
		System.out.println("Excluindo usuário:");
		daoUsuario.delete(2);
		System.out.println("Usuário excluído.\n");

		// Consulta final para verificar exclusão
		System.out.println("Consultando todos os candidatos após exclusão:");
		lista = daoUsuario.selectAll();
		for (Usuario usuario : lista) {
			System.out.println("Id: " + usuario.getIdUsuario());
			System.out.println("Nome: " + usuario.getNomeCompletoUsuario());
			System.out.println("Email: " + usuario.getEmailUsuario());
			System.out.println("----");
		}

	}

}
