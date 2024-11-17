package br.com.yokohama.seguros.model;

import java.sql.Date;

public class Automovel {
	public static enum TipoAutomovel {
	    BICICLETA,
	    CAMINHAO,
	    CARRO,
	    MOTO
	}
	
	private long idAutomovel; // PK
    private final TipoAutomovel tipoAutomovel;
    private String placaAutomovel; // Único
    private String renavamAutomovel; // Único
    private String modeloAutomovel;
    private Date dataModeloAutomovel;
    private Date dataFabricacaoAutomovel;
    private String cepPernoiteAutomovel;
    private long idSeguro; // FK
    
    protected Automovel(TipoAutomovel tipoAutomovel) {
    	this.tipoAutomovel = tipoAutomovel;
    }

	public long getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(long idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public String getPlacaAutomovel() {
		return placaAutomovel;
	}

	public void setPlacaAutomovel(String placaAutomovel) {
		this.placaAutomovel = placaAutomovel;
	}

	public String getRenavamAutomovel() {
		return renavamAutomovel;
	}

	public void setRenavamAutomovel(String renavamAutomovel) {
		this.renavamAutomovel = renavamAutomovel;
	}

	public String getModeloAutomovel() {
		return modeloAutomovel;
	}

	public void setModeloAutomovel(String modeloAutomovel) {
		this.modeloAutomovel = modeloAutomovel;
	}

	public Date getDataModeloAutomovel() {
		return dataModeloAutomovel;
	}

	public void setDataModeloAutomovel(Date dataModeloAutomovel) {
		this.dataModeloAutomovel = dataModeloAutomovel;
	}

	public Date getDataFabricacaoAutomovel() {
		return dataFabricacaoAutomovel;
	}

	public void setDataFabricacaoAutomovel(Date dataFabricacaoAutomovel) {
		this.dataFabricacaoAutomovel = dataFabricacaoAutomovel;
	}

	public String getCepPernoiteAutomovel() {
		return cepPernoiteAutomovel;
	}

	public void setCepPernoiteAutomovel(String cepPernoiteAutomovel) {
		this.cepPernoiteAutomovel = cepPernoiteAutomovel;
	}

	public long getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(long idSeguro) {
		this.idSeguro = idSeguro;
	}

	public TipoAutomovel getTipoAutomovel() {
		return tipoAutomovel;
	}
}
