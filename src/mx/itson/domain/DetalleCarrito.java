
package mx.itson.domain;

/**
 *
 * @author gabri
 */
public class DetalleCarrito {
    
    private int detalleID;
    private CarritoDeCompras carrito;
    private Producto producto;
    private int cantidad;

    public DetalleCarrito(int detalleID, CarritoDeCompras carrito, Producto producto, int cantidad) {
        this.detalleID = detalleID;
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleCarrito() {
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
     * @return the carrito
     */
    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    /**
     * @param carrito the carrito to set
     */
    public void setCarrito(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
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
