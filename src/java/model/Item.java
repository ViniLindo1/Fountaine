/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vinic
 */
public class Item {
    private int codigo;
    private int codproduto;
    private int codvenda;
    private int qtde;
    private double precounit;   

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo) throws Exception {
            this.setCodigo(Integer.parseInt(codigo));
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    public void setQtde(String qtde) throws Exception {
            this.setQtde(Integer.parseInt(qtde));
    }

    /**
     * @return the precounit
     */
    public double getPrecounit() {
        return precounit;
    }

    /**
     * @param precounit the precounit to set
     */
    public void setPrecounit(double precounit) {
        this.precounit = precounit;
    }
    
    public void setPrecounit(String precounit) throws Exception {
            this.setPrecounit(Double.parseDouble(precounit));
    }

    /**
     * @return the codproduto
     */
    public int getCodproduto() {
        return codproduto;
    }

    /**
     * @param codproduto the codproduto to set
     */
    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    /**
     * @return the codvenda
     */
    public int getCodvenda() {
        return codvenda;
    }

    /**
     * @param codvenda the codvenda to set
     */
    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }
}
