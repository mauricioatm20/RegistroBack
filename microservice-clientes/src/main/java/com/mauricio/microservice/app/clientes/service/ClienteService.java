package com.mauricio.microservice.app.clientes.service;



import com.mauricio.microservice.app.clientes.entities.Cliente;

public interface ClienteService {

    Cliente autenticarCliente(String usuario, String password);

    boolean registrarCliente(Cliente cliente);
}
