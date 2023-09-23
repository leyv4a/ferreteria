/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mx.itson.domain.Cliente;
import mx.itson.domain.Compra;

/**
 *
 * @author gabri
 */
public class CompraDAO extends DAO{
     public void agregarCompra(Compra compra) throws Exception {
        conectarDB();
        try {
            String query = "INSERT INTO Compra (fechaCompra, clienteID) VALUES (NOW(), ?)";
            pst = conn.prepareStatement(query);
//            pst.setObject(1, compra.getFechaCompra());
//          pst.setString(2, compra.getEstado());
            pst.setInt(1, compra.getCliente().getClienteID());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }

    public List<Compra> listarComprasPorCliente(Cliente cliente) throws Exception {
        List<Compra> compras = new ArrayList<>();
        conectarDB();
        try {
            String query = "SELECT compraID, fechaCompra, estado FROM Compra WHERE clienteID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, cliente.getClienteID());
            resultado = pst.executeQuery();
            while (resultado.next()) {
                int compraID = resultado.getInt("compraID");
                LocalDateTime fechaCompra = resultado.getObject("fechaCompra", LocalDateTime.class);
                String estado = resultado.getString("estado");
                Compra compra = new Compra(compraID, fechaCompra, estado, cliente);
                compras.add(compra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDB();
        }
        return compras;
    }
    
    public boolean verificarSaldo(Cliente cliente, Double total){
        Double uno = cliente.getSaldo().doubleValue();
        if (uno > total) {
        return true;    
        }else{
            return false;
        }
        
//       return cliente.getSaldo().compareTo(total) >=0;
    }
}
