package com.acme.abs.service;

import com.acme.abs.dto.PedidoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface IAbastecimiento {

    ResponseEntity enviarPedido(PedidoDTO request) throws JsonProcessingException;

    ResponseEntity recibirRespuesta();
}
