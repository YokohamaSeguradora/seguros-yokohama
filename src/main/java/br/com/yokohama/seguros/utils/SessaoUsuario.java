package br.com.yokohama.seguros.utils;

import br.com.yokohama.seguros.model.Usuario;

public class SessaoUsuario {

    private static SessaoUsuario instancia;
    private Usuario usuarioLogado;

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
    }

    public void limparSessao() {
        this.usuarioLogado = null;
    }

    public boolean isUsuarioLogado() {
        return this.usuarioLogado != null;
    }
}
