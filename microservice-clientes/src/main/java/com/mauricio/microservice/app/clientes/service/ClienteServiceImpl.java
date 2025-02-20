package com.mauricio.microservice.app.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.microservice.app.clientes.entities.Cliente;
import com.mauricio.microservice.app.clientes.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public Cliente autenticarCliente(String usuario, String password) {
        return clienteRepository.findByUsuarioAndPassword(usuario, password);
    }

    @Override
    public boolean registrarCliente(Cliente cliente) {
        if(clienteRepository.findById(cliente.getUsuario()).isPresent()){
            return false;
        }
        clienteRepository.save(cliente);
        return true;
    }

}
