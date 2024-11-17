package br.com.yokohama.seguros.model;

public abstract class Seguro {
	public static enum TipoSeguro {
		BICICLETA,
	    CAMINHAO,
	    CARRO,
	    MOTO
	}
	
    private long idSeguro; // PK
    private final TipoSeguro tipoSeguro;
    private long idUsuario; // FK
    private long idAutomovel; // FK
    
    protected Seguro(TipoSeguro tipoSeguro) {
    	this.tipoSeguro = tipoSeguro;
    }

	public long getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(long idSeguro) {
		this.idSeguro = idSeguro;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(long idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}
}
