/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.persistence;

import java.util.ArrayList;
import java.util.List;
import mx.itson.domain.Categoria;

/**
 *
 * @author gabri
 */
public class CategoriaDAO extends DAO{
    /**
     * 
     * @return Lista de categorias
     * @throws Exception 
     */
    public List<Categoria> obtenerTodasCategorias() throws Exception{
        List<Categoria> categorias = new ArrayList<>();
        try {
            conectarDB();
            String query ="SELECT * FROM Categoria";
            resultado = stm.executeQuery(query);
            while (resultado.next()) {                
                int categoriaID = resultado.getInt("categoriaID");
                String nombreCategoria = resultado.getString("nombreCategoria");
                Categoria categoria = new Categoria();
                categorias.add(categoria);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
        return categorias;
    }
/**
 * 
 * @param categoriaId
 * @return categoria filtrada por id
 * @throws Exception 
 */
    public Categoria obtenerCategoriaPorId(int categoriaId) throws Exception{
        Categoria categoria = null;
        try {
            conectarDB();
            String query = "SELECT * FROM Categorias WHERE categoriaID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, categoriaId);
            resultado = pst.executeQuery();
            if (resultado.next()) {
                String nombreCategoria = resultado.getString("nombreCategoria");
                categoria = new Categoria("nombreCategoria");
                        }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
        return categoria;
    }
/**
 *  Metodo para crear una categoria
 * @param categoria
 * @throws Exception 
 */
    public void crearCategoria(Categoria categoria) throws Exception{
        try {
            conectarDB();
            String query = "INSERT INTO Categoria(nombreCategoria) VALUES(?) ";
            pst = conn.prepareStatement(query);
            pst.setString(1,categoria.getNombreCategoria());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
    }
 /**
  * Metodo para eliminar una categoria
  * @param nombreCategoria
  * @throws Exception 
  */
    public void eliminarCategoria(String nombreCategoria) throws Exception{
        try {
            conectarDB();
            String query = "DELETE FROM Categoria WHERE nombreCategoria = '?'";
            pst = conn.prepareStatement(query);
            pst.setString(1, nombreCategoria);
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
    }
    /**
     *  Metodo para editar una categoria
     * @param categoria
     * @throws Exception 
     */
    public void editarCategoria(Categoria categoria) throws Exception{
        try {
            conectarDB();
            String query = "UPDATE Categoria SET nombreCategoria = ? WHERE categoriaID = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, categoria.getNombreCategoria());
            pst.setInt(2, categoria.getCategoriaID());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
    }
}
