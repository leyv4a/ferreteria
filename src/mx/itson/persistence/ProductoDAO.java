/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.persistence;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.domain.Categoria;
import mx.itson.domain.Producto;
import mx.itson.services.CategoriaService;

/**
 *
 * @author gabri
 */
public class ProductoDAO extends DAO {

    /**
     * Creamos un metodo para crear un producto
     *
     * @param producto
     * @throws Exception
     */
    public void crearProducto(Producto producto) throws Exception {
        conectarDB();
        try {
              
            String query = "INSERT INTO Producto (nombreProducto, precio, detalles, categoriaID) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, producto.getNombreProducto());
            pst.setBigDecimal(2, producto.getPrecio());
            pst.setString(3, producto.getDetalles());
            pst.setInt(4, producto.getCategoria().getCategoriaID());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }

    /**
     * Metodo para listar productos
     *
     * @return lista de productos
     * @throws Exception
     */
    public List<Producto> listarProductos() throws Exception {
        List<Producto> productos = new ArrayList<>();
        conectarDB();
        try {
            
            String query = "SELECT p.productoID, p.nombreProducto, p.precio, p.detalles, p.iva, c.categoriaID, c.nombreCategoria FROM Producto p"
                    + " INNER JOIN Categoria c ON p.categoriaID = c.categoriaID";
            pst = conn.prepareStatement(query);
            resultado = pst.executeQuery();
            //hacer metodo para que lo muestre en una tabla
            while (resultado.next()) {
                int productoID = resultado.getInt("productoID");
                String nombreProducto = resultado.getString("nombreProducto");
                BigDecimal precio = resultado.getBigDecimal("precio");
                String detalles = resultado.getString("detalles");
             
                int categoriaID = resultado.getInt("categoriaID");
                String nombreCategoria = resultado.getString("nombreCategoria");
                Categoria categoria = new Categoria(nombreCategoria);

                Producto producto = new Producto(productoID, nombreProducto, precio, detalles, categoria);
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
        return productos;
    }

    /**
     * 
     * @param productoID
     * @return el producto por su id
     * @throws Exception 
     */
    public Producto obtenerProductoPorID(int productoID) throws Exception {
        Producto producto = null;
        conectarDB();
        try {
            String sql = "SELECT productoID, nombreProducto, precio, detalles, iva, categoriaID " +
                    "FROM Producto " +
                    "WHERE productoID = ?";
           pst = conn.prepareStatement(sql);
            pst.setInt(1, productoID);
            resultado= pst.executeQuery();
            if (resultado.next()) {
                int id = resultado.getInt("productoID");
                String nombreProducto = resultado.getString("nombreProducto");
                BigDecimal precio = resultado.getBigDecimal("precio");
                String detalles = resultado.getString("detalles");
                BigDecimal iva = resultado.getBigDecimal("iva");
                int categoriaID = resultado.getInt("categoriaID");

                //Hacer motodo para obtener categoria por id
                CategoriaService CategoriaS = new CategoriaService();
                Categoria categoria = CategoriaS.obtenerCategoriaPorID(categoriaID);
                producto = new Producto(id, nombreProducto, precio, detalles, categoria);
            }
        } finally {
            desconectarDB();
        }
        return producto;
    }
    /**
     * Metodo para modificar un producto
     * @param producto
     * @throws Exception 
     */
    public void modificarProducto(Producto producto) throws Exception {
        conectarDB();
        try {
            if (producto != null) {
                throw new Exception("Debe indicar un producto");
            }
            String query = "UPDATE producto SET nombreProducto = ?, precio = ?, detalles = ?, iva = ?, categoriaID = ?"
                    + "WHERE productoID = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, producto.getNombreProducto());
            pst.setBigDecimal(2, producto.getPrecio());
            pst.setString(3, producto.getDetalles());
            pst.setBigDecimal(4, producto.getIva());
            pst.setInt(5, producto.getCategoria().getCategoriaID());
            pst.setInt(6, producto.getProductoId());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
    }
   /**
    * Metodo para borrar un producto de la base de datos
    * @param productoID
    * @throws Exception 
    */
    public void eliminarProducto(int productoID) throws Exception{
        conectarDB();
        try {
            String query="DELETE FROM Producto Where productoID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, productoID);
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
    }
    
}
