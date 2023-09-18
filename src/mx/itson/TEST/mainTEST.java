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
            clienteServices.crearCliente("Gsabriel","gabriel@leyv4a.com","12222222222");
        } catch (Exception e) {
            throw e;
        }
    }
}
