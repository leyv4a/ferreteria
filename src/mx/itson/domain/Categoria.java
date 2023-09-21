
package mx.itson.domain;

/**
 *
 * @author gabriel
 */
public class Categoria {
    
    private int categoriaID;
    private String nombreCategoria;

    public Categoria( String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    
    
    /**
     * @return the categoriaID
     */
    public int getCategoriaID() {
        return categoriaID;
    }

    /**
     * @param categoriaID the categoriaID to set
     */
    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    /**
     * @return the nombreCategoria
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * @param nombreCategoria the nombreCategoria to set
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
}
