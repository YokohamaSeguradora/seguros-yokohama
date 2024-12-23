package br.com.yokohama.seguros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.yokohama.seguros.utils.Criptografia;
import br.com.yokohama.seguros.utils.Criptografia.PadraoCriptografia;
import br.com.yokohama.seguros.utils.SessaoUsuario;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.model.Usuario.TipoUsuario;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    private String criptografarSenha(String senha) {
        Criptografia criptografia = new Criptografia(senha, PadraoCriptografia.SHA256);
        return criptografia.criptografar();
    }

    // insert
    public void insert(Usuario usuario) {

        // Gerar o salt com a classe Criptografia
        Criptografia criptografia = new Criptografia(usuario.getSenhaUsuario(), PadraoCriptografia.SHA256);

        // Criptografar a senha com salt
        String senhaCriptografada = criptografia.criptografar();  // Criptografar a senha

        // SQL para inserir o usuário com o hash
        String sql = "insert into usuario (tipo_usuario, nome_completo_usuario, nome_social_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, endereco_usuario, cnh_segurado) values (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getTipoUsuario().getCodigo());
            stmt.setString(2, usuario.getNomeCompletoUsuario());
            stmt.setString(3, usuario.getNomeSocialUsuario());
            stmt.setString(4, usuario.getCpfUsuario());
            stmt.setString(5, usuario.getEmailUsuario());
            stmt.setString(6, usuario.getTelefoneUsuario());
            stmt.setString(7, senhaCriptografada);  // Senha criptografada
            stmt.setString(8, usuario.getEnderecoUsuario());
            stmt.setString(9, usuario.getCnhSegurado());
            stmt.execute();
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
        String sql = "update usuario set tipo_usuario=?, nome_completo_usuario=?, nome_social_usuario=?, cpf_usuario=?, email_usuario=?, telefone_usuario=?, senha_usuario=?, endereco_usuario=?, cnh_segurado=? where id_usuario=?";
        try {
            // Criptografa a senha antes de atualizar

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getTipoUsuario().getCodigo());
            stmt.setString(2, usuario.getNomeCompletoUsuario());
            stmt.setString(3, usuario.getNomeSocialUsuario());
            stmt.setString(4, usuario.getCpfUsuario());
            stmt.setString(5, usuario.getEmailUsuario());
            stmt.setString(6, usuario.getTelefoneUsuario());
            stmt.setObject(7, criptografarSenha(usuario.getSenhaUsuario()));
            stmt.setString(8, usuario.getEnderecoUsuario());
            stmt.setString(9, usuario.getCnhSegurado());
            stmt.setLong(10, usuario.getIdUsuario());
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
                usuario.setNomeSocialUsuario(rs.getString("nome_social_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                usuario.setCnhSegurado(rs.getString("cnh_segurado"));
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
                usuario.setNomeSocialUsuario(rs.getString("nome_social_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                usuario.setCnhSegurado(rs.getString("cnh_segurado"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario selectByEmail(String email) {
        Usuario usuario = null;
        String sql = "select * from usuario where email_usuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(TipoUsuario.fromCodigo(rs.getString("tipo_usuario")));
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNomeCompletoUsuario(rs.getString("nome_completo_usuario"));
                usuario.setNomeSocialUsuario(rs.getString("nome_social_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                usuario.setCnhSegurado(rs.getString("cnh_segurado"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // selectByCorretor
    public List<Usuario> buscarClientesPorCorretor(long idCorretor) {
        List<Usuario> listaClientes = new ArrayList<Usuario>();
        Usuario usuario;
        String sql = "select * from usuario where id_corretor = ? order by nome_completo_usuario";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idCorretor);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(TipoUsuario.fromCodigo(rs.getString("tipo_usuario")));
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNomeCompletoUsuario(rs.getString("nome_completo_usuario"));
                usuario.setNomeSocialUsuario(rs.getString("nome_social_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                listaClientes.add(usuario);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaClientes;
    }

    // selectBySegurado
    public List<Usuario> buscarTodosSegurados() {
        List<Usuario> listaSegurados = new ArrayList<Usuario>();
        Usuario usuario;
        String sql = "select * from usuario where tipo_usuario = 'S' order by nome_completo_usuario";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(TipoUsuario.fromCodigo(rs.getString("tipo_usuario")));
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNomeCompletoUsuario(rs.getString("nome_completo_usuario"));
                usuario.setNomeSocialUsuario(rs.getString("nome_social_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                listaSegurados.add(usuario);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSegurados;
    }

    public Usuario autenticarUsuario(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hashArmazenado = rs.getString("senha_usuario");
                    Criptografia criptografia = new Criptografia(senha, PadraoCriptografia.SHA256);
                    String hashSenha = criptografia.criptografar();

                    if (hashSenha.equals(hashArmazenado)) {
                        Usuario usuario = new Usuario(TipoUsuario.fromCodigo(rs.getString("tipo_usuario")));
                        usuario.setIdUsuario(rs.getLong("id_usuario"));
                        usuario.setNomeCompletoUsuario(rs.getString("nome_completo_usuario"));
                        usuario.setNomeSocialUsuario(rs.getString("nome_social_usuario"));
                        usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                        usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                        usuario.setEmailUsuario(rs.getString("email_usuario"));
                        usuario.setEnderecoUsuario(rs.getString("endereco_usuario"));

                        // Configura o usuário na sessão
                        SessaoUsuario.getInstancia().setUsuario(usuario);
                        return usuario;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Caso o email não exista ou a senha seja incorreta
    }

}
