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

    public void generarCarrito(int clienteID) throws Exception {
        conectarDB();
//        CarritoDeCompras carrito = obtenerCarritoPorCliente(clienteID);
//        if (carrito != null) {
//            // El cliente ya tiene un carrito, lo retornamos
//         return carrito;
//        }else{
            //El cliene no tiene carrito, creamos uno
        try {
            String query1 = "INSERT INTO CarritoDeCompras (ClienteID) VALUES (?)";
            pst = conn.prepareStatement(query1, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, clienteID);
            pst.executeUpdate();

            //RECUPERAMOS EL ID DEL CARRITO
            resultado = pst.getGeneratedKeys();
            if (resultado.next()) {
                int CarritoID = resultado.getInt(1);
                CarritoDeCompras carrito = new CarritoDeCompras();
                carrito.setCarritoID(CarritoID);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
//          return carrito;
//        }
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
                // crear una instancia de CarritoDeCompras y asignar el carritoID
                carrito = new CarritoDeCompras();
                carrito.setCarritoID(carritoID);
            }
        } finally {
            desconectarDB();
        }
        return carrito;
    }
}
