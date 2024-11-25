package br.com.yokohama.seguros.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.yokohama.seguros.model.Usuario;
import br.com.yokohama.seguros.view.CarteiraCliente;


public class TabelaSeguradosHelper {

	private final CarteiraCliente view;

	public TabelaSeguradosHelper(CarteiraCliente view) {
		this.view = view;
	}

	public void preencherTabela(List<Usuario> usuariosSegurados) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
		tableModel.setNumRows(0);
		for(Usuario usuarioSegurado : usuariosSegurados) {
			tableModel.addRow(new Object[] {
					usuarioSegurado.getIdUsuario(),
					usuarioSegurado.getNomeCompletoUsuario(),
					usuarioSegurado.getCpfUsuario(),
					usuarioSegurado.getEmailUsuario(),
					usuarioSegurado.getTelefoneUsuario(),
					usuarioSegurado.getEnderecoUsuario(),
					usuarioSegurado.getCnhSegurado()
			});
		}
	}	
	
}
