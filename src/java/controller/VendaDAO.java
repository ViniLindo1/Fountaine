/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Banco;
import model.IPadrao;
import model.Venda;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author vinic
 */
public class VendaDAO implements IPadrao<Venda> {

    public void gravar(Banco bb, Venda obj) throws Exception {
        int codigo = -1;
        try {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Insert into venda( total, codcli) values (?,?);", Statement.RETURN_GENERATED_KEYS);
            bb.comando.setDouble(1, obj.getTotal());
            bb.comando.setInt(2, obj.getCodcli());
            bb.comando.executeUpdate();

            bb.tabela = bb.comando.getGeneratedKeys();

            if (bb.tabela.next()) {
                codigo = bb.tabela.getInt(1);
                obj.setCodigo(codigo);
            }
        } catch (Exception ex) {
            throw new Exception("Erro ao incluir venda: " + ex.getMessage());
        }
    }

    @Override
    public int alterar(Venda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int remover(Venda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int gravar(Venda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
