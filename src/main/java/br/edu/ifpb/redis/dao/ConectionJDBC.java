/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public interface Conection {

    void fecharConexao(Connection c) throws SQLException;

    Connection init();
    
}
