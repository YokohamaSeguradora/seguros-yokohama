package br.com.yokohama.seguros.model;

public abstract class Usuario {
	public static enum TipoUsuario {
		CORRETOR,
		SEGURADO;
	}
	
    private long idUsuario; // PK
    private final TipoUsuario tipoUsuario;
    private String nomeCompletoUsuario;
    private String cpfUsuario; // Único
    private String emailUsuario; // Único
    private String telefoneUsuario; // Único
    private String senhaUsuario;
    private String enderecoUsuario;
    
    protected Usuario(TipoUsuario tipoUsuario) {
    	this.tipoUsuario = tipoUsuario;
    }

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCompletoUsuario() {
		return nomeCompletoUsuario;
	}

	public void setNomeCompletoUsuario(String nomeCompletoUsuario) {
		this.nomeCompletoUsuario = nomeCompletoUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
}
