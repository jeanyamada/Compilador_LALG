/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisesemantica;

/**
 *
 * @author jean
 */
public class Atributos {
    private String tipo;
    private boolean utilizada;

    public Atributos() {
        utilizada = false;
    }

    public Atributos(String tipo,boolean utilizada) {
        this.tipo = tipo;
        this.utilizada = utilizada;
    }
    
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the utilizada
     */
    public boolean isUtilizada() {
        return utilizada;
    }

    /**
     * @param utilizada the utilizada to set
     */
    public void setUtilizada(boolean utilizada) {
        this.utilizada = utilizada;
    }
    
}
