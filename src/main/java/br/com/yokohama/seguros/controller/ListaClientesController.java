package br.com.yokohama.seguros.controller;


import java.util.List;

import br.com.yokohama.seguros.dao.UsuarioDAO;
import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.view.CarteiraCliente;

public class ListaClientesController {
	
	private final CarteiraCliente view;
    private final UsuarioDAO usuarioDAO;
    private final TabelaSeguradosHelper helper;

    

    public ListaClientesController(CarteiraCliente view, UsuarioDAO usuarioDAO) {
        this.view = view;
        this.usuarioDAO = usuarioDAO;
        this.helper = new TabelaSeguradosHelper(view);
    }
	
    public void atualizaTabela() {
        // Não precisa criar outra instância de UsuarioDAO
        List<Usuario> usuariosSegurados = usuarioDAO.buscarTodosSegurados();
        // Exibir esta lista na view
        helper.preencherTabela(usuariosSegurados);
    }
}
