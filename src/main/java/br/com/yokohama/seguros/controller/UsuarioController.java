package br.com.yokohama.seguros.controller;

import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.model.Usuario;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void criarUsuario(boolean isCorretor, String nomeCompleto, String cpf, String email, 
                             String telefone, String senha, String endereco, String cnh) {
        Usuario.TipoUsuario tipoUsuario = isCorretor 
                                          ? Usuario.TipoUsuario.CORRETOR 
                                          : Usuario.TipoUsuario.SEGURADO;

        Usuario usuario = new Usuario(tipoUsuario);
        usuario.setNomeCompletoUsuario(nomeCompleto);
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

    public Usuario buscarUsuarioPorId(int idUsuario) {
        return usuarioDAO.selectById(idUsuario);
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
