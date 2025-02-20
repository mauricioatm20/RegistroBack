package com.app.market.init.entity;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;
    private String usuario;

    @JsonFormat(pattern = "dd/yyyy/MM")
    private Date fecha;
    private String estado;

    @OneToMany
    @JoinColumn(name = "fkPedido", referencedColumnName = "idPedido")
    private List<ElementosPedido> elementosPedido;
}
