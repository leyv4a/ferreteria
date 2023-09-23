/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.services;

import java.math.BigDecimal;
import java.util.List;
import mx.itson.domain.Cliente;
import mx.itson.domain.Compra;
import mx.itson.persistence.CompraDAO;

/**
 *
 * @author gabri
 */
public class CompraService {
    
      private CompraDAO compraDAO;

    public CompraService() {
        this.compraDAO = new CompraDAO();
    }

    public void agregarCompra(Compra compra) throws Exception {
        try {
            compraDAO.agregarCompra(compra);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Compra> listarComprasPorCliente(Cliente cliente) throws Exception {
        try {
            return compraDAO.listarComprasPorCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean verificarSaldo(Cliente cliente, Double total){
       return compraDAO.verificarSaldo(cliente, total);
    }
}
