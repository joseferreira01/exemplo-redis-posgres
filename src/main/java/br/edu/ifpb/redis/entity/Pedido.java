/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.entity;

import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jose
 */
public class Pedido {

    private int codigo;
    private LocalDate data;
    private int itemPedidos;

    public Pedido() {
    }

    public Pedido(int codigo, LocalDate data, int itemPedidos) {
        this.codigo = codigo;
        this.data = data;
        this.itemPedidos = itemPedidos;
    }
    public Pedido( LocalDate data, int itemPedidos) {
        this.data = data;
        this.itemPedidos = itemPedidos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(int itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Produto convertGsonToPedido(String uGson) {
        Gson gson = new Gson();
        return gson.fromJson(uGson, Produto.class);
    }

    public String convertpedidoToGson() {

        Gson gson = new Gson();

        // converte objetos Java para JSON e retorna JSON como String
        String json = gson.toJson(this);
        return json;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", data=" + data + ", itemPedidos=" + itemPedidos + '}';
    }
    
}
