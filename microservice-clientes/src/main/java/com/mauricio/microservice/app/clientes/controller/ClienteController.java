package com.mauricio.microservice.app.clientes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mauricio.microservice.app.clientes.entities.Cliente;
import com.mauricio.microservice.app.clientes.service.ClienteService;

@CrossOrigin("*")
@RestController
public class ClienteController {


    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/autenticar")
    public Cliente autenticarCliente(@RequestParam String usuario,@RequestParam String password) {
        return clienteService.autenticarCliente(usuario, password);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarCliente(@RequestBody Cliente cliente) {
        if (clienteService.registrarCliente(cliente)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }   
    }
}
