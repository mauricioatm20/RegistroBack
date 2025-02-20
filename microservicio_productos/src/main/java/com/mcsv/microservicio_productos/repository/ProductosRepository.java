package com.mcsv.microservicio_productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcsv.microservicio_productos.model.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByIdCategoria(long idCategoria);
}
