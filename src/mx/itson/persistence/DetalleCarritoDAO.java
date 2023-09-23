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
            pst.setInt(1, detalle.getCarritoid());
            pst.setInt(2, detalle.getProductoid());
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
//                DetalleCarrito detalle = new DetalleCarrito(carrito.getCarritoID(), producto.getProductoId(), cantidad);
                DetalleCarrito detalle = new DetalleCarrito(carrito.getCarritoID(), producto.getProductoId(), cantidad, producto.getNombreProducto(), producto.getPrecio());
                detalles.add(detalle);
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
        return detalles;
    }
      
      
      public List<DetalleCarrito> listarDetallesPorCarritoId(int carritoid) throws Exception {
        List<DetalleCarrito> detalles = new ArrayList<>();
        conectarDB();
        try {
            String query = "SELECT dc.detalleID, dc.cantidad, p.productoID, p.nombreProducto, p.precio, p.detalles, c.categoriaID, c.nombreCategoria FROM DetalleCarrito dc "
                    + "INNER JOIN Producto p ON dc.productoID = p.productoID "
                    + "INNER JOIN Categoria c ON p.categoriaID = c.categoriaID " 
                    + "WHERE dc.carritoId = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, carritoid);
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
//                DetalleCarrito detalle = new DetalleCarrito(carrito.getCarritoID(), producto.getProductoId(), cantidad);
                DetalleCarrito detalle2= new DetalleCarrito(detalleID);
                DetalleCarrito detalle = new DetalleCarrito(carritoid, producto.getProductoId(), cantidad, producto.getNombreProducto(), producto.getPrecio());
                detalles.add(detalle);
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
        return detalles;
    }
      
      public void eliminarDetalleCarrito(int carritoid) throws Exception {
        conectarDB();
        try {
            String query = "DELETE FROM DetalleCarrito WHERE carritoId = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, carritoid);
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }
      
      public void eliminarDetalleCarritoPorId(int detalleid, int carritoid, int cantidad) throws Exception {
        conectarDB();
        try {
            String query = "DELETE FROM DetalleCarrito WHERE detalleID = ? and carritoid = ? and cantidad = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, detalleid);
            pst.setInt(2, carritoid);
            pst.setInt(3, cantidad);
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }
}
