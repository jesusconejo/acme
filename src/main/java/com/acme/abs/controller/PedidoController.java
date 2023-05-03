package com.acme.abs.controller;

import com.acme.abs.dto.PedidoDTO;
import com.acme.abs.dto.RespuestaSOAP;
import com.acme.abs.service.AbastecimientoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ACME/api/v1")
public class PedidoController {

    @Autowired
    private AbastecimientoService service;

    @ApiOperation(value = "Enviar Pedido", notes = "Enviar Pedido Acme")
    @PostMapping(path = "/enviarPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> enviarPedido(@RequestBody PedidoDTO request) throws Exception{
        return  service.enviarPedido(request);
    }

    @ApiOperation(value = "recibirEnvio", notes = "Respuesta de pedido")
    @GetMapping(path = "/recibirEnvio")
    public ResponseEntity<RespuestaSOAP> enviarPedido() throws Exception{
        return  service.recibirRespuesta();
    }
}
