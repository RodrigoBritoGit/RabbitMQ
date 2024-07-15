package com.microservice.EstoquePreco.dto;

import java.io.Serializable;

public class EstoqueDto implements Serializable {
    public String codigoProduto;
    public String quantidade;

    public String getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
