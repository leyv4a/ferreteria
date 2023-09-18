package mx.itson.persistence;

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

            String sql = "INSERT INTO cliente(nombreCliente, email, contrasena)"
                    + "VALUES ('" + cliente.getNombreCliente() + "', '" + cliente.getEmail() + "'"
                    + ", '" + cliente.getContrasena() + "');";

            impactoDB(sql);

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
                throw new Exception("Debe indicar el clliente que desea modificar");
            }
            String sql = "UPDATE cliente SET contrasena ='" + cliente.getContrasena() +
                    "', nombreCliente = '" + cliente.getNombreCliente() + 
                    "', email = '" + cliente.getEmail() + 
                    "' WHERE email = '" + cliente.getEmail() +"'";
            impactoDB(sql);
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
                throw new Exception("Debe indicar el clliente que desea modificar");
            }
            String sql = "DELETE FROM cliente WHERE email = '" + cliente.getEmail() +"'";
            impactoDB(sql);
        } catch (Exception e) {
            throw e;
        }
    }   
    /*
    ** Creamos un metodo para buscar un cliente por su email
     */
    public Cliente buscarUsuarioPorEmail(String email) throws Exception{
        try {
            
            String sql= "SELECT * FROM clientes WHERE email = '"+ email + "'";
            consultarDB(sql);
            
            Cliente cliente = null;
            
            while(resultado.next()){
                cliente = new Cliente();
                cliente.setClienteID(resultado.getInt(1));
                cliente.setNombreCliente(resultado.getString(2));
                cliente.setEmail(resultado.getString(3));
                cliente.setContrasena(resultado.getString(4));
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
    public Collection<Cliente> listarClientes() throws Exception{
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
            }
            desconectarDB();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarDB();
            throw new Exception("Error del sistema");
        }
    }
}

