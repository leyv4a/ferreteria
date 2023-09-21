/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.persistence;

import com.mysql.jdbc.PreparedStatement;
import mx.itson.domain.CarritoDeCompras;

/**
 *
 * @author gabri
 */
public class CarritoDAO extends DAO {
    
    public void generarCarrito(int clienteID) throws Exception{
        conectarDB();
        try {
            String query ="INSERT INTO CarritoDeCompras (ClienteID) VALUES (?)";
            pst= conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, clienteID);
            pst.executeUpdate();
            
            //RECUPERAMOS EL ID DEL CARRITO
            resultado= pst.getGeneratedKeys();
            if (resultado.next()) {
                int CarritoID = resultado.getInt(1);
                CarritoDeCompras carrito = new CarritoDeCompras();
                carrito.setCarritoID(CarritoID);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarDB();
        }
    }
    
    public CarritoDeCompras obtenerCarritoPorCliente(int clienteID) throws Exception {
        CarritoDeCompras carrito = null;
        conectarDB();
        try {
            String query = "SELECT carritoID FROM CarritoDeCompras WHERE clienteID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, clienteID);
            resultado = pst.executeQuery();
            if (resultado.next()) {
                int carritoID = resultado.getInt("carritoID");
                // Puedes crear una instancia de CarritoDeCompras y asignar el carritoID
                carrito = new CarritoDeCompras();
                carrito.setCarritoID(carritoID);
            }
        } finally {
            desconectarDB();
        }
        return carrito;
    }
}
