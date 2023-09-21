/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.services;

import java.math.BigDecimal;
import java.util.List;
import mx.itson.domain.Producto;
import mx.itson.persistence.ProductoDAO;

/**
 *
 * @author gabri
 */
public class ProductoService {

    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    /**
     *
     * @param producto
     * @throws Exception
     */
    public void crearProducto(Producto producto) throws Exception {
        try {
            // Valimos los datos
            if (producto.getNombreProducto() == null || producto.getNombreProducto().trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre para el producto");
            }
            if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
                throw new Exception("El precio del producto debe ser mayor que cero");
            }
            if (producto.getDetalles() == null || producto.getDetalles().trim().isEmpty()) {
                throw new Exception("Debe proporcionar detalles para el producto");
            }
            if (producto.getCategoria() == null || producto.getCategoria().getCategoriaID() <= 0) {
                throw new Exception("Debe seleccionar una categoría válida para el producto");
            }

            // Crear el producto
            dao.crearProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @return lista de productos
     * @throws Exception
     */
    public List<Producto> listarProductos() throws Exception {
        return dao.listarProductos();
    }

    /**
     * Metodo para modificar un producto
     *
     * @param producto
     * @throws Exception
     */
    public void modificarProducto(Producto producto) throws Exception {
        try {
            // Validaciones
            if (producto.getProductoId() <= 0) {
                throw new Exception("ID de producto no válido");
            }
            if (producto.getNombreProducto() == null || producto.getNombreProducto().trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre para el producto");
            }
            if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
                throw new Exception("El precio del producto debe ser mayor que cero");
            }
            if (producto.getDetalles() == null || producto.getDetalles().trim().isEmpty()) {
                throw new Exception("Debe proporcionar detalles para el producto");
            }
            if (producto.getIva() == null || producto.getIva().compareTo(BigDecimal.ZERO) < 0 || producto.getIva().compareTo(BigDecimal.ONE) >= 0) {
                throw new Exception("El valor del IVA debe estar entre 0 y 1");
            }
            if (producto.getCategoria() == null || producto.getCategoria().getCategoriaID() <= 0) {
                throw new Exception("Debe seleccionar una categoría válida para el producto");
            }

            // Actualizar el producto
            dao.modificarProducto(producto);
        } catch (Exception e) {
        }
    }

    /**
     * Metodo para eliminar un producto
     * @param productoId
     * @throws Exception 
     */
    public void eliminarProducto(int productoId) throws Exception {
        try {
            // Validación: Verificar si el producto existe antes de eliminarlo
            Producto productoExistente = dao.obtenerProductoPorID(productoId);
            if (productoExistente == null) {
                throw new Exception("El producto con ID " + productoId + " no existe en la base de datos.");
            }

            // Si el producto existe, procedemos a eliminarlo
            dao.eliminarProducto(productoId);
        } catch (Exception e) {
            throw e;
        }
    }
}
