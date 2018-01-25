/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.main;

import br.edu.ifpb.redis.dao.DAOPedido;
import br.edu.ifpb.redis.entity.Pedido;
import java.time.LocalDate;

/**
 *
 * @author jose
 */
public class Principal {

    private static DAOPedido dAOPedido = new DAOPedido();

    public static void main(String[] args) {
        Pedido pedido = new Pedido(LocalDate.now(), 2);
      //  salvarPedido(pedido);
        System.err.println("BUSCAR " + buscarPedidos());
    }

    private static void salvarPedido(Pedido pedido) {
        System.err.println("pedido salvo" + dAOPedido.salvar(pedido));
    }

    private static Pedido buscarPedidos() {
        return dAOPedido.buscar("codigo", 2);
    }

}
