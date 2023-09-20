package mx.itson.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import mx.itson.domain.Cliente;

/**
 *
 * @author gabri
 */
public final class ClienteDAO extends DAO {

    /*
    ** Creamos un metodo para guardar nuevos clientes
     */
    public void guardarCliente(Cliente cliente) throws Exception {

        try {
            if (cliente == null) {
                throw new Exception("Debe indicar un cliente");
            }
            String query = "INSERT INTO cliente(nombreCliente, email, contrasena) VALUES (?, ?, ?)";
            conectarDB();
            pst = conn.prepareStatement(query);
            pst.setString(1, cliente.getNombreCliente());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getContrasena());
            pst.executeUpdate();
            desconectarDB();

        } catch (Exception e) {
            throw e;
        }
    }
    /*
    ** Creamos un metodo para modificar clientes
     */
    public void modificarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar el cliente que desea modificar");
            }
            String query = "UPDATE cliente SET contrasena = ?, nombreCliente = ?WHERE email = ? ";
            pst = conn.prepareStatement(query);
            pst.setString(1,cliente.getContrasena());
            pst.setString(2,cliente.getNombreCliente());
            pst.setString(3, cliente.getEmail());
            pst.executeUpdate();
            
            desconectarDB();
                   
//          
        } catch (Exception e) {
            throw e;
        }
    }

    /*
    ** Creamos un metodo para eliminar un cliente
     */
    public void eliminarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar el cliente que desea modificar");
            }
            String query = "DELETE FROM cliente WHERE email = ?";
          pst = conn.prepareStatement(query);
          pst.setString(1,cliente.getEmail());
          pst.executeUpdate();
          desconectarDB();
        } catch (Exception e) {
            throw e;
        }
    }

    /*
    ** Creamos un metodo para buscar un cliente por su email
     */
    public Cliente buscarClientePorEmail(String email) throws Exception {
        try {

            String query = "SELECT * FROM clientes WHERE email = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, email);
            resultado = pst.executeQuery();
            Cliente cliente = null;

            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setClienteID(resultado.getInt(1));
                cliente.setNombreCliente(resultado.getString(2));
                cliente.setEmail(resultado.getString(3));
                cliente.setContrasena(resultado.getString(4));
                cliente.setSaldo(resultado.getBigDecimal(5));
            }
            desconectarDB();
            return cliente;

        } catch (Exception e) {

            desconectarDB();
            throw e;
        }
    }

    /*
    ** Creamos un metodo para listar los clientes
     */
    public Collection<Cliente> listarClientes() throws Exception {
        try {
            String sql = "SELECT nombreCliente, email, saldo FROM cliente";
            consultarDB(sql);

            Cliente cliente = null;
            Collection<Cliente> clientes = new ArrayList();
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setNombreCliente(resultado.getString(1));
                cliente.setEmail(resultado.getString(2));
                cliente.setSaldo(resultado.getBigDecimal(3));
                clientes.add(cliente);
                System.out.println(cliente.getNombreCliente());
                System.out.println(cliente.getEmail());
                System.out.println(cliente.getSaldo());
                       
            }
            desconectarDB();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw new Exception("Error del sistema");
        }
    }
  
    //agregar metodo para consultar saldo
    
    //agregar metodo para login de cliente
    
    //agregar metodo para registrar cliente
}
