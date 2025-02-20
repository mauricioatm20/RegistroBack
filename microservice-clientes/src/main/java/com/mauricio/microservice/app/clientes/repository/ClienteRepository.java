package com.mauricio.microservice.app.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.microservice.app.clientes.entities.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
    Cliente findByUsuarioAndPassword(String usuario, String password);

}
