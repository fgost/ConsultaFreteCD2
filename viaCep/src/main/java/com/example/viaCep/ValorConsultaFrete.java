package com.example.viaCep;

import java.util.Date;

public class ValorConsultaFrete {
    private Double valorFrete;
    private String cepOrigem;
    private String cepDestino;
    private Date dataPrevisao;

    public ValorConsultaFrete(Double valorFrete, String cepOrigem, String cepDestino, Date dataPrevisao) {
        this.valorFrete = valorFrete;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.dataPrevisao = dataPrevisao;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }
}
