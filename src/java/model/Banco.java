/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

/**
 *
 * @author vinic
 */
public class Banco {
    
    public static Connection conexao = null;
    public PreparedStatement comando = null;
    public ResultSet tabela = null;
    
    public Banco() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Loja", "postgres", "20091616Vini");
            }
        } catch (Exception ex) {
            throw new Exception("Erro de conexao:" + ex.getMessage());
        }

    }

    
    
}
