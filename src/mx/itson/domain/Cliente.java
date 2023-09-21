/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.domain;

import java.math.BigDecimal;

/**
 *
 * @author gabriel
 */
public class Cliente {

    private int clienteID;
    private String nombreCliente;
    private String email;
    private String contrasena;
    private BigDecimal saldo;

    
    
    public Cliente(int clienteID, String nombreCliente, String email, String contrasena, BigDecimal saldo) {
        this.clienteID = clienteID;
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }

    public Cliente() {
    }
    
    
    
    /**
     * @return the clienteID
     */
    public int getClienteID() {
        return clienteID;
    }

    /**
     * @param clienteID the clienteID to set
     */
    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the saldo
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteID=" + clienteID + ", nombreCliente=" + nombreCliente + ", email=" + email + ", saldo=" + saldo + '}';
    }

    
}
