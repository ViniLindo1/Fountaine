package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.ResultSet;
import model.Banco;
import model.Cliente;
import model.IPadrao;

/**
 *
 * @author prampero
 */
public class ClienteDAO implements IPadrao<Cliente>{

    @Override
    public int gravar(Cliente obj) throws Exception {
        Banco bb;
        int qtde=0;
        try {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Insert into cliente(codigo, nome, login, senha, cidade, bairro, rua, numero) values (?,?,?,md5(?),?,?,?,?)");
            bb.comando.setInt(1, obj.getCodigo());
            bb.comando.setString(2, obj.getNome());
            bb.comando.setString(3, obj.getUser());
            bb.comando.setString(4, obj.getSenha());
            bb.comando.setString(5, obj.getCidade());
            bb.comando.setString(6, obj.getBairro());
            bb.comando.setString(7, obj.getRua());
            bb.comando.setInt(8, obj.getNumero());

            qtde = bb.comando.executeUpdate();
            Banco.conexao.close();
            return (qtde);
        } catch (Exception ex) {
            throw new Exception("Erro ao incluir cliente no banco: " + ex.getMessage());
        }
        
        
    }

    @Override
    public int alterar(Cliente obj) throws Exception {
        Banco bb;
        int qtde=0;
        try {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Update cliente set nome=?, login=?, senha=md5(?), cidade=?, bairro=?, rua=?, numero=? where codigo=?");
            bb.comando.setString(1, obj.getNome());
            bb.comando.setString(2, obj.getUser());
            bb.comando.setString(3, obj.getSenha());
            bb.comando.setString(4, obj.getCidade());
            bb.comando.setString(5, obj.getBairro());
            bb.comando.setString(6, obj.getRua());
            bb.comando.setInt(7, obj.getNumero());
            bb.comando.setInt(8, obj.getCodigo());
            qtde= bb.comando.executeUpdate();
            Banco.conexao.close();
            return(qtde);
        } catch (Exception ex) {
            throw new Exception("Erro ao alterar nome de usuário: " + ex.getMessage());
        }
    }

    @Override
    public int remover(Cliente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    public boolean login(Cliente obj) throws Exception {
        Banco banco;

        try {
            banco = new Banco();

            banco.comando = Banco.conexao.prepareStatement("Select login, senha from cliente where login=? AND senha=md5(?)");
            banco.comando.setString(1, obj.getUser());
            banco.comando.setString(2, obj.getSenha());

            ResultSet resultado = banco.comando.executeQuery();

            boolean valido = resultado.next();

            Banco.conexao.close();

            return valido;

        } catch (Exception ex) {
            throw new Exception("Erro ao autenticar: " + ex.getMessage());
        }
    }
    
    public Cliente preencher(int codigo) throws Exception{
        Banco banco;
        Cliente obj=null;
        try{
            banco= new Banco();
            banco.comando = Banco.conexao.prepareStatement("Select codigo,nome, login, senha, cidade, bairro, rua, numero from cliente where codigo=?");
            banco.comando.setInt(1, codigo);
            banco.tabela=banco.comando.executeQuery();
            if(banco.tabela.next()){
                obj =new Cliente();
                obj.setCodigo(banco.tabela.getInt(1));
                obj.setNome(banco.tabela.getString(2));
                obj.setUser(banco.tabela.getString(3));
                obj.setSenha(banco.tabela.getString(4));
                obj.setCidade(banco.tabela.getString(5));
                obj.setBairro(banco.tabela.getString(6));
                obj.setRua(banco.tabela.getString(7));
                obj.setNumero(banco.tabela.getInt(8));
            }
            Banco.conexao.close();
            return(obj);
        }
        catch(Exception ex){
            throw new Exception("Erro ao preencher/ClienteDAO = "+ ex.getMessage());
        }
    }

}
   

    
