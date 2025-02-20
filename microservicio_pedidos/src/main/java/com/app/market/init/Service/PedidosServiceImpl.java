package com.app.market.init.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.market.init.entity.ElementosPedido;
import com.app.market.init.entity.Pedido;
import com.app.market.init.repository.ElementosPedidoRepository;
import com.app.market.init.repository.PedidosRepository;
@Service
public class PedidosServiceImpl implements PedidosService {
    String urlProductos = "http://localhost:8084";

    @Autowired
    RestClient restClient;

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
            "pendiente",
            null
        );
        Pedido p= pedidosRepository.save(pedido);

        //guardamos los elementos del pedido
        elementosPedido.forEach(e->{
            e.setFkPedido(p.getIdPedido());
            elementosPedidoRepository.save(e);
            //ademas de guardar el elemento pedido,
            //actualiza el del producto correspondiente llamando al recurso
            //del microservicio de productos
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("productos" + urlProductos)
            .queryParam("idProducto", e.getProducto().getIdProducto())
            .queryParam("unidades", e.getUnidades());
            restClient.put().uri(builder.toUriString())
            .retrieve();
        });
        return pedido;
    }catch(Exception e){
        return null;
    }
    }

}
