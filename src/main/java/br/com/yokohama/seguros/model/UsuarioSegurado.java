package br.com.yokohama.seguros.model;

public class UsuarioSegurado extends Usuario {
	
	private String cnhSegurado; // Único
	
	public UsuarioSegurado() {
		super(TipoUsuario.SEGURADO);
	}

	public String getCnhSegurado() {
		return cnhSegurado;
	}
	
	public void setCnhSegurado(String cnhSegurado) {
		this.cnhSegurado = cnhSegurado;
	}

}
