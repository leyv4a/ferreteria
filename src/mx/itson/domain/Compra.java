
package mx.itson.domain;

import java.time.LocalDateTime;

/**
 *
 * @author gabri
 */
public class Compra {
    
    private int compraID;
    private LocalDateTime fechaCompra;
    private String estado;
    private Cliente cliente;

    public Compra(int compraID, LocalDateTime fechaCompra, String estado, Cliente cliente) {
        this.compraID = compraID;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Compra() {
    }

    /**
     * @return the compraID
     */
    public int getCompraID() {
        return compraID;
    }

    /**
     * @param compraID the compraID to set
     */
    public void setCompraID(int compraID) {
        this.compraID = compraID;
    }

    /**
     * @return the fechaCompra
     */
    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
