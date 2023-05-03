package com.acme.abs.service;

import com.acme.abs.dto.PedidoDTO;
import com.acme.abs.dto.RespuestaSOAP;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

@Service
public class AbastecimientoService implements IAbastecimiento {

    @Value("${endpoint.acme}")
    private String soap;

    @Override
    public ResponseEntity enviarPedido(PedidoDTO request) throws JsonProcessingException {
        //Validaciones
        PedidoDTO pedidoDTO = request;

        // Transformar el objeto Pedido a formato XML
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(pedidoDTO);

        // Retornar la respuesta en formato XML
        return ResponseEntity.status(HttpStatus.OK).body(xml);
    }

    @Override
    public ResponseEntity<RespuestaSOAP> recibirRespuesta() {
        RestTemplate template = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        RespuestaSOAP respuestaSOAP = null;
        try {
            URL xmlURL = new URL(soap);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlURL.openStream());
            respuestaSOAP = new RespuestaSOAP();
            respuestaSOAP.setEstado(document.getElementsByTagName("Mensaje").item(0).getTextContent());
            respuestaSOAP.setCodigoEnvio(Integer.valueOf(document.getElementsByTagName("Codigo").item(0).getTextContent()));
            json = objectMapper.writeValueAsString(respuestaSOAP);
            return new ResponseEntity<>(respuestaSOAP, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(respuestaSOAP, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
