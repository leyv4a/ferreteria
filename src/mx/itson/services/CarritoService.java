/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.services;

import mx.itson.domain.CarritoDeCompras;
import mx.itson.persistence.CarritoDAO;

/**
 *
 * @author gabri
 */
public class CarritoService {
    
    private CarritoDAO dao;
    
    public CarritoService(){
        this.dao = new CarritoDAO();
    }
    
     public void crearCarritoDeCompras(int clienteID) throws Exception {
        dao.generarCarrito(clienteID);
    }

    public CarritoDeCompras obtenerCarritoPorCliente(int clienteID) throws Exception {
        return dao.obtenerCarritoPorCliente(clienteID);
    }
}
