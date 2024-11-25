package br.com.yokohama.seguros.controller;

import java.sql.Connection;
import java.util.function.Predicate;

import br.com.yokohama.seguros.connection.ConnectionFactory;
import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.utils.Criptografia;
import br.com.yokohama.seguros.utils.Criptografia.PadraoCriptografia;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
    	Connection connection = new ConnectionFactory().conectar();
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public void criarUsuario(boolean isCorretor, String nomeCompleto, String nomeSocial, String cpf, String email,
                             String telefone, String senha, String endereco, String cnh) {
        Usuario.TipoUsuario tipoUsuario = isCorretor 
                                          ? Usuario.TipoUsuario.CORRETOR 
                                          : Usuario.TipoUsuario.SEGURADO;

        Usuario usuario = new Usuario(tipoUsuario);
        usuario.setNomeCompletoUsuario(nomeCompleto);
        usuario.setNomeSocialUsuario(nomeSocial);
        usuario.setCpfUsuario(cpf);
        usuario.setEmailUsuario(email);
        usuario.setTelefoneUsuario(telefone);
        usuario.setSenhaUsuario(senha);
        usuario.setEnderecoUsuario(endereco);

        // CNH é aplicável somente para segurados
        if (tipoUsuario == Usuario.TipoUsuario.SEGURADO) {
            usuario.setCnhSegurado(cnh);
        }

        usuarioDAO.insert(usuario);
    }
    
    public boolean isUsuarioCadastrado(String email, String senha) {
    	return usuarioDAO.selectAll().stream()
                .anyMatch(usuario -> {
                    Criptografia criptografia = new Criptografia(senha, PadraoCriptografia.SHA256);
                    System.out.println(usuario.getSenhaUsuario());
                    System.out.println(criptografia.criptografar());
                    return usuario.getEmailUsuario().equals(email)
                            && usuario.getSenhaUsuario().equals(criptografia.criptografar());
                });
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
        return usuarioDAO.selectById(idUsuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioDAO.selectByEmail(email);
    }
    public void atualizarEndereco(int idUsuario, String novoEndereco) {
        if (novoEndereco == null || novoEndereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço não pode estar vazio.");
        }
        Usuario usuario = usuarioDAO.selectById(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        usuario.setEnderecoUsuario(novoEndereco);
        usuarioDAO.update(usuario);
    }

    public void atualizarCelular(int idUsuario, String novoCelular) {
        if (novoCelular == null || !novoCelular.matches("\\d{9,15}")) {
            throw new IllegalArgumentException("O celular deve conter apenas números e entre 9 a 15 dígitos.");
        }
        Usuario usuario = usuarioDAO.selectById(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        usuario.setTelefoneUsuario(novoCelular);
        usuarioDAO.update(usuario);
    }

    public void atualizarEmail(int idUsuario, String novoEmail) {
        if (novoEmail == null || !novoEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        Usuario usuario = usuarioDAO.selectById(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        usuario.setEmailUsuario(novoEmail);
        usuarioDAO.update(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário inválido.");
        }
        if (usuario.getEnderecoUsuario() == null || usuario.getEnderecoUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço do usuário não pode estar vazio.");
        }
        if (usuario.getTelefoneUsuario() == null || !usuario.getTelefoneUsuario().matches("\\d{9,15}")) {
            throw new IllegalArgumentException("O celular deve conter apenas números e entre 9 a 15 dígitos.");
        }
        if (usuario.getEmailUsuario() == null || !usuario.getEmailUsuario().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        usuarioDAO.update(usuario);
    }
}