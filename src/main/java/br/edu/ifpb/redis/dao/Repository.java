/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.redis.dao;

import java.util.List;

/**
 *
 * @author jose
 */
public interface Repository<T> {

    int salvar(T entity);

//    void atualizar(T entity);
//
//    void deletar(int chavePrimaria);
///**
// * 
// * @param atributo  Nome do atributo referente a busca 
// * @param valor valor do atributo referenciado
// * @return Retorna um objeto cuje o atributo for encontrado
// */
    T buscar(String atributo, Object valor);
//
//    List<T> buscarTodos();

}
