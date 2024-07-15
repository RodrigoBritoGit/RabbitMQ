package com.microservice.EstoquePreco.dto;

import java.io.Serializable;


public class PrecoDto implements Serializable {
    public String codigoProduto;
    public String preco;

    public String getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }
}
