package mx.itson.domain;

import java.math.BigDecimal;

/**
 *
 * @author gabri
 */
public class Producto {

    private int productoId;
    private String nombreProducto;
    private BigDecimal precio;
    private String detalles;
    private BigDecimal iva;
    private Categoria categoria;

    
    public Producto(int productoId, String nombreProducto, BigDecimal precio, String detalles, Categoria categoria) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.detalles = detalles;
        this.categoria = categoria;
    }

    public Producto() {
    }
    
 /**
  *  @return precio total con iva
  */    
    public BigDecimal getPrecioConIVA(){
        BigDecimal precioConIVA = precio.multiply(BigDecimal.valueOf(1 + iva.doubleValue()));
        return precioConIVA.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * @return the productoId
     */
    public int getProductoId() {
        return productoId;
    }

    /**
     * @param productoId the productoId to set
     */
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the iva
     */
    public BigDecimal getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
