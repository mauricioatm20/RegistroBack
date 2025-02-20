package com.app.market.init.Service;

import java.util.List;

import com.app.market.init.entity.ElementosPedido;
import com.app.market.init.entity.Pedido;

public interface PedidosService {

    List<Pedido> pedidosUsuario(String usuario);
    Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario);
}
