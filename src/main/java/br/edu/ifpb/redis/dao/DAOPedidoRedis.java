/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.dao;

import br.edu.ifpb.redis.entity.ItemPedido;
import br.edu.ifpb.redis.entity.Pedido;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import redis.clients.jedis.Jedis;

/**
 *
 * @author jose
 */
public class DAOPedidoRedis  {

    private ConectionRedis conn;
    private Jedis redis;

    public DAOPedidoRedis() {
        conn = new ConectionRedis();
    }
     
   

    
    public String salvar(Pedido entity) {
       
         redis = conn.init();
       
        String set;
        set = redis.setex(String.valueOf(entity.getCodigo()), 45,
                entity.convertpedidoToGson());
        return set;
    }

    
    public Pedido buscar(String  valor) {
       redis = conn.init();
        
        Pedido resul = Pedido.convertGsonToPedido( redis.get(valor));
        fechar();
         return resul;
    }
    private void fechar(){
        redis.close();
    }


}
