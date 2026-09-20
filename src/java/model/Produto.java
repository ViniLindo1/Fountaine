/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno
 */
public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int qtde;
    private String img;

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) throws Exception {
        if(preco>0)
            this.preco = preco;
        else
            throw new Exception("Preço inválido");
    }
    
    public void setPreco(String preco) throws Exception {
            this.setPreco(Double.parseDouble(preco));
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
    public void setQtde(int qtde) throws Exception {
        if(qtde>0)
            this.qtde = qtde;
        else
            throw new Exception("Quantidade inválida.");
    }
    
    public void setQtde(String qtde) throws Exception {
            this.setQtde(Integer.parseInt(qtde));
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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
    
    public double getTotal() {
        double q, p,t;

        p = this.getPreco();
        q = this.getQtde();
        t=p*q;
        return t ;
    }
    
    
} 

