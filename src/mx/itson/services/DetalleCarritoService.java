/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.services;

import java.util.List;
import mx.itson.domain.CarritoDeCompras;
import mx.itson.domain.DetalleCarrito;
import mx.itson.persistence.DetalleCarritoDAO;

/**
 *
 * @author gabri
 */
public class DetalleCarritoService {
     private DetalleCarritoDAO dao;

    public DetalleCarritoService() {
        this.dao = new DetalleCarritoDAO();
    }

    public void agregarDetalleCarrito(DetalleCarrito detalle) throws Exception {
        dao.agregarDetalleCarrito(detalle);
    }

    public List<DetalleCarrito> listarDetallesPorCarrito(CarritoDeCompras carrito) throws Exception {
        return dao.listarDetallesPorCarrito(carrito);
    }
     public List<DetalleCarrito> listarDetallesPorCarritoId(int carritoid) throws Exception {
        return dao.listarDetallesPorCarritoId(carritoid);
    }

    public void eliminarDetalleCarrito(int detalleID) throws Exception {
        dao.eliminarDetalleCarrito(detalleID);
    }
    
    public void eliminarDetalleCarritoPorId(int detalleid, int carritoid, int cantidad) throws Exception {
        dao.eliminarDetalleCarritoPorId(detalleid, carritoid, cantidad);
    }
}
