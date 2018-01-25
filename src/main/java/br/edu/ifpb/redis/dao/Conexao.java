/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Conexao implements ConectionJDBC {
      private static Properties prop = null;

    private Connection connection;

    @Override
    public Connection init() {
        try {
            
//              prop = new Properties();
//                    prop.load(new FileInputStream(getClass().getResource("/bd/connection.properties").toURI().getPath()));
//       
//            String url = prop.getProperty("url");
//            String user = prop.getProperty("user");
//            String password = prop.getProperty("password");
            Class.forName("org.postgresql.Driver");
            return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/redis", "postgres", "12345");
        } catch (Exception e) {
        }
                   
      
        return null;
    }
    @Override
    public   void fecharConexao(Connection c) throws SQLException{
        c.close();
    }

}
