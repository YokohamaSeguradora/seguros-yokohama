package br.com.yokohama.seguros.model;

import java.sql.Date;

public class Fatura {

    public static enum StatusFatura {
        PAGO,
        PENDENTE;
    }

    private long idFatura; // PK
    private Date dataVencimentoFatura;
    private StatusFatura statusFatura;
    private double valorFatura;
    private long idSeguro; // FK

    public long getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(long idFatura) {
        this.idFatura = idFatura;
    }

    public Date getDataVencimentoFatura() {
        return dataVencimentoFatura;
    }

    public void setDataVencimentoFatura(Date dataVencimentoFatura) {
        this.dataVencimentoFatura = dataVencimentoFatura;
    }

    public StatusFatura getStatusFatura() {
        return statusFatura;
    }

    public void setStatusFatura(StatusFatura statusFatura) {
        this.statusFatura = statusFatura;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(long idSeguro) {
        this.idSeguro = idSeguro;
    }
}
