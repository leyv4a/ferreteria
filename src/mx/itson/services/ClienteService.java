
package mx.itson.services;

import mx.itson.domain.Cliente;
import mx.itson.persistence.ClienteDAO;

/**
 *
 * @author gabri
 */
public class ClienteService {
    
    private ClienteDAO dao;
    
    public ClienteService(){
        this.dao = new ClienteDAO();
    }
    
    public void crearCliente(String nombreCliente, String email, String contrasena) throws Exception{
        try {
            //Inicia la validacion
            if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (email == null || email.trim().isEmpty())  {
                throw new Exception("Debe indicar un correo electronico");                
            }
            if (email.contains("@") == false) {
                throw new Exception("El correo electronico no es valido");
            }
            if (contrasena.length()< 10) {
                throw new Exception("La contraseña debe tener al menos 10 caracteres");
            }
            
            //Se crea el cliente
            Cliente cliente = new Cliente();
            cliente.setNombreCliente(nombreCliente);
            cliente.setEmail(email);
            cliente.setContrasena(contrasena);
            dao.guardarCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }
}
