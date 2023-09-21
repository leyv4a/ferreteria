/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.TEST;

import mx.itson.services.ClienteService;

/**
 *
 * @author gabri
 */
public class mainTEST {
    public static void main(String[] args) throws Exception {
     
        ClienteService clienteServices = new ClienteService();
        
        try {
//            clienteServices.crearCliente("Gsabriel","gabriel@leyv4a.scom","12222222222");
//clienteServices.buscarClientePorEmail("gabriel@leyv4a.scom");
//clienteServices.modificarCliente("gabriel@leyv4a.scom", "5551123123", "Gabirle2");
//clienteServices.consultarSaldo("JJ@yahoo.com");
clienteServices.autentificacion("JJ@yahooo.com", "password1");
          
        } catch (Exception e) {
            throw e;
        }
    }
}
