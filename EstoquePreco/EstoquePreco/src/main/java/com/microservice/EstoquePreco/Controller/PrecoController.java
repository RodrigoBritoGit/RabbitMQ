package com.microservice.EstoquePreco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.EstoquePreco.Constants.RabbitMQConstants;
import com.microservice.EstoquePreco.Service.RabbitMQService;
import com.microservice.EstoquePreco.dto.PrecoDto;

@RestController
@RequestMapping(value = "preco")
public class PrecoController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraPreco(@RequestBody PrecoDto precoDto) {
        System.out.println(precoDto.getCodigoProduto());
        System.out.println(precoDto.getPreco());
        this.rabbitMQService.enviaMensagem(RabbitMQConstants.FILA_PRECO, precoDto);
        return new ResponseEntity(HttpStatus.OK);

    }

}
