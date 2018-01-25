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

/**
 *
 * @author jose
 */
public class DAOPedido implements Repository<Pedido> {

    private Conexao conn;
    private StringBuffer sql = null;
    PreparedStatement stat;

    public DAOPedido() {
        this.conn = new Conexao();
        this.sql = new StringBuffer();
    }

    @Override
    public int salvar(Pedido entity) {
        int resut = 0;
        try {
            sql.append("INSERT INTO pedido (codigo,data,codigoItem)"
                    + "VALUES (?,?,?)");
            return saveBD(entity, sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resut;
    }

    @Override
    public Pedido buscar(String atributo, Object valor) {
        sql.append("SELECT * FROM pedido WHERE ");
        sql.append(atributo);
        sql.append("=");
        sql.append(valor);
        sql.append("");
        Pedido resutado = null;
        try {
            resutado = queryBD(sql.toString()).get(0);
        } catch (URISyntaxException | ParseException | IOException | ClassNotFoundException | DataBaseException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resutado;
    }

    private int saveBD(Pedido entity, String query) throws SQLException {
        Connection conection = conn.init();
        int r;
        try {

            stat = conection.prepareStatement(query.toString());
            stat.setInt(1, entity.getCodigo());
            stat.setDate(2, Date.valueOf(entity.getData()));
            stat.setInt(3, entity.getItemPedidos());

            r = stat.executeUpdate();
        } finally {
            conn.fecharConexao(conection);
        }

        return r;
    }

    private int saveItens(List<ItemPedido> itemPedidos, String sql) throws SQLException {
        Connection conection = conn.init();
        int executeUpdate;
        try {

            stat = conection.prepareStatement(sql);
            int i = 0;
            while (!itemPedidos.isEmpty()) {
                stat.setInt(1, itemPedidos.get(i).getId());
                stat.setInt(3, itemPedidos.get(i).getQuantidade());
                stat.setInt(2, itemPedidos.get(i).getCodigoProduto());

                i++;
            }
            executeUpdate = stat.executeUpdate();
        } finally {
            conn.fecharConexao(conection);
        }

        return executeUpdate;
    }

    private List<Pedido> queryBD(String query) throws URISyntaxException, ParseException, IOException, ClassNotFoundException, DataBaseException, SQLException {

        List<Pedido> result = null;
        Connection connection = conn.init();
        try {
            //  System.err.println("try list");
            System.err.println("sql " + query);
            stat = connection.prepareStatement(query);
            ResultSet rs = stat.executeQuery();
            // System.err.println("passou conn");
            result = montarPedido(rs);

        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.fecharConexao(connection);
        }

        return result;
    }

    private List<Pedido> montarPedido(ResultSet rs) throws SQLException {
        List pedidos = new ArrayList();
        while (rs.next()) {
            pedidos.add(new Pedido(rs.getInt("codigo"),
                    rs.getDate("data").toLocalDate(), rs.getInt("codigoItem")));
        }
        if (!pedidos.isEmpty()) {
            return pedidos;
        }
        return Collections.EMPTY_LIST;
    }

}
