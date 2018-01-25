/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.dao;

import redis.clients.jedis.Jedis;

/**
 *
 * @author jose
 */
public class ConectionRedis {
    public Jedis init(){
        return  new Jedis("localhost");
    }
}
