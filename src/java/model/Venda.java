/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vinic
 */
public class Venda {
    private int codigo;
    private int codcli;
    private double total; 

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
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    public void setTotal(String total) throws Exception {
            this.setTotal(Double.parseDouble(total));
    }

    /**
     * @return the codcli
     */
    public int getCodcli() {
        return codcli;
    }

    /**
     * @param codcli the codcli to set
     */
    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }
}
