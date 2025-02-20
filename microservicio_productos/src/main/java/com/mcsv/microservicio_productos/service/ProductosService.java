package com.mcsv.microservicio_productos.service;

import java.util.List;

import com.mcsv.microservicio_productos.model.Categoria;
import com.mcsv.microservicio_productos.model.Producto;

public interface ProductosService {

    List<Categoria> categorias();
    List<Producto> productosPorCategoria(long idCategoria);
    Producto actualizarStock(long idProducto, int unidades);
    Producto productoPorCodigo(long idProducto);
}
