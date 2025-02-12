package com.app.market.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.market.init.entity.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuario(String idUsuario);
}
