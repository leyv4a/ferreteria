/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.domain;

/**
 *
 * @author gabri
 */
public class CarritoDeCompras {
    
    private int carritoID;
    private Cliente cliente;

    public CarritoDeCompras(int carritoID, Cliente cliente) {
        this.carritoID = carritoID;
        this.cliente = cliente;
    }

    public CarritoDeCompras() {
    }

    /**
     * @return the carritoID
     */
    public int getCarritoID() {
        return carritoID;
    }

    /**
     * @param carritoID the carritoID to set
     */
    public void setCarritoID(int carritoID) {
        this.carritoID = carritoID;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
