package com.acme.abs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PedidoDTO {
    @JsonProperty("pedido")
    private Integer numPedido;
    @JsonProperty("Cantidad")
    private Integer cantidadPedido;
    @JsonProperty("EAN")
    private String codigoEAN;
    @JsonProperty("Producto")
    private String nombreProducto;
    @JsonProperty("Cedula")
    private String numDocumento;
    @JsonProperty("Dirccion")
    private String direccion;


}
