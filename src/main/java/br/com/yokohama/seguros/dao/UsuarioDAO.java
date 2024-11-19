package br.com.yokohama.seguros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	// insert
	public void insert(Usuario usuario) {
		String sql = "insert into usuario (tipo_usuario, nome_completo_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, endereco_usuario, cnh_segurado) values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getTipoUsuario().getCodigo());
			stmt.setString(2, usuario.getNomeCompletoUsuario());
			stmt.setString(3, usuario.getCpfUsuario());
			stmt.setString(4, usuario.getEmailUsuario());
			stmt.setString(5, usuario.getTelefoneUsuario());
			stmt.setObject(6, usuario.getSenhaUsuario());
			stmt.setString(7, usuario.getEnderecoUsuario());
			stmt.setString(8, usuario.getCnhSegurado());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete
	public void delete(long id) {
		String sql = "delete from usuario where id_usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update
	public void update(Usuario usuario) {
		String sql = "update usuario set tipo_usuario=?, nome_completo_usuario=?, cpf_usuario=?, email_usuario=?, telefone_usuario=?, senha_usuario=?, endereco_usuario=?, cnh_segurado=? where id_usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getTipoUsuario().getCodigo());
			stmt.setString(2, usuario.getNomeCompletoUsuario());
			stmt.setString(3, usuario.getCpfUsuario());
			stmt.setString(4, usuario.getEmailUsuario());
			stmt.setString(5, usuario.getTelefoneUsuario());
			stmt.setObject(6, usuario.getSenhaUsuario());
			stmt.setString(7, usuario.getEnderecoUsuario());
			stmt.setString(8, usuario.getCnhSegurado());
			stmt.setLong(9, usuario.getIdUsuario());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// selectAll
	public List<Usuario> selectAll() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario;
		String sql = "select * from usuario order by nome_completo_usuario";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {		
				usuario = new Usuario(TipoUsuario.fromCodigo(rs.getString("tipo_usuario")));
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeCompletoUsuario(rs.getString("nome_completo_usuario"));
				usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setEmailUsuario(rs.getString("email_usuario"));
				usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
				usuario.setSenhaUsuario(rs.getString("senha_usuario"));
				listaUsuarios.add(usuario);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	// selectById
	public Usuario selectById(long id) {
		Usuario usuario = null;
		String sql = "select * from usuario where id_usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario(TipoUsuario.fromCodigo(rs.getString("tipo_usuario")));
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNomeCompletoUsuario(rs.getString("nome_completo_usuario"));
				usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
				usuario.setCpfUsuario(rs.getString("cpf_usuario"));
				usuario.setEmailUsuario(rs.getString("email_usuario"));
				usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
				usuario.setSenhaUsuario(rs.getString("senha_usuario"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
