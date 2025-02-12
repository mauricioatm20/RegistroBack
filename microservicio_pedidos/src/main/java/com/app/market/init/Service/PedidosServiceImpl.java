package com.app.market.init.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.market.init.entity.ElementosPedido;
import com.app.market.init.entity.Pedido;
import com.app.market.init.repository.ElementosPedidoRepository;
import com.app.market.init.repository.PedidosRepository;

public class PedidosServiceImpl implements PedidosService {
    String urlProductos = "http://localhost:8082";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PedidosRepository pedidosRepository;
    
    @Autowired
    ElementosPedidoRepository elementosPedidoRepository;

    @Override
    public List<Pedido> pedidosUsuario(String usuario) {
        return pedidosRepository.findByUsuario(usuario);
    }

    @Override
    public Pedido guardarPedido(List<ElementosPedido> elementosPedido, String usuario) {

        try{
        //creamos objeto pedido
        Pedido pedido = new Pedido(
            0,
            usuario,
            new Date(),
            "PENDIENTE",
            null
        );
        Pedido p= pedidosRepository.save(pedido);

        //guardamos los elementos del pedido
        elementosPedido.forEach(e->{
            e.setIdPedido(p.getIdPedido());
            elementosPedidoRepository.save(e);
            //ademas de guardar el elemento pedido,
            //actualiza el del producto correspondiente llamando al recurso
            //del microservicio de productos
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlProductos + "productos").queryParam("idProducto", e.getProducto().getIdProducto())
            .queryParam("unidades", e.getUnidades());
            restTemplate.put(builder.toUriString(),null);
        });
        return pedido;
    }catch(Exception e){
        return null;
    }
    }

}
