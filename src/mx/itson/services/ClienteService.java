package mx.itson.services;

import mx.itson.domain.Cliente;
import mx.itson.persistence.ClienteDAO;

/**
 *
 * @author gabri
 */
public class ClienteService {

    private ClienteDAO dao;

    public ClienteService() {
        this.dao = new ClienteDAO();
    }

    public void crearCliente(String nombreCliente, String email, String contrasena) throws Exception {
        try {
            //Inicia la validacion
            if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electronico");
            }
            if (email.contains("@") == false) {
                throw new Exception("El correo electronico no es valido");
            }
            if (contrasena.length() < 10) {
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

    public void modificarCliente(String email, String nuevaContrasena, String nuevoNombre) throws Exception {
        try {
            // Realiza la validación de los datos, similar a la de crearCliente
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electrónico");
            }
            if (nuevaContrasena == null || nuevaContrasena.length() < 10) {
                throw new Exception("La nueva contraseña debe tener al menos 10 caracteres");
            }

            // Se crea un objeto Cliente con los nuevos datos
            Cliente cliente = new Cliente();
            cliente.setEmail(email);
            cliente.setContrasena(nuevaContrasena);
            cliente.setNombreCliente(nuevoNombre);

            // Llama al método para modificar el cliente
            dao.modificarCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarCliente(String email) throws Exception {
        try {
            // Realiza la validación del email
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electrónico");
            }

            //se crea un objecto cliente
            Cliente cliente = new Cliente();
            cliente.setEmail(email);
            // Llama al método para eliminar el cliente
            dao.eliminarCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente buscarClientePorEmail(String email) throws Exception {
        try {
            // Realiza la validación del email
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electrónico");
            }

            // Llama al método para buscar el cliente por email
            return dao.buscarClientePorEmail(email);
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente consultarSaldo(String email) throws Exception {
        try {

            //validamos el email
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electronico");
            }
            //Llamamos al metodo para consultar saldo por email
            return dao.consultarSaldo(email);
        } catch (Exception e) {
            throw e;
        }

    }

    public Cliente autentificacion(String email, String contrasena) throws Exception {
        try {

            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electronico");
            }
            if (contrasena == null || contrasena.trim().isEmpty()) {
                throw new Exception("Debe indicar una contraseña");
            }
                      //se llama al metodo para autentificar
           return dao.autentificacion(email, contrasena);
        } catch (Exception e) {
            throw e;
        }

    }

}
