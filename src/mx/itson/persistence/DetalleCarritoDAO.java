/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mx.itson.domain.CarritoDeCompras;
import mx.itson.domain.Categoria;
import mx.itson.domain.DetalleCarrito;
import mx.itson.domain.Producto;

/**
 *
 * @author gabri
 */
public class DetalleCarritoDAO extends DAO{
    
   public void agregarDetalleCarrito(DetalleCarrito detalle) throws Exception {
        conectarDB();
        try {
            String query = "INSERT INTO DetalleCarrito (carritoID, productoID, cantidad) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(query);
            pst.setInt(1, detalle.getCarrito().getCarritoID());
            pst.setInt(2, detalle.getProducto().getProductoId());
            pst.setInt(3, detalle.getCantidad());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }
   
      public List<DetalleCarrito> listarDetallesPorCarrito(CarritoDeCompras carrito) throws Exception {
        List<DetalleCarrito> detalles = new ArrayList<>();
        conectarDB();
        try {
            String query = "SELECT dc.detalleID, dc.cantidad, p.productoID, p.nombreProducto, p.precio, p.detalles, c.categoriaID, c.nombreCategoria FROM DetalleCarrito dc "
                    + "INNER JOIN Producto p ON dc.productoID = p.productoID "
                    + "INNER JOIN Categoria c ON p.categoriaID = c.categoriaID " // Agregamos la tabla Categoria
                    + "WHERE dc.carritoID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, carrito.getCarritoID());
            resultado = pst.executeQuery();
            while (resultado.next()) {
                int detalleID = resultado.getInt("detalleID");
                int cantidad = resultado.getInt("cantidad");
                int productoID = resultado.getInt("productoID");
                String nombreProducto = resultado.getString("nombreProducto");
                BigDecimal precio = resultado.getBigDecimal("precio");
                String detallesProducto = resultado.getString("detalles");
                int categoriaID = resultado.getInt("categoriaID");
                String nombreCategoria = resultado.getString("nombreCategoria");
                Categoria categoria = new Categoria(nombreCategoria); // Creamos el objeto Categoria
                Producto producto = new Producto(productoID, nombreProducto, precio, detallesProducto, categoria); // Usamos la categoría en lugar del IVA
                DetalleCarrito detalle = new DetalleCarrito(detalleID, carrito, producto, cantidad);
                detalles.add(detalle);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
        return detalles;
    }
      
      
      public void eliminarDetalleCarrito(int detalleID) throws Exception {
        conectarDB();
        try {
            String query = "DELETE FROM DetalleCarrito WHERE detalleID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, detalleID);
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }
}
