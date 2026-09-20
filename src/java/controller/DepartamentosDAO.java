/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Banco;
import model.Departamento;
import model.IPadrao;

/**
 *
 * @author aluno
 */
public class DepartamentosDAO implements IPadrao<Departamento>{

    @Override
    public int gravar(Departamento obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int alterar(Departamento obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int remover(Departamento obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet listar() throws Exception {
        Banco banco;
        try {
            banco= new Banco();
            banco.comando = Banco.conexao.prepareStatement("Select codigo,nome from departamento order by nome ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            banco.tabela = banco.comando.executeQuery();
            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro de consultar " + ex.getMessage());
        }
        
    }

}
