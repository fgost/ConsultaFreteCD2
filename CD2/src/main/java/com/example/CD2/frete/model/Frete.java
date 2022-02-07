package com.example.CD2.frete.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "autor")
public class Frete implements Serializable {
    @Column(name="id")
    private Long id;
    private int cepOrigem;
    private int cepDestino;
    private float peso;
    private String nomeDestinatario;
    private float valor;
    private int desconto;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public int getCepOrigem() {return cepOrigem;}

    public void setCepOrigem(int cepOrigem) {this.cepOrigem = cepOrigem;}

    public int getCepDestino() {return cepDestino;}

    public void setCepDestino(int cepDestino) {this.cepDestino = cepDestino;}

    public float getPeso() {return peso;}

    public void setPeso(float peso) {this.peso = peso;}

    public String getNomeDestinatario() {return nomeDestinatario;}

    public void setNomeDestinatario(String nomeDestinatario) {this.nomeDestinatario = nomeDestinatario;}

    public float getValor() {return valor;}

    public void setValor(float valor) {this.valor = valor;}

    public int getDesconto() {return desconto;}

    public void setDesconto(int desconto) {this.desconto = desconto;}
}
//peso”, “cepOrigem”, “cepDestino” e “nomeDestinatario“