/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;
import java.sql.ResultSet;

/**
 *
 * @author prampero
 * @param <T>
 */
//Uma interface é um tipo de contrato que define um conjunto de métodos (e, opcionalmente, constantes) 
//que uma classe deve implementar
public interface IPadrao<T> {
//obriga a classe que implementa ter essas funções.
    public int gravar(T obj) throws Exception; 
    public int alterar(T obj) throws Exception;
    public int remover(T obj) throws Exception;  
    public ResultSet listar() throws Exception; 
    
}
