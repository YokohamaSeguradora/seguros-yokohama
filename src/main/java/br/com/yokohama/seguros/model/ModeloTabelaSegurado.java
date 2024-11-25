package br.com.yokohama.seguros.model;

import java.security.PrivateKey;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaSegurado extends AbstractTableModel{

	private static final String[] colunas = {
			"ID", "Nome", "CPF", "E-mail", "Telefone", "Endereço", "CNH"
	};
	
	private ArrayList<Usuario> usuarios;
	
	
	
	public ModeloTabelaSegurado(ArrayList<Usuario> usuarios) {
		super();
		this.usuarios = usuarios;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarios.get(rowIndex);
		if (columnIndex == 0) {
			return usuario.getIdUsuario();
		} else if (columnIndex == 1) {
			return usuario.getNomeCompletoUsuario();
		} else if (columnIndex == 2) {
			return usuario.getCpfUsuario();
		} else if (columnIndex == 3) {
			return usuario.getEmailUsuario();
		} else if (columnIndex == 4) {
			return usuario.getTelefoneUsuario();
		} else if (columnIndex == 5) {
			return usuario.getEnderecoUsuario();
		} else if (columnIndex == 6) {
			return usuario.getCnhSegurado();
		} else {
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
}
