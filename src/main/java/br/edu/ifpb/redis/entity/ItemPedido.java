/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.entity;

/**
 *
 * @author jose
 */
public class ItemPedido {
  private int id;
  private int quantidade;
 private int codigoProduto;

    public ItemPedido() {
    }

    public ItemPedido(int id, int quantidade, int codigoProduto) {
        this.id = id;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
 
}
