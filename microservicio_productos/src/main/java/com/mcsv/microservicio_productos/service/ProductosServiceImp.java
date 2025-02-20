package com.mcsv.microservicio_productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcsv.microservicio_productos.model.Categoria;
import com.mcsv.microservicio_productos.model.Producto;
import com.mcsv.microservicio_productos.repository.CategoriasRepository;
import com.mcsv.microservicio_productos.repository.ProductosRepository;

@Service
public class ProductosServiceImp implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<Categoria> categorias() {

        return categoriasRepository.findAll();
    }

    @Override
    public List<Producto> productosPorCategoria(long idCategoria) {

        return productosRepository.findByIdCategoria(idCategoria);
    }

     @Override
    public Producto actualizarStock(long idProducto, int unidades) {

        Producto producto = productoPorCodigo(idProducto);

        if (producto != null && producto.getStock() >= unidades){
            producto.setStock(producto.getStock()-unidades);
            return productosRepository.save(producto);
            }
            return null;
        }

    @Override
    public Producto productoPorCodigo(long idProducto) {

        return productosRepository.findById(idProducto).orElse(null);
    }

    

}
