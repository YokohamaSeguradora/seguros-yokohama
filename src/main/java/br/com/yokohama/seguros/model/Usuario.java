package br.com.yokohama.seguros.model;

public class Usuario {
	public static enum TipoUsuario {
		CORRETOR("C"),
		SEGURADO("S");
		
		private final String codigo;
		
		TipoUsuario(String codigo) {
			this.codigo = codigo;
		}
		
		public String getCodigo() {
			return this.codigo;
		}


		// Método para converter uma String para o valor do Enum
		public static TipoUsuario fromCodigo(String codigo) {
			for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
				if (tipoUsuario.getCodigo().equalsIgnoreCase(codigo)) {
					return tipoUsuario;
				}
			}
			throw new IllegalArgumentException("Código de usuário inválido: " + codigo);
		}
	}
	
    private long idUsuario; // PK
    private final TipoUsuario tipoUsuario;
    private String nomeCompletoUsuario;
    private String cpfUsuario; // Único
    private String emailUsuario; // Único
    private String telefoneUsuario; // Único
    private String senhaUsuario;
    private String enderecoUsuario;
	private String cnhSegurado; // Único
    
    public Usuario(TipoUsuario tipoUsuario) {
    	this.tipoUsuario = tipoUsuario;
    }
    
    

	public Usuario(TipoUsuario tipoUsuario, String nomeCompletoUsuario, String cpfUsuario, String emailUsuario,
			String telefoneUsuario, String senhaUsuario, String enderecoUsuario, String cnhSegurado) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.nomeCompletoUsuario = nomeCompletoUsuario;
		this.cpfUsuario = cpfUsuario;
		this.emailUsuario = emailUsuario;
		this.telefoneUsuario = telefoneUsuario;
		this.senhaUsuario = senhaUsuario;
		this.enderecoUsuario = enderecoUsuario;
		this.cnhSegurado = cnhSegurado;
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

	public String getCnhSegurado() {
		return cnhSegurado;
	}

	public void setCnhSegurado(String cnhSegurado) {
		this.cnhSegurado = cnhSegurado;
	}
}
