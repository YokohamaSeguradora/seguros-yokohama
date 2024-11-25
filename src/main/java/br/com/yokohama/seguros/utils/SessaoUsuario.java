package br.com.yokohama.seguros.utils;

import br.com.yokohama.seguros.model.Usuario;

public class SessaoUsuario {

    private static SessaoUsuario instancia;
    private Usuario usuarioLogado;
    private static String nomeUsuario; // Atributo estático 
    private static String telefoneUsuario;

    private SessaoUsuario() {
    }

    public static SessaoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioLogado = usuario;
        if (usuario != null) {
            nomeUsuario = usuario.getNomeCompletoUsuario(); 
            telefoneUsuario = usuario.getTelefoneUsuario();
        } else {
            nomeUsuario = null; 
        }
    }

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void limparSessao() {
        this.usuarioLogado = null;
        nomeUsuario = null; // Reseta o nome do usuário
        telefoneUsuario = null;
    }

    public boolean isUsuarioLogado() {
        return this.usuarioLogado != null;
    } 
}
