package com.app.market.init.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "elementos_pedido")
public class ElementosPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idElementoPedido;
    
    private long fkPedido;
    private int unidades;

    @ManyToOne()
    @JoinColumn(name = "fkProducto", referencedColumnName = "idProducto")
    private Producto producto;

}
