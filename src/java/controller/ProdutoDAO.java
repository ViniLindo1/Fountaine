/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.IPadrao;
import model.Produto;
import java.sql.ResultSet;
import model.Banco;
/**
 *
 * @author vinic
 */
public class ProdutoDAO implements IPadrao<Produto> {

    @Override
    public int gravar(Produto obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void alterarEstoque(Banco bb, int codigo, int qtde) throws Exception {
        try{
            bb.comando = Banco.conexao.prepareStatement("Update produto set qtde=qtde-? where codigo=?");
            bb.comando.setInt(1, qtde);
            bb.comando.setInt(2, codigo);
            bb.comando.executeUpdate();
        }catch (Exception ex) {
            throw new Exception("Erro ao alterar estoque " + ex.getMessage());
        }
        
    }

    

    @Override
    public int remover(Produto obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public ResultSet listar(int coddep) throws Exception {
        Banco banco;
        try {
            banco= new Banco();
            banco.comando = Banco.conexao.prepareStatement("Select codigo,imagem,descricao,preco,qtde from produto where coddep=? order by descricao ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            banco.comando.setInt(1, coddep);
            banco.tabela = banco.comando.executeQuery();
            return (banco.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro de consultar " + ex.getMessage());
        }
    }

    @Override
    public ResultSet listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int alterar(Produto obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}