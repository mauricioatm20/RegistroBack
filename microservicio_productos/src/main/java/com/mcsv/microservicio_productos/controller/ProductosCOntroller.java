package com.mcsv.microservicio_productos.controller;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcsv.microservicio_productos.model.Categoria;
import com.mcsv.microservicio_productos.model.Producto;
import com.mcsv.microservicio_productos.service.ProductosService;

@RestController
@CrossOrigin("*")
public class ProductosController {

    @Autowired
    private ProductosService productosService;


    @GetMapping("categorias")
    public ResponseEntity<List<Categoria>> categorias() {
        return ResponseEntity.ok(productosService.categorias());
    }

    @GetMapping(value = "productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> productoCategorias(@RequestParam("idCategoria") long idCategoria) {
        return new ResponseEntity<>(productosService.productosPorCategoria(idCategoria), HttpStatus.OK);
    }

    @GetMapping(value = "producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> productoCodigo(@RequestParam("idProducto") long idProducto) {
        return new ResponseEntity<>(productosService.productoPorCodigo(idProducto), HttpStatus.OK);
    }

    @PutMapping(value = "producto")
    public ResponseEntity<Void> actualizarStock(@RequestParam ("idProducto")long idProducto, @RequestParam("unidades") int unidades) {
        Producto producto = productosService.actualizarStock(idProducto, unidades);
        if (producto != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
