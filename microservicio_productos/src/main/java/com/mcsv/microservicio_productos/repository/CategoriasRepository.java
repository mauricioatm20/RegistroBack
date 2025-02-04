package com.mcsv.microservicio_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcsv.microservicio_productos.model.Categoria;

@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
