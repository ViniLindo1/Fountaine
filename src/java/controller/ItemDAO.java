/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Banco;
import model.IPadrao;
import model.Item;
import java.sql.Statement;

/**
 *
 * @author vinic
 */
public class ItemDAO implements IPadrao<Item> {
    
    public void gravar(Banco bb, Item obj) throws Exception {
        int codigo = -1;
        try {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("INSERT INTO item(qtde, precounit, codproduto, codvenda) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            bb.comando.setInt(1, obj.getQtde());
            bb.comando.setDouble(2, obj.getPrecounit());
            bb.comando.setInt(3, obj.getCodproduto());
            bb.comando.setInt(4, obj.getCodvenda());
            
            bb.comando.executeUpdate();

            bb.tabela = bb.comando.getGeneratedKeys();

            if(bb.tabela.next()){
                obj.setCodigo(bb.tabela.getInt(1));
            }
        } catch (Exception ex) {
            throw new Exception("Erro ao incluir venda: " + ex.getMessage());
        }
    }

    

    @Override
    public int alterar(Item obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int remover(Item obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int gravar(Item obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
