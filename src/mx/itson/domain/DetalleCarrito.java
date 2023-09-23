package mx.itson.domain;

import java.math.BigDecimal;

/**
 *
 * @author gabri
 */
public class DetalleCarrito {

    private int detalleID;
    private int carritoid;
    private int productoid;
    private int cantidad;

    //VALORES PARA DETALLAR EL CARRITO
    private String nombreProducto;
    private BigDecimal precio;

//    private BigDecimal precioTotal;
    public DetalleCarrito(int carritoid, int productoid, int cantidad, String nombreProducto, BigDecimal precio) {
        this.carritoid = carritoid;
        this.productoid = productoid;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.precio = precio;

    }

    public DetalleCarrito(int carritoid, int productoid, int cantidad) {
//        this.detalleID = detalleID;
        this.carritoid = carritoid;
        this.productoid = productoid;
        this.cantidad = cantidad;

    }

    public DetalleCarrito() {
    }

    public DetalleCarrito(int detalleid) {
        this.detalleID = detalleid;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getCarritoid() {
        return carritoid;
    }

    public void setCarritoid(int carritoid) {
        this.carritoid = carritoid;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    /**
     * @return the detalleID
     */
    public int getDetalleID() {
        return detalleID;
    }

    /**
     * @param detalleID the detalleID to set
     */
    public void setDetalleID(int detalleID) {
        this.detalleID = detalleID;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
