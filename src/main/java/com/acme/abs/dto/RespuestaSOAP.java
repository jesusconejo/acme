package com.acme.abs.dto;


import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data

@XmlRootElement(name = "respuesta")
public class RespuestaSOAP {
    @XmlElement(name = "pedido")
    private String numPedido;
    @XmlElement(name = "Codigo")
    private Integer codigoEnvio;
    @XmlElement(name = "Mensaje")
    private String estado;
}
