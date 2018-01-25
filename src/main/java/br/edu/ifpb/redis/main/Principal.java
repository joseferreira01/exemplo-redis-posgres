/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.main;

import br.edu.ifpb.redis.dao.DAOPedido;
import br.edu.ifpb.redis.dao.DAOPedidoRedis;
import br.edu.ifpb.redis.entity.Pedido;
import java.time.LocalDate;

/**
 *
 * @author jose
 */
public class Principal {

    private static DAOPedidoRedis DAOedis = new DAOPedidoRedis();

    private static DAOPedido dAOPedido = new DAOPedido();

    public static void main(String[] args) {
        Pedido pedido = new Pedido(7,LocalDate.now(), 2);
        //  salvarPedido(pedido);
        // System.err.println("BUSCAR " + buscarPedidos());
        //System.err.println("BUSCAR " + buscarPedidos(2));
       // salvarPedido(pedido);
        //System.err.println("redis " +DAOedis.buscar("5"));
       //  salvarPedido(pedido);
          System.err.println("redis " +DAOedis.buscar("7"));
    }

    private static void salvarPedido(Pedido pedido) {
        if (dAOPedido.salvar(pedido) == 1) {
            System.err.println("pedido salvo" + DAOedis.salvar(pedido));
        }
    }

    private static Pedido buscarPedidos(int id) {
        Pedido resultado = DAOedis.buscar(String.valueOf(id));
        if (resultado == null) {
            System.err.println("d if");
            return dAOPedido.buscar("codigo", id);
            
        } else {
             System.err.println("s ig");
            return resultado;
           
        }
    }

}
