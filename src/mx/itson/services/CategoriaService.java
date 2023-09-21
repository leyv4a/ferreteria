/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.services;

import java.util.List;
import mx.itson.domain.Categoria;
import mx.itson.persistence.CategoriaDAO;

/**
 *
 * @author gabri
 */
public class CategoriaService {
    
    CategoriaDAO dao;
    
    public CategoriaService(){
        this.dao = new CategoriaDAO();   
}
    
    // Método para obtener todas las categorías
    public List<Categoria> obtenerTodasCategorias() throws Exception {
        try {
            return dao.obtenerTodasCategorias();
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una categoría por su ID
    public Categoria obtenerCategoriaPorID(int categoriaID) throws Exception {
        try {
            return dao.obtenerCategoriaPorId(categoriaID);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para crear una nueva categoría
    public void crearCategoria(Categoria categoria) throws Exception {
        try {
            dao.crearCategoria(categoria);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para editar una categoría existente
    public void editarCategoria(Categoria categoria) throws Exception {
        try {
            dao.editarCategoria(categoria);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una categoría por su ID
    public void eliminarCategoria(String nombreCategoria) throws Exception {
        try {
            dao.eliminarCategoria(nombreCategoria);
        } catch (Exception e) {
            throw e;
        }
    }

}
